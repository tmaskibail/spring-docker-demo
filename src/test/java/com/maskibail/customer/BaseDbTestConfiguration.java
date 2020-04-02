package com.maskibail.customer;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@TestConfiguration
public class BaseDbTestConfiguration {

//        @Bean
//        public PostgreSQLContainer postgreSQLContainer() {
//            final PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer();
//            postgreSQLContainer.start();
//            return postgreSQLContainer;
//        }
//        @Bean
//        public DataSource dataSource(final PostgreSQLContainer postgreSQLContainer) {
//            // Datasource initialization
//            ds.setJdbcUrl(postgreSQLContainer.getJdbcUrl());
//            ds.setUsername(postgreSQLContainer.getUsername());
//            ds.setPassword(postgreSQLContainer.getPassword());
//            ds.setDriverClassName(postgreSQLContainer.getDriverClassName());
//            // Additional parameters configuration omitted
//            return ds;
//        }
//        @Bean
//        public Liquibase liquibase(final DataSource dataSource) throws LiquibaseException, SQLException {
//            final Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(dataSource.getConnection()));
//            return new liquibase.Liquibase(Paths.get(“.”, this.get(“.”, PATH_TO_CHANGELOG_FILE)
//                    .normalize()
//                    .toAbsolutePath()
//                    .toString(), new FileSystemResourceAccessor(), database);
//        }database

}
