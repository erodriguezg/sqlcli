package com.github.erodriguezg.sqlcli.executors;

import com.github.erodriguezg.sqlcli.datasource.DataSource;

import java.sql.Connection;

/**
 * Created by erodriguezg on 05-06-17.
 */
public abstract class AbstractDatasourceExecutor implements Executor {

    private DataSource dataSource;

    public AbstractDatasourceExecutor(DataSource dataSource) {
        this.dataSource  = dataSource;
    }

    protected Connection getConnection() {
        return this.dataSource.getConnection();
    }

}
