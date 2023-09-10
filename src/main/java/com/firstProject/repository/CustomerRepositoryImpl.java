package com.firstProject.repository;

import com.firstProject.model.Customer;
import com.firstProject.model.CustomerType;
import com.firstProject.repository.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{
    private static final String CUSTOMER_TABLE_NAME = "customer";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private CustomerMapper customerMapper;
    @Override
    public Long createCustomer(Customer customer) {
        String sql = "INSERT INTO " + CUSTOMER_TABLE_NAME + " " + "(first_name, last_name, email, customer_type) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                customer.getFirstName(),
                customer.getLastName(),
                customer.getEmail(),
                customer.getCustomerType().name()
        );
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID();", Long.class);
    }
    @Override
    public void updateCustomer(Customer customer) {
        String sql = "UPDATE " + CUSTOMER_TABLE_NAME + " SET first_name=?, last_name=?, email=?, customer_type=? WHERE id=?";
        try {
            jdbcTemplate.update(
                    sql,
                    customer.getFirstName(),
                    customer.getLastName(),
                    customer.getEmail(),
                    customer.getCustomerType().name(),
                    customer.getCustomerId()
            );
        }catch (EmptyResultDataAccessException e){
            System.out.println("Id " + customer.getCustomerId() + " is not exist");
        }
    }
    @Override
    public void deleteCustomer(Long id) {
        String sql = "DELETE FROM " + CUSTOMER_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, id);
    }
    @Override
    public Customer getCustomerById(Long id) {
        String sql = "SELECT * FROM  " + CUSTOMER_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, customerMapper, id);
        } catch (EmptyResultDataAccessException e) {
            System.out.println(String.format("The customer with id %s is not exist",id));
            return null;
        }
    }
    @Override
    public List<Customer> getAllCustomersByFirstName(String firstName) {
        String sql = "SELECT * FROM " + CUSTOMER_TABLE_NAME + " WHERE first_name=?";
        try {
            return jdbcTemplate.query(sql, customerMapper, firstName);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Empty data warning");
            return null;
        }
    }
    @Override
    public List<Long> getAllCustomerIdsByFirstName(String firstName){
        String sql = "SELECT c.id FROM " + CUSTOMER_TABLE_NAME + " AS c WHERE c.first_name LIKE '%" + firstName + "%'";
        try {
            return jdbcTemplate.queryForList(sql, Long.class);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Empty data warning");
            return null;
        }
    }
    @Override
    public List<Customer> getAllCustomersByType(CustomerType customerType){
        String sql = "SELECT * FROM " + CUSTOMER_TABLE_NAME + " WHERE customer_type=?";
        try {
            return jdbcTemplate.query(sql, customerMapper, customerType.name());
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Warning: No " + customerType.name() + " exist");
            return null;
        }
    }
}