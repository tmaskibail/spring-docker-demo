package com.maskibail.customer;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.testcontainers.containers.MySQLContainer;

import javax.sql.DataSource;

@Configuration
public class BaseDbConfig {

    @Bean
    public MySQLContainer mysqlContainer() {
        final MySQLContainer mysqlContainer = new MySQLContainer();
        mysqlContainer.start();
        return mysqlContainer;
    }

    @Bean
    public DataSource getDataSource(final MySQLContainer mysqlContainer) {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(mysqlContainer.getDriverClassName());
        dataSourceBuilder.url(mysqlContainer.getJdbcUrl());
        dataSourceBuilder.username(mysqlContainer.getUsername());
        dataSourceBuilder.password(mysqlContainer.getPassword());
        return dataSourceBuilder.build();
    }

}
