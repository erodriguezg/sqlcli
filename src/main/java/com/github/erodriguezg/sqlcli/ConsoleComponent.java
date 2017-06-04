package com.github.erodriguezg.sqlcli;

import com.github.erodriguezg.sqlcli.datasource.DataSource;
import com.github.erodriguezg.sqlcli.datasource.DataSourceFactory;
import com.github.erodriguezg.sqlcli.executors.Executor;
import com.github.erodriguezg.sqlcli.executors.ExecutorFactory;
import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

/**
 * Created by erodriguezg on 02-06-17.
 */
@Component
public class ConsoleComponent {

    private static final String OPTION_JDBC_URL = "jdbcUrl";
    private static final String OPTION_USER = "user";
    private static final String OPTION_PASS = "password";
    private static final String OPTION_STATEMENT = "statement";
    private static final String OPTION_SCRIPT_FILE = "scriptFile";

    @Autowired
    private Logger log;

    @Autowired
    private DataSourceFactory dataSourceFactory;

    @Autowired
    private ExecutorFactory executorFactory;

    private Options options;

    @PostConstruct
    public void iniciar() {
        log.info("iniciando console component");

        options = new Options();
        // add t option
        options.addOption(OPTION_JDBC_URL, true, "Jdbc Url for connection");
        options.addOption(OPTION_USER, true, "Username for connection");
        options.addOption(OPTION_PASS, true, "Password for connection");
        options.addOption(OPTION_STATEMENT, true, "Statement to execute");
        options.addOption(OPTION_SCRIPT_FILE, true, "Script file to execute");
    }

    public void procesar(String[] args) {
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            throw new IllegalStateException(e);
        }

        //validaciones
        List<String> requiredOptions = Arrays.asList(OPTION_JDBC_URL, OPTION_USER, OPTION_PASS);
        boolean validRequiredOptions = requiredOptions.stream().allMatch(option -> cmd.hasOption(option));
        if(!validRequiredOptions) {
            log.info("These options are required: {}", requiredOptions);
            return;
        }

        DataSource dataSource = getDataSource(cmd);
        List<Executor> executors =getExecutors(cmd, dataSource);

        executors.stream().forEach(executor -> executor.execute());
    }

    private DataSource getDataSource(CommandLine cmd) {
        String jdbcUrl = cmd.getOptionValue(OPTION_JDBC_URL);
        String username = cmd.getOptionValue(OPTION_USER);
        String password = cmd.getOptionValue(OPTION_PASS);
        return dataSourceFactory.getDataSource(jdbcUrl, username, password);
    }

    private List<Executor> getExecutors(CommandLine cmd, DataSource dataSource) {
        String[] statements = cmd.getOptionValues(OPTION_STATEMENT);
        String[] scriptsFiles = cmd.getOptionValues(OPTION_SCRIPT_FILE);
        return executorFactory.getExecutors(statements, scriptsFiles, dataSource);
    }

}
