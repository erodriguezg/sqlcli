package com.github.erodriguezg.sqlcli.datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by eduar on 03/06/2017.
 */
public abstract class AbstractDataSource implements DataSource {

    private String jdbcUrl;
    private String username;
    private String password;

    public void iniciar(String jdbcUrl, String username, String password) {
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;
        cargarDriver();
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(this.jdbcUrl, this.username, this.password);
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    protected abstract void cargarDriver();
}
