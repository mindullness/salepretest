package com.aptech.api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.aptech.api.models.Customer;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, String>, CrudRepository<Customer, String>{
    
}
