package com.github.erodriguezg.sqlcli.connectionfactory;

import org.springframework.stereotype.Component;

/**
 * Created by eduar on 03/06/2017.
 */
@Component
public class ConnectionFactoryComponent {

    public enum TipoBaseDatos {POSTGRESQL, ORACLE, MYSQL}

    public ConnectionFactory getConnectorFactory(String jdbcUrl, String username, String password) {
        TipoBaseDatos tipoBaseDatos = getTipoBaseDatos(jdbcUrl);
        switch (tipoBaseDatos) {
            case POSTGRESQL:
                return new PostgreSqlFactory(jdbcUrl, username, password);
            case ORACLE:
                return new OracleSqlFactory(jdbcUrl, username, password);
            default:
                throw new UnsupportedOperationException();
        }
    }

    private TipoBaseDatos getTipoBaseDatos(String jdbcUrl) {
        throw new UnsupportedOperationException();
    }
}
