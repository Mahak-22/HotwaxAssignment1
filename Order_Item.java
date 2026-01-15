package com.example.product_management_system.model;

import jakarta.persistence.*;

@Entity
public class Order_Item
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_seq_id")
    private int orderItemSeqId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order_Header orderHeader;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private int quantity;
    private String status;

    public int getOrderItemSeqId() {
        return orderItemSeqId;
    }

    public void setOrderItemSeqId(int orderItemSeqId) {
        this.orderItemSeqId = orderItemSeqId;
    }

    public Order_Header getOrderHeader() {
        return orderHeader;
    }

    public void setOrderHeader(Order_Header orderHeader) {
        this.orderHeader = orderHeader;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
