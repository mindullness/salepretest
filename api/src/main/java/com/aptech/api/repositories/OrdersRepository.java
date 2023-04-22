package com.aptech.api.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.aptech.api.models.Customer;
import com.aptech.api.models.Orders;

public interface OrdersRepository extends
        PagingAndSortingRepository<Orders, Integer>,
        CrudRepository<Orders, Integer> {
    // @Query(name = "SELECT * FROM Orders WHERE Code = :code", nativeQuery = true)
    public List<Orders> findByCustomer(Customer code);
}
