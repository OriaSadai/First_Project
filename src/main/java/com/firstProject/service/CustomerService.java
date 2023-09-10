package com.firstProject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.model.Customer;

import java.util.List;

public interface CustomerService {
    public Long createCustomer(Customer customer) throws JsonProcessingException;
    public void updateCustomer(Customer customer);
    public void deleteCustomer(Long id);
    public Customer getCustomerById(Long id);
    public List<Customer> getAllCustomersByFirstName(String firstName);
    public List<Long> getAllCustomerIdsByFirstName(String firstName);
}
