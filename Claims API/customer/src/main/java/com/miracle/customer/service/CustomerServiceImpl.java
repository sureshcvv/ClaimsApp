package com.miracle.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.miracle.customer.model.Customer;
import com.miracle.customer.repository.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> list = customerRepository.findAll();
		return new ResponseEntity<List<Customer>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	@Override
	public ResponseEntity<Customer> createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String deleteCustomer(Long customerId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ResponseEntity<Customer> updateCustomer(Long CustomerId, Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Customer getByCustomerId(Long customerId) {
		return customerRepository.findByCustomerId(customerId);

	}


}
