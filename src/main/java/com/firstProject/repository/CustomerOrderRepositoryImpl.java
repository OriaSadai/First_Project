package com.firstProject.repository;

import com.firstProject.model.Customer;
import com.firstProject.model.CustomerOrder;
import com.firstProject.model.CustomerType;
import com.firstProject.repository.mapper.CustomerMapper;
import com.firstProject.repository.mapper.CustomerOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CustomerOrderRepositoryImpl implements CustomerOrderRepository{
    private static final String CUSTOMER_ORDER_TABLE_NAME = "customer_order";
    @Autowired
    private CustomerOrderMapper customerOrderMapper;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public void createCustomerOrder(CustomerOrder customerOrder) {
        String sql = "INSERT INTO " + CUSTOMER_ORDER_TABLE_NAME + " " + "(customer_id, item_name, price) VALUES (?, ?, ?)";
        jdbcTemplate.update(
                sql,
                customerOrder.getCustomerId(),
                customerOrder.getItemName(),
                customerOrder.getPrice()
        );
    }
    @Override
    public void updateCustomerOrder(CustomerOrder customerOrder) {
        String sql = "UPDATE " + CUSTOMER_ORDER_TABLE_NAME + " SET customer_id=?, item_name=?, price=?) WHERE id=?";
        try {
            jdbcTemplate.update(
                    sql,
                    customerOrder.getCustomerId(),
                    customerOrder.getItemName(),
                    customerOrder.getPrice(),
                    customerOrder.getId()
            );
        } catch (EmptyResultDataAccessException e){
            System.out.println("Id " + customerOrder.getId() + " is not exist");
        }
    }
    @Override
    public void deleteCustomerOrderById(Long id) {
        String sql = "DELETE FROM " + CUSTOMER_ORDER_TABLE_NAME + " WHERE id=?";
        jdbcTemplate.update(sql, id);
    }
    @Override
    public CustomerOrder getCustomerOrderById(Long id) {
        String sql = "SELECT * FROM  " + CUSTOMER_ORDER_TABLE_NAME + " WHERE id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new CustomerOrderMapper(), id);
        } catch (EmptyResultDataAccessException e){
            System.out.println(String.format("The customer with id %s is not exist",id));
            return null;
        }
    }
    @Override
    public List<CustomerOrder> getAllCustomerOrdersByCustomerId(Long customerId) {
        String sql = "SELECT * FROM " + CUSTOMER_ORDER_TABLE_NAME + " WHERE customer_id=?";
        try{
            return jdbcTemplate.query(sql, customerOrderMapper, customerId);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Empty Data Warning");
            return null;
        }
    }
}
