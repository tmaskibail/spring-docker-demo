package com.maskibail.customer.repository;


import com.maskibail.customer.domain.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
