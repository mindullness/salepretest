package com.aptech.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aptech.api.models.Customer;
import com.aptech.api.models.Orders;
import com.aptech.api.services.SaleService;

import jakarta.validation.Valid;


@RestController
@CrossOrigin(origins = "${security.cors.origin}", methods = {
        RequestMethod.GET, RequestMethod.POST,
        RequestMethod.PUT, RequestMethod.DELETE
})
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping(path = "/customers")
    public ResponseEntity<List<Customer>> getCustomers(){
        return ResponseEntity.ok(saleService.getCustomers());
    }

    @GetMapping(path = "/ordersByCode/{code}")
    public ResponseEntity<List<Orders>> getOrdersByCode(@PathVariable String code){
        return ResponseEntity.ok(saleService.getOrdersByCode(code));
    }

    @PostMapping(path = "/addOrder")
    public ResponseEntity<Orders> addOrder(@RequestBody Orders order){
        return ResponseEntity.ok(saleService.createOrders(order));
    }

    // @PostMapping(path = "/addOrder")
    // public String addOrder(@RequestBody @Valid Orders order, Errors err){
    //     if(err.hasErrors()){
    //         return "redirect/customers";
    //     }
    //     return err.toString();
    // }
}
