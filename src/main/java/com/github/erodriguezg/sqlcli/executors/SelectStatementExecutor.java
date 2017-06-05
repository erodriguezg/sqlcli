package com.github.erodriguezg.sqlcli.executors;

import com.github.erodriguezg.sqlcli.datasource.DataSource;

import java.io.File;

/**
 * Created by erodriguezg on 05-06-17.
 */
public class SelectStatementExecutor extends AbstractDatasourceExecutor {

    public SelectStatementExecutor(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public boolean matchForStatement(String statement) {
        return statement != null && statement.trim().toLowerCase().startsWith("select ");
    }

    @Override
    public boolean matchForScript(File file) {
        return false;
    }

    @Override
    public void executeStatement(String statement) {
        //TODO: falta implementar
    }

    @Override
    public void executeScriptFile(File file) {
        //no hace nada
    }

}
