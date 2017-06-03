package com.github.erodriguezg.sqlcli.connectionfactory;

import java.sql.Connection;

/**
 * Created by eduar on 03/06/2017.
 */
public interface ConnectionFactory {
    Connection getConnection();
}
