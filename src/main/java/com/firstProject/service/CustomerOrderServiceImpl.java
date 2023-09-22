package com.firstProject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.model.Customer;
import com.firstProject.model.CustomerOrder;
import com.firstProject.model.CustomerOrderRequest;
import com.firstProject.model.CustomerOrderResponse;
import com.firstProject.repository.CustomerOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {
    @Autowired
    private CustomerOrderRepository customerOrderRepository;
    @Autowired
    private CustomerService customerService;
    @Override
    public CustomerOrderResponse createCustomerOrder(CustomerOrderRequest customerOrderRequest) throws JsonProcessingException {
        System.out.println("2 In the CUSTOMER ORDER SERVICE: Starting to create an order id" + customerOrderRequest.getCustomerOrder().getId());
        Customer selectedCustomer = customerOrderRequest.getCustomer();
        Long createCustomerId = customerOrderRequest.getCustomer().getId();
        if (createCustomerId == null) {
            createCustomerId = customerService.createCustomer(selectedCustomer);
        } else {
            Customer existingCustomer = customerService.getCustomerById(selectedCustomer.getId());
            if (existingCustomer == null) {
                throw new IllegalArgumentException("Can't find existing customer with customer id: " + selectedCustomer.getId());
            }
        }
        selectedCustomer = customerService.getCustomerById(createCustomerId);
        customerOrderRequest.setCustomer(selectedCustomer);
        CustomerOrder customerOrderToCreate = customerOrderRequest.toCustomerOrder();
        customerOrderRepository.createCustomerOrder(customerOrderToCreate);
        List<CustomerOrder> customerOrders = customerOrderRepository.getAllCustomerOrdersByCustomerId(selectedCustomer.getId());
        return customerOrderToCreate.toCustomerOrderResponse(selectedCustomer, customerOrders);
    }
    @Override
    public CustomerOrderResponse updateCustomerOrder(CustomerOrderRequest customerOrderRequest) {
        return null;
    }
    @Override
    public void deleteCustomerOrderById(Long id) {
        customerOrderRepository.deleteCustomerOrderById(id);
    }
    @Override
    public CustomerOrder getCustomerOrderById(Long id) {
        return customerOrderRepository.getCustomerOrderById(id);
    }
}
