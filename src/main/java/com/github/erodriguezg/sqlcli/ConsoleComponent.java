package com.github.erodriguezg.sqlcli;

import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by erodriguezg on 02-06-17.
 */
@Component
public class ConsoleComponent {

    @Autowired
    private Logger log;


    private Options options;

    @PostConstruct
    public void iniciar() {
        log.info("iniciando console component");

        options = new Options();
        // add t option
        options.addOption("jdbcUrl", true, "Jdbc Url for connection");
        options.addOption("user", true, "Username for connection");
        options.addOption("password", true, "Password for connection");
        options.addOption("statement", true, "Statement to execute");
        options.addOption("scriptFile", true, "Script file to execute");
        options.addOption("database", true, "supported values: oracle12c, oracle11g, postgres9");
    }


    public void procesar(String[] args) {
        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;
        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            throw new IllegalStateException(e);
        }

        if (cmd.hasOption("t")) {
            // print the date and time
        } else {
            // print the date
        }
    }


}
