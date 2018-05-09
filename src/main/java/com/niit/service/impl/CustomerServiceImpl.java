package com.niit.service.impl;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.niit.dao.CustomerDao;
import com.niit.model.Customer;
import com.niit.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerDao customerDao;
	public boolean addcustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.addcustomer(customer);
	}
	public Customer getCustomerById(int customerId) {
		// TODO Auto-generated method stub
		return customerDao.getCustomerById(customerId);
	}
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerDao.getAllCustomers();
		}
	public Customer getCustomerByUsername(String username) {
		// TODO Auto-generated method stub
		 return customerDao.getCustomerByUsername(username);
	}
}
