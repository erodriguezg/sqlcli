package com.github.erodriguezg.sqlcli.connectionfactory;

import java.sql.Connection;

/**
 * Created by eduar on 03/06/2017.
 */
public class PostgreSqlFactory extends AbstractConnectionFactory {

    public PostgreSqlFactory(String jdbcUrl, String username, String password) {
        super(jdbcUrl, username, password);
    }

}
