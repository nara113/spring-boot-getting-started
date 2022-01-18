package com.study.h2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Component
public class H2Runner implements ApplicationRunner {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try(Connection connection = dataSource.getConnection()) {
            System.out.println(connection.getClass());
            System.out.println(connection.getMetaData().getURL());
            System.out.println(connection.getMetaData().getUserName());

            final Statement statement = connection.createStatement();
            final String SQL = "CREATE TABLE USERR(idd INTEGER NOT NULL, namee VARCHAR(255), PRIMARY KEY (idd))";
            statement.executeUpdate(SQL);
        }

        jdbcTemplate.execute("INSERT INTO USERR VALUES(1, 'ME')");

    }
}
