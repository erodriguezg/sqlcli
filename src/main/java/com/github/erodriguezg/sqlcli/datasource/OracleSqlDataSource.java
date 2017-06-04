package com.github.erodriguezg.sqlcli.datasource;

/**
 * Created by eduar on 03/06/2017.
 */
public class OracleSqlDataSource extends AbstractDataSource {

    @Override
    public boolean matchForJdbcUrl(String jdbcUrl) {
        return jdbcUrl != null && jdbcUrl.trim().startsWith("jdbc:oracle:thin:@");
    }

    @Override
    protected void cargarDriver() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }
}
