package com.maskibail.customer;

import com.maskibail.customer.domain.Customer;
import com.maskibail.customer.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ApiControllerITest {
    private static final Logger LOG = LoggerFactory.getLogger(ApiControllerITest.class);

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void testOne() {
        if (customerRepository != null) {
            Iterable<Customer> customers = customerRepository.findAll();

            if (!customers.iterator().hasNext()) {
                // Hurray!!!  Test container configs work!!!!!
                LOG.info("returned empty collection");
            }
        }
    }
}
