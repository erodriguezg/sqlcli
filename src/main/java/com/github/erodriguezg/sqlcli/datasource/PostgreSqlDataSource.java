package com.github.erodriguezg.sqlcli.datasource;

/**
 * Created by eduar on 03/06/2017.
 */
public class PostgreSqlDataSource extends AbstractDataSource {

    @Override
    public boolean matchForJdbcUrl(String jdbcUrl) {
        return jdbcUrl != null && jdbcUrl.trim().startsWith("jdbc:postgresql://");
    }

    @Override
    protected void cargarDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

}
