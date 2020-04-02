package com.maskibail.java.demo.controller;

import com.maskibail.java.demo.domain.Customer;
import com.maskibail.java.demo.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class ServiceController {
    public static final Logger LOG = LoggerFactory.getLogger(ServiceController.class);

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping(value = "/all")
    public @ResponseBody
    Iterable<Customer> allCustomers() {
        LOG.info("Fetching all customers from the database");
        return customerRepository.findAll();
    }

    @PostMapping(path = "/addCustomer")
    public String addNewCustomer(
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String title,
            @RequestParam String phone
    ) {
        Customer customer = new Customer();
        customer.setTitle(title);
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setPhone(phone);
        customer.setCreateDate(new Date());
        customerRepository.save(customer);

        LOG.info("Persisted user {}, {} with id {} successfully", firstName, lastName, customer.getId());
        return String.format("Saved the customer %s, %s successfully", firstName, lastName);
    }

    @GetMapping(value = "/liveness")
    public String health() {
        LOG.info("Service is alive");
        return "OK";
    }

    @GetMapping(value = "/readiness")
    public String readiness() {
        LOG.info("Service has booted...");
        return "OK";
    }
}
