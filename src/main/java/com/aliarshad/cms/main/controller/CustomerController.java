package com.aliarshad.cms.main.controller;

import java.util.List;

import org.hibernate.type.descriptor.sql.JdbcTypeFamilyInformation.Family;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aliarshad.cms.main.model.Customer;
import com.aliarshad.cms.main.service.CustomerService;

@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

	@Autowired
	private CustomerService service;

	// method to get the list of customers

	@GetMapping(value = "/")
	public List<Customer> getCustomers() {
		return service.getCustomers();
	}

	// method to add the new customer

	@PostMapping(value = "/add")
	public Customer addCustomer(@RequestBody Customer customer) {
		return service.addCustomer(customer);
	}

	// method to delete the existing customer with id

	@DeleteMapping(value = "/{id}")
	public void deleteCustomer(@PathVariable int id) {
		service.deleteCustomer(id);
	}

	// method to update the cutomer with the id
	
	@PutMapping(value = "/{id}")
	public Customer updateCustomer(@RequestBody Customer customer, @PathVariable int id) {
		return service.updateCustomer(customer, id);
	}

}
