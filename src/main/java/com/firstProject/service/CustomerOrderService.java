package com.firstProject.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.model.CustomerOrder;
import com.firstProject.model.CustomerOrderRequest;
import com.firstProject.model.CustomerOrderResponse;

import java.util.List;

public interface CustomerOrderService {
    public CustomerOrderResponse createCustomerOrder(CustomerOrderRequest customerOrderRequest) throws JsonProcessingException;
    public CustomerOrderResponse updateCustomerOrder(CustomerOrderRequest customerOrderRequest);
    public void deleteCustomerOrderById(Long id);
    public CustomerOrder getCustomerOrderById(Long id);
}
