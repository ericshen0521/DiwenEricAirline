package com.flightsearch.DAO;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.flightsearch.DTO.UserRegistrationDTO;
import com.flightsearch.model.UserModel;

@Transactional
@Repository
@ComponentScan(basePackages = "com.flightsearch")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<UserModel> fetchCustomers() {
		CriteriaQuery<UserModel> criteria = getSession().getCriteriaBuilder().createQuery(UserModel.class);
		criteria.select(criteria.from(UserModel.class));
		return getSession().createQuery(criteria).getResultList();
	}

	@Override
	public void save(UserModel user) {
		getSession().save(user);
	}
	
	@Override
	public UserModel register(UserRegistrationDTO registrationDetails) {
		// TODO Auto-generated method stub
		UserModel user = new UserModel();
		user.setFirstName(registrationDetails.getFirstName());
		user.setLastName(registrationDetails.getLastName());
		user.setEmail(registrationDetails.getEmail());
		user.setPassword(registrationDetails.getPassword());
		getSession().save(user);
		
		return user;
		
	}

	@Override
	public void update(UserModel user) {
		getSession().update(user);
	}

	@Override
	public void delete(UserModel user) {
		getSession().delete(user);
	}

	@Override
	public UserModel fetchUserByID(int userID) {
		return getSession().get(UserModel.class, userID);
	}

	@Override
	public boolean isEmailTaken(String email) {
		try {
			getSession().createQuery("from UserModel user where user.email = :email")
					.setParameter("email", email)
					.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("email not already registered");
			return false;
		}
		System.out.println("email already registered");
		return true;
		
		
	}

	@Override
	public UserModel fetchUserByLogin(String email, String password) {
		UserModel user;
		
		try {
			user = (UserModel) getSession().createQuery("from UserModel user where user.email = :email and user.password = :password")
					.setParameter("email", email)
					.setParameter("password", password)
					.getSingleResult();
		} catch (NoResultException e) {
			user = null;
		}

		return user;
	}

	
	
}
