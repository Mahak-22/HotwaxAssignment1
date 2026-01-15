package com.example.product_management_system.controller;


import com.example.product_management_system.model.Product;
import com.example.product_management_system.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController
{
    @Autowired
    private ProductRepo productRepo;

    @GetMapping("/getAllProducts")
    public List<Product> getProducts()
    {
        return productRepo.findAll();
    }

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product)
    {
        return productRepo.save(product);
    }

    @PostMapping("/deleteProduct/{id}")
    public void removeProduct(@PathVariable int id)
    {
        productRepo.deleteById(id);
    }
}
