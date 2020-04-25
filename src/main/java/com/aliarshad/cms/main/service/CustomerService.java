package com.aliarshad.cms.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliarshad.cms.main.dao.CustomerDao;
import com.aliarshad.cms.main.model.Customer;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao dao;

	public List<Customer> getCustomers() {
		return dao.findAll();
	}

	public Customer getCustomerById(int id) {
		return dao.getOne(id);
	}

	public void deleteCustomer(int id) {
		dao.deleteById(id);
	}
	
	public Customer addCustomer(Customer customer) {
		return dao.save(customer);
	}
	
	public Customer updateCustomer(Customer updatedcustomer,int id) {
		Customer customer=dao.getOne(id);
		customer.setCfname(updatedcustomer.getCfname());
		customer.setClname(updatedcustomer.getClname());
		customer.setCemail(updatedcustomer.getCemail());
		return dao.save(customer);
	}
	
	
}
