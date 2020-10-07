package com.spring.service;

import java.util.List;

import com.spring.model.CustomerModel;

public interface CustomerService {
	public void addCustomer(CustomerModel customer);
	public void updateCustomer(CustomerModel customer);
	public void deleteCustomer(CustomerModel customer);
	public List<CustomerModel> fetchCustomer();
}
