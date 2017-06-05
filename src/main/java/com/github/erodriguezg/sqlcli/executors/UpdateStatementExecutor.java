package com.github.erodriguezg.sqlcli.executors;

import com.github.erodriguezg.sqlcli.datasource.DataSource;

import java.io.File;

/**
 * Created by erodriguezg on 05-06-17.
 */
public class UpdateStatementExecutor extends AbstractDatasourceExecutor {

    public UpdateStatementExecutor(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public boolean matchForStatement(String statement) {
        if (statement == null) {
            return false;
        }
        String statementAux = statement.trim().toLowerCase();
        return statementAux.startsWith("insert ") || statementAux.startsWith("update ");
    }

    @Override
    public boolean matchForScript(File file) {
        return false;
    }

    @Override
    public void executeStatement(String statement) {
        //TODO:falta implementar
    }

    @Override
    public void executeScriptFile(File file) {
        //no hace nada
    }

}
