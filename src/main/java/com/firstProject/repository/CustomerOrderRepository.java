package com.firstProject.repository;

import com.firstProject.model.Customer;
import com.firstProject.model.CustomerOrder;

import java.util.List;

public interface CustomerOrderRepository {
    public void createCustomerOrder(CustomerOrder customerOrder);
    public void updateCustomerOrder(CustomerOrder customerOrder);
    public void deleteCustomerOrderById(Long id);
    public CustomerOrder getCustomerOrderById(Long id);
    public List<CustomerOrder> getAllCustomerOrdersByCustomerId(Long customerId);
}
