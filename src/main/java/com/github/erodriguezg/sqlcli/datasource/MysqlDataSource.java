package com.github.erodriguezg.sqlcli.datasource;

/**
 * Created by eduar on 03/06/2017.
 */
public class MysqlDataSource extends AbstractDataSource {
    @Override
    public boolean matchForJdbcUrl(String jdbcUrl) {
        return jdbcUrl != null && jdbcUrl.trim().startsWith("jdbc:mysql://");
    }

    @Override
    protected void cargarDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }
}
