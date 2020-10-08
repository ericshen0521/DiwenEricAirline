package com.flightsearch.DAO;

import java.util.List;


import com.flightsearch.modal.CustomerModel;

public interface CustomerDAO {
	public void save(CustomerModel customer);
	public List<CustomerModel> fetchCustomer();
	public void update(CustomerModel customer);
	public void delete(CustomerModel customer);
}
