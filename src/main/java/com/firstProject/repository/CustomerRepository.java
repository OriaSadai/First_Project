package com.firstProject.repository;

import com.firstProject.model.Customer;
import com.firstProject.model.CustomerType;

import java.util.List;

public interface CustomerRepository {
    public Long createCustomer(Customer customer);
    public void updateCustomer(Customer customer);
    public void deleteCustomer(Long id);
    public Customer getCustomerById(Long id);
    public List<Customer> getAllCustomersByFirstName(String firstName);
    public List<Long> getAllCustomerIdsByFirstName(String firstName);
    List<Customer> getAllCustomersByType(CustomerType customerType);
}
