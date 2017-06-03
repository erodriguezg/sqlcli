package com.github.erodriguezg.sqlcli;

import com.github.erodriguezg.sqlcli.connectionfactory.ConnectionFactory;
import com.github.erodriguezg.sqlcli.connectionfactory.ConnectionFactoryComponent;
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
    private ConnectionFactoryComponent connectionFactoryComponent;

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

        ConnectionFactory connectionFactory = getConnectionFactory(cmd);
        procesarScriptFiles(cmd.getOptionValues(OPTION_SCRIPT_FILE), connectionFactory);
        procesarStatements(cmd.getOptionValues(OPTION_STATEMENT), connectionFactory);
    }

    private void procesarScriptFiles(String[] scriptFiles, ConnectionFactory connectionFactory) {

    }

    private void procesarStatements(String[] statements, ConnectionFactory connectionFactory) {

    }
    private ConnectionFactory getConnectionFactory(CommandLine cmd) {
        String jdbcUrl = cmd.getOptionValue(OPTION_JDBC_URL);
        String username = cmd.getOptionValue(OPTION_USER);
        String password = cmd.getOptionValue(OPTION_PASS);
        return connectionFactoryComponent.getConnectorFactory(jdbcUrl, username, password);
    }

}
