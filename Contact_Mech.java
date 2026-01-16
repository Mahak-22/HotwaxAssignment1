package com.example.product_management_system.model;

import jakarta.persistence.*;

@Entity
public class ContactMech
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int contactMechId;

    @ManyToOne
    @JoinColumn(name="customer_id", referencedColumnName = "customer_id", nullable = false)
    private Customer customer;

    @Column(length = 100, nullable = false)
    private String streetAddress;

    @Column(length = 50, nullable = false)
    private String city;

    @Column(length = 50, nullable = false)
    private String state;

    @Column(length = 20, nullable = false)
    private String postalCode;

    @Column(length = 20, nullable = false)
    private String phoneNumber;

    @Column(length = 100, nullable = false)
    private String email;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getContactMechId() {
        return contactMechId;
    }

    public void setContactMechId(int contactMechId) {
        this.contactMechId = contactMechId;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
