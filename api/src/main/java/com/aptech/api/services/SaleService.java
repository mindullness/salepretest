package com.aptech.api.services;

import java.util.List;

import com.aptech.api.models.Customer;
import com.aptech.api.models.Orders;

public interface SaleService {
    List<Customer> getCustomers();

    List<Orders> getOrdersByCode(String code);
    Orders createOrders(Orders order);
}
