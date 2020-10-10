package com.flightsearch.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flightsearch.DAO.UserDAO;
import com.flightsearch.DTO.UserRegistrationDTO;
import com.flightsearch.model.UserModel;

@Service
@ComponentScan(basePackages = "com.flightsearch.DAO")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	@Transactional
	public void addUser(UserModel user) {
		userDAO.save(user);
	}

	@Override
	@Transactional
	public void updateUser(UserModel user) {
		userDAO.update(user);
	}

	@Override
	@Transactional
	public void deleteUser(UserModel user) {
		userDAO.delete(user);
	}
	
	@Override
	@Transactional
	public List<UserModel> fetchUser() {
		return userDAO.fetchCustomers();
	}

	@Override
	public UserModel fetchUserByID(int userID) {
		return userDAO.fetchUserByID(userID);
	}

	@Override
	public UserModel registerUser(UserRegistrationDTO registrationDetails) {
		return userDAO.register(registrationDetails);
	}

	@Override
	public boolean isEmailTaken(String email) {
		return userDAO.isEmailTaken(email);
	}

	@Override
	public UserModel fetchUserByLogin(String email, String password) {
		return userDAO.fetchUserByLogin(email, password);
	}
}
