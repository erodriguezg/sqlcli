package com.github.erodriguezg.sqlcli.ant;

/**
 * Created by eduar on 03/06/2017.
 */

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.SQLExec;

import java.sql.Connection;

/**
 * @author rockman
 */
public class SqlAntTask extends SQLExec {

    private Connection con;

    public SqlAntTask(Connection con) {
        this.con = con;
        Project project = new Project();
        project.init();

        setProject(project);
        setTaskType("sql");
        setTaskName("sql");
        setEncoding("UTF-8");
    }

    @Override
    public Connection getConnection() {
        return con;
    }


}
