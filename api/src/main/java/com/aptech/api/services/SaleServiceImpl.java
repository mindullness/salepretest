package com.aptech.api.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aptech.api.models.Customer;
import com.aptech.api.models.Orders;
import com.aptech.api.repositories.CustomerRepository;
import com.aptech.api.repositories.OrdersRepository;

@Service(value = "saleService")
public class SaleServiceImpl implements SaleService{
    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private CustomerRepository customerRepository;
    
    @Override
    public List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().iterator().forEachRemaining(customers::add);
        return customers;
    }

    @Override
    public List<Orders> getOrdersByCode(String code) {
        Customer customer = new Customer().setCode(code);
        return ordersRepository.findByCustomer(customer);
    }

    @Override
    public Orders createOrders(Orders order) {
        return ordersRepository.save(order);
    }
    
}
