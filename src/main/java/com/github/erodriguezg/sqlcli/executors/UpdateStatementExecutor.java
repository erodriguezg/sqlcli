package com.github.erodriguezg.sqlcli.executors;

import com.github.erodriguezg.sqlcli.datasource.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by erodriguezg on 05-06-17.
 */
public class UpdateStatementExecutor extends AbstractDatasourceExecutor {

    private static final Logger LOG = LoggerFactory.getLogger(UpdateStatementExecutor.class);

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
        try(Connection connection = getConnection();
            Statement sqlStatement = connection.createStatement()) {
            sqlStatement.execute(statement);
            LOG.info("executado: {}", statement);
        }catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void executeScriptFile(File file) {
        //no hace nada
    }

}
