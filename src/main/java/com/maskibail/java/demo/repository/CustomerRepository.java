package com.maskibail.java.demo.repository;

import com.maskibail.java.demo.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
