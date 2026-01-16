package com.example.product_management_system.controller;


import com.example.product_management_system.model.OrderHeader;
import com.example.product_management_system.model.OrderItem;
import com.example.product_management_system.repo.OrderHeaderRepo;
import com.example.product_management_system.repo.OrderItemRepo;
import com.example.product_management_system.service.OrderHeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController
{
    @Autowired
    private OrderHeaderRepo orderHeaderRepo;

    @Autowired
    private OrderItemRepo orderRepo;

    private final OrderHeaderService orderService;

    public OrderController(OrderHeaderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public OrderHeader createOrder(@RequestBody OrderHeader order) {
        return orderService.createOrder(order);
    }

    @GetMapping("/order/{id}")
    public OrderHeader getOrder(@PathVariable Integer id) {
        return orderService.getOrderById(id);
    }

    @PutMapping("/update/order/{id}")
    public OrderHeader updateOrder(
            @PathVariable Integer id,
            @RequestBody OrderHeader order) {
        return orderService.updateOrderAddresses(id, order);
    }

    @DeleteMapping("/remove/order/{id}")
    public void deleteOrder(@PathVariable Integer id) {
        orderService.deleteOrder(id);
    }

    @PostMapping("/add/item/{orderId}/items")
    public OrderItem addItem(
            @PathVariable Integer orderId,
            @RequestBody OrderItem item) {
        return orderService.addOrderItem(orderId, item);
    }

    @PutMapping("/update/items/{itemId}")
    public OrderItem updateItem(
            @PathVariable Integer itemId,
            @RequestBody OrderItem item) {
        return orderService.updateOrderItem(itemId, item);
    }

    @DeleteMapping("/remove/item/{itemId}")
    public void deleteItem(@PathVariable Integer itemId) {
        orderService.deleteOrderItem(itemId);
    }

}
