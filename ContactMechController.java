package com.example.product_management_system.controller;

import com.example.product_management_system.model.Contact_Mech;
import com.example.product_management_system.model.Customer;
import com.example.product_management_system.repo.ContactMechRepo;
import com.example.product_management_system.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactMechController
{
    @Autowired
    private ContactMechRepo contactMechRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @GetMapping("/allMech")
    public List<Contact_Mech> getAll()
    {
        return contactMechRepo.findAll();
    }

    @PostMapping("/add/{customerId}")
    public Contact_Mech addMechDetails(
            @PathVariable int customerId,
            @RequestBody Contact_Mech contactMech
    ) {

        Customer customer = customerRepo.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        contactMech.setCustomer(customer);
        return contactMechRepo.save(contactMech);
    }

    @PostMapping("/removeMech/{id}")
    public void removeMech(@PathVariable int id)
    {
        contactMechRepo.deleteById(id);
    }

}
