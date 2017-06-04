package com.github.erodriguezg.sqlcli.executors;

import com.github.erodriguezg.sqlcli.datasource.DataSource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by eduar on 03/06/2017.
 */
@Component
public class ExecutorFactory {

    public List<Executor> getExecutors(String[] statements, String[] scriptsFiles, DataSource dataSource) {
        return null;
    }

}
