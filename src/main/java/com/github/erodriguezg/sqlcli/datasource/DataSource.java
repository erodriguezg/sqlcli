package com.github.erodriguezg.sqlcli.datasource;

import java.sql.Connection;

/**
 * Created by eduar on 03/06/2017.
 */
public interface DataSource {
    boolean matchForJdbcUrl(String jdbcUrl);
    void iniciar(String jdbcUrl, String username, String password);
    Connection getConnection();
}
