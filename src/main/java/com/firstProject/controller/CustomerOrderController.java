package com.firstProject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.model.CustomerOrder;
import com.firstProject.model.CustomerOrderRequest;
import com.firstProject.model.CustomerOrderResponse;
import com.firstProject.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customerOrder")
public class CustomerOrderController {
    @Autowired
    private CustomerOrderService customerOrderService;
    @PostMapping(value = "/create")
    public CustomerOrderResponse createCustomerOrder(@RequestBody CustomerOrderRequest customerOrderRequest) throws JsonProcessingException {
        System.out.println(String.format("1 In the CUSTOMER ORDER CONTROLLER: Starting to create an order item %s for %s %s",customerOrderRequest.getCustomerOrder().getItemName(),customerOrderRequest.getCustomer().getFirstName(),customerOrderRequest.getCustomer().getLastName()));
        return customerOrderService.createCustomerOrder(customerOrderRequest);
    }
    @PutMapping(value = "/update")
    public CustomerOrderResponse updateCustomerOrder(@RequestBody CustomerOrderRequest customerOrderRequest) {
        return customerOrderService.updateCustomerOrder(customerOrderRequest);
    }
    @DeleteMapping(value = "/delete/{customerOrderId}")
    public void deleteCustomerOrderById(@PathVariable Long customerOrderId) {
        customerOrderService.deleteCustomerOrderById(customerOrderId);
    }
    @GetMapping(value = "/get")
    public CustomerOrder getCustomerOrderById(@RequestParam Long customerOrderId) {
        return customerOrderService.getCustomerOrderById(customerOrderId);
    }
}
