package com.flightsearch.DAO;

import java.util.List;


import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import com.flightsearch.modal.CustomerModel;

@Repository
@ComponentScan(basePackages = "com.flightsearch")
public class CustomerDAOImpl /*extends AbstractDAO*/ implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<CustomerModel> fetchCustomer() {
		CriteriaQuery<CustomerModel> criteria = getSession().getCriteriaBuilder().createQuery(CustomerModel.class);
		criteria.select(criteria.from(CustomerModel.class));
		return getSession().createQuery(criteria).getResultList();
	}

	@Override
	public void save(CustomerModel cust) {
		getSession().save(cust);
	}

	@Override
	public void update(CustomerModel customer) {
		getSession().update(customer);
	}

	@Override
	public void delete(CustomerModel customer) {
		getSession().delete(customer);
	}
	
}
