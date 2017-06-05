package com.github.erodriguezg.sqlcli.executors;

import com.github.erodriguezg.sqlcli.datasource.DataSource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * Created by eduar on 03/06/2017.
 */
@Component
public class ExecutorFactory {

    public void runExecutors(String[] statements, String[] scriptsFiles, DataSource dataSource) {
        List<Executor> executors = getExecutors(dataSource);
        if (executors == null || executors.isEmpty()) {
            throw new IllegalStateException("No existen executors!");
        }
        executeStatements(statements, executors);
        executeScriptsFiles(scriptsFiles, executors);
    }

    private void executeStatements(String[] statements, List<Executor> executors) {
        if (statements == null) {
            return;
        }
        for (String statement : statements) {
            for (Executor executor : executors) {
                if (executor.matchForStatement(statement)) {
                    executor.executeStatement(statement);
                }
            }
        }
    }

    private void executeScriptsFiles(String[] scriptsFiles, List<Executor> executors) {
        if (scriptsFiles == null) {
            return;
        }
        for (String scriptFile : scriptsFiles) {
            File file = new File(scriptFile);
            for (Executor executor : executors) {
                if (executor.matchForScript(file)) {
                    executor.executeScriptFile(file);
                }
            }
        }
    }

    public List<Executor> getExecutors(DataSource dataSource) {
        return Arrays.asList(new SelectStatementExecutor(dataSource),
                new UpdateStatementExecutor(dataSource),
                new ScriptFileExecutor(dataSource));
    }
}
