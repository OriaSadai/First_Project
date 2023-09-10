package com.firstProject.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CustomerOrderRequest {
    private Customer customer;
    @JsonProperty(value = "order")
    private CustomerOrder customerOrder;
    public CustomerOrderRequest() {}
    public CustomerOrderRequest(Customer customer, CustomerOrder customerOrder) {
        this.customer = customer;
        this.customerOrder = customerOrder;
    }
    public Customer getCustomer() {
        return this.customer;
    }
    public CustomerOrder getCustomerOrder() {
        return this.customerOrder;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
    }
    public CustomerOrder toCustomerOrder(){
        return new CustomerOrder(
                this.customerOrder.getId(),
                this.customer.getId(),
                this.customerOrder.getItemName(),
                this.customerOrder.getPrice()
        );
    }
}
