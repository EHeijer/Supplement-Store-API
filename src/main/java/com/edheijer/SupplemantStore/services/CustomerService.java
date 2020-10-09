package com.edheijer.SupplemantStore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edheijer.SupplemantStore.models.Customer;
import com.edheijer.SupplemantStore.repositories.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}
	
	public Customer getCustomer(Long id) {
		return customerRepository.getOne(id);
	}
	
	public Customer addCustomer(Customer customer) {
		return customerRepository.saveAndFlush(customer);
	}
	
	public void updateCustomer(Long id, Customer customer) {
		customerRepository.saveAndFlush(customer);
	}
	
	public void deleteCustomer(Long id) {
		customerRepository.deleteById(id);
	}
}
