package com.maskibail.customer;

import com.maskibail.customer.repository.CustomerRepository;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testcontainers.containers.MySQLContainer;


@RunWith(SpringRunner.class)
@DataJpaTest
@ContextConfiguration(initializers = {ApiControllerITest.Initializer.class})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ApiControllerITest {
    @ClassRule
    public static final MySQLContainer MY_SQL_CONTAINER = new MySQLContainer();
    private static final Logger LOG = LoggerFactory.getLogger(ApiControllerITest.class);

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void testOne() {

        if (customerRepository != null) {
            customerRepository.findAll().forEach(s -> System.out.println(s.toString()));
        }
    }

    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            if(MY_SQL_CONTAINER.isRunning()!= true) {
                MY_SQL_CONTAINER.start();
            }

            TestPropertyValues.of(
                    "spring.datasource.url=" + MY_SQL_CONTAINER.getJdbcUrl(),
                    "spring.datasource.username=" + MY_SQL_CONTAINER.getUsername(),
                    "spring.datasource.password=" + MY_SQL_CONTAINER.getPassword())
                    .applyTo(configurableApplicationContext.getEnvironment());
        }
    }
}
