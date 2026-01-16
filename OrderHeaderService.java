package com.example.product_management_system.service;

import com.example.product_management_system.model.Customer;
import com.example.product_management_system.model.OrderHeader;
import com.example.product_management_system.model.OrderItem;
import com.example.product_management_system.model.Product;
import com.example.product_management_system.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderHeaderService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ContactMechRepo contactMechRepo;

    @Autowired
    private ProductRepo productRepo;

    private final OrderItemRepo orderItemRepo;
    private final OrderHeaderRepo orderRepo;

    public OrderHeaderService(OrderHeaderRepo orderRepo, OrderItemRepo orderItemRepo) {
        this.orderRepo = orderRepo;
        this.orderItemRepo = orderItemRepo;
    }

    public OrderHeader createOrder(OrderHeader order) {
        Customer fullCustomer = customerRepo.findById(order.getCustomer().getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        order.setCustomer(fullCustomer);

        order.setShippingContactMech(contactMechRepo.findById(order.getShippingContactMech().getContactMechId())
                .orElseThrow(() -> new RuntimeException("Shipping address not found")));
        order.setBillingContactMech(contactMechRepo.findById(order.getBillingContactMech().getContactMechId())
                .orElseThrow(() -> new RuntimeException("Billing address not found")));

        if (order.getOrderItems() != null) {
            order.getOrderItems().forEach(item -> {
                item.setOrder(order);

                Product fullProduct = productRepo.findById(item.getProduct().getProductId())
                        .orElseThrow(() -> new RuntimeException("Product not found"));
                item.setProduct(fullProduct);
            });
        }
        return orderRepo.save(order);
    }

    public OrderHeader getOrderById(int id) {
        return orderRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found  "));
    }

        public OrderHeader updateOrderAddresses(int id, OrderHeader details) {
        OrderHeader existing = getOrderById(id);
        existing.setShippingContactMech(details.getShippingContactMech());
        existing.setBillingContactMech(details.getBillingContactMech());
        return orderRepo.save(existing);
    }

    public void deleteOrder(int id) {
        orderRepo.deleteById(id);
    }

    public OrderItem addOrderItem(int orderId, OrderItem item) {
        OrderHeader order = getOrderById(orderId);
        item.setOrder(order);

        Product fullProduct = productRepo.findById(item.getProduct().getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        item.setProduct(fullProduct);

        return orderItemRepo.save(item);
    }

    public OrderItem updateOrderItem(int seqId, OrderItem details) {
        OrderItem existing = orderItemRepo.findById(seqId)
                .orElseThrow(() -> new RuntimeException("Item not found"));
        existing.setQuantity(details.getQuantity());
        existing.setStatus(details.getStatus());
        return orderItemRepo.save(existing);
    }

    public void deleteOrderItem(int seqId) {
        orderItemRepo.deleteById(seqId);
    }
}


