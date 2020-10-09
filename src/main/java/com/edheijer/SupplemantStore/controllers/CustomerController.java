package com.edheijer.SupplemantStore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edheijer.SupplemantStore.models.Customer;

import com.edheijer.SupplemantStore.services.CustomerService;


@RestController
@RequestMapping
@CrossOrigin
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping(path = "/customers")
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	
	@GetMapping(path = "/customers/{id}")
	public Customer getCustomerById(@PathVariable("id") int id) {
		return customerService.getCustomer(Integer.toUnsignedLong(id));
	}
	
	@PostMapping(path = "/customers")
	public void addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
	}
	
	@PutMapping(path = "/customers/{id}")
	public void updateCustomer(@PathVariable("id") int id, @RequestBody Customer customer) {
		customerService.updateCustomer(Integer.toUnsignedLong(id), customer);
	}
	
	@DeleteMapping(path = "/customers/{id}")
	public void removeCustomerById(@PathVariable("id") int id) {
		customerService.deleteCustomer(Integer.toUnsignedLong(id));
	}
}
