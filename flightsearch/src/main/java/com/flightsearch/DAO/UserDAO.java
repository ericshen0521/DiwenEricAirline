package com.flightsearch.DAO;

import java.util.List;

import com.flightsearch.DTO.UserRegistrationDTO;
import com.flightsearch.model.UserModel;

public interface UserDAO {
	public void save(UserModel user);
	public UserModel register(UserRegistrationDTO registrationDetails);
	public List<UserModel> fetchCustomers();
	public UserModel fetchUserByID(int userID);
	public UserModel fetchUserByLogin(String email, String password);
	public void update(UserModel user);
	public void delete(UserModel user);
	public boolean isEmailTaken(String email);
}
