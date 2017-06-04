package com.github.erodriguezg.sqlcli.datasource;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by eduar on 03/06/2017.
 */
@Component
public class DataSourceFactory {

    public DataSource getDataSource(String jdbcUrl, String username, String password) {
        Optional<DataSource> optional = getDataSources().stream()
                .filter(dataSource -> dataSource.matchForJdbcUrl(jdbcUrl))
                .findFirst();
        if(optional.isPresent()) {
            return optional.get();
        }
        throw new IllegalStateException("No datasource match for jdbc url: " + jdbcUrl);
    }

    List<DataSource> getDataSources() {
        return Arrays.asList(new MysqlDataSource(), new OracleSqlDataSource(), new PostgreSqlDataSource());
    }

}
