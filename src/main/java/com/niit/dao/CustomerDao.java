package com.niit.dao;

import java.util.List;

import com.niit.model.Customer;

public interface CustomerDao {
	boolean addcustomer(Customer customer);
    Customer getCustomerById(int customerId);

    List<Customer> getAllCustomers();

    Customer getCustomerByUsername(String username);

}
