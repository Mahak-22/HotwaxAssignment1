package com.example.product_management_system.controller;

import com.example.product_management_system.model.Customer;
import com.example.product_management_system.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController
{
    @Autowired
    private CustomerRepo customerRepo;

    @GetMapping("/getAllCustomers")
    public List<Customer> getAll()
    {
        return customerRepo.findAll();
    }

    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer)
    {
        return customerRepo.save(customer);
    }

    @PostMapping("/removeCustomer/{id}")
    public void removeCustomer(@PathVariable int id)
    {
        customerRepo.deleteById(id);
    }
}