package com.github.erodriguezg.sqlcli.executors;

import java.io.File;

/**
 * Created by eduar on 03/06/2017.
 */
public interface Executor {

    boolean matchForStatement(String statement);

    boolean matchForScript(File file);

    void executeStatement(String statement);

    void executeScriptFile(File file);
}
