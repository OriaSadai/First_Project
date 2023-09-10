package com.firstProject.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Customer {
    @JsonProperty(value = "id")
    private Long customerId;
    private String firstName;
    private String lastName;
    private String email;
    @JsonProperty(value = "type")
    private CustomerType customerType;
    public Customer(){}
    public Customer(Long customerId, String firstName, String lastName, String email, CustomerType customerType) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.customerType = customerType;
    }
    public Long getCustomerId() {
        return customerId;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public CustomerType getCustomerType() {
        return customerType;
    }
    public void setCustomerId(Long id) {
        this.customerId = id;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}
