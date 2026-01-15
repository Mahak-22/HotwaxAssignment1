package com.example.product_management_system.controller;


import com.example.product_management_system.model.Order_Item;
import com.example.product_management_system.repo.OrderItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController
{
    @Autowired
    private OrderItemRepo orderRepo;

    @GetMapping("/order/{id}")
    public Object getOrder(@PathVariable int id)
    {
        return orderRepo.findById(id);
    }

    @PostMapping("/addOrder")
    public Order_Item addOrder(@RequestBody Order_Item orderItem)
    {
        return orderRepo.save(orderItem);
    }

    @PutMapping("/updateOrder/{id}")
    public Order_Item updateOrder(@PathVariable int id, @RequestBody Order_Item orderItem)
    {
        orderItem.setOrderItemSeqId(id);
        return orderRepo.save(orderItem);
    }

    @DeleteMapping("/orders/{orderId}/items/{orderItemSeqId}")
    public void removeItem(@PathVariable int orderId, @PathVariable int itemSeqId)
    {
        orderRepo.findByOrderItemSeqIdAndOrderHeader_OrderId(itemSeqId, orderId);
    }

    @DeleteMapping("/deleteOrder/{id}")
    public void removeOrder(@PathVariable int id)
    {
        orderRepo.deleteById(id);
    }
}
