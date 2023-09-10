package com.firstProject.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.firstProject.model.Customer;
import com.firstProject.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value =  "/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;
    @PostMapping("/create")
    public void createCustomer(@RequestBody Customer customer) throws JsonProcessingException {
        customerService.createCustomer(customer);
    }
    @PutMapping("/update")
    public void updateCustomer(@RequestBody Customer customer){
        customerService.updateCustomer(customer);
    }
    @DeleteMapping("/delete")
    public void deleteCustomerById(@RequestHeader(value = "id") Long id){
        customerService.deleteCustomer(id);
    }
    @GetMapping("/get/{customerId}")
    public Customer getCustomerById(@PathVariable Long customerId){
        return customerService.getCustomerById(customerId);
    }
    @GetMapping(value = "/get/all")
    public List<Customer> getAllCustomersByFirstName(@RequestParam(value = "name") String firstName){
        return customerService.getAllCustomersByFirstName(firstName);
    }
    @GetMapping(value = "/get/ids")
    public List<Long> getCustomerIdsByFirstName(@RequestParam(value = "name") String firstName){
        return customerService.getAllCustomerIdsByFirstName(firstName);
    }
}
