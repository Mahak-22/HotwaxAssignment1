package com.example.product_management_system.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
public class Order_Header
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "shipping_contact_mech_id", nullable = false)
    private Contact_Mech shippingContactMech;

    @ManyToOne
    @JoinColumn(name = "billing_contact_mech_id", nullable = false)
    private Contact_Mech billingContactMech;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Contact_Mech getShippingContactMech() {
        return shippingContactMech;
    }

    public void setShippingContactMech(Contact_Mech shippingContactMech) {
        this.shippingContactMech = shippingContactMech;
    }

    public Contact_Mech getBillingContactMech() {
        return billingContactMech;
    }

    public void setBillingContactMech(Contact_Mech billingContactMech) {
        this.billingContactMech = billingContactMech;
    }
}
