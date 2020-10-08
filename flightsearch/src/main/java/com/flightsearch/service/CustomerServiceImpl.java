package com.flightsearch.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flightsearch.DAO.CustomerDAO;
import com.flightsearch.modal.CustomerModel;

@Service
@ComponentScan(basePackages = "com.flightsearch.DAO")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public void addCustomer(CustomerModel customer) {
		customerDAO.save(customer);
	}

	@Override
	@Transactional
	public void updateCustomer(CustomerModel customer) {
		customerDAO.update(customer);
	}

	@Override
	@Transactional
	public void deleteCustomer(CustomerModel customer) {
		customerDAO.delete(customer);
	}
	
	@Override
	@Transactional
	public List<CustomerModel> fetchCustomer() {
		return customerDAO.fetchCustomer();
	}
}
