package com.github.erodriguezg.sqlcli.executors;

import com.github.erodriguezg.sqlcli.datasource.DataSource;

import java.io.File;

/**
 * Created by erodriguezg on 05-06-17.
 */
public class ScriptFileExecutor extends AbstractDatasourceExecutor {

    public ScriptFileExecutor(DataSource dataSource) {
        super(dataSource);
    }

    @Override
    public boolean matchForStatement(String statement) {
        return false;
    }

    @Override
    public boolean matchForScript(File file) {
        return true;
    }

    @Override
    public void executeStatement(String statement) {
        //no hace nada
    }

    @Override
    public void executeScriptFile(File file) {
        //TODO: falta implementar
    }

}
