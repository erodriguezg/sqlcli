package com.github.erodriguezg.sqlcli.datasource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by eduar on 03/06/2017.
 */
public abstract class AbstractDataSource implements DataSource {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractDataSource.class);

    private String jdbcUrl;
    private String username;
    private String password;

    @Override
    public void iniciar(String jdbcUrl, String username, String password) {
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;
        cargarDriver();
        LOG.info("Conectado a {}, username: {}, password: {}", jdbcUrl, username, password);
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
