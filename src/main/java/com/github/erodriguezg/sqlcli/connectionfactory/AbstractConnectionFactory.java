package com.github.erodriguezg.sqlcli.connectionfactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by eduar on 03/06/2017.
 */
public abstract class AbstractConnectionFactory implements ConnectionFactory {

    private DataSource dataSource;

    public AbstractConnectionFactory(String jdbcUrl, String username, String password) {

    }

    public Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
