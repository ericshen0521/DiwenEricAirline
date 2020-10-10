package com.flightsearch.service;

import java.util.List;

import com.flightsearch.DTO.UserRegistrationDTO;
import com.flightsearch.model.UserModel;

public interface UserService {
	public void addUser(UserModel user);
	
	public UserModel registerUser(UserRegistrationDTO registrationDetails);
	public void updateUser(UserModel user);
	public void deleteUser(UserModel user);
	public List<UserModel> fetchUser();
	
	public UserModel fetchUserByID(int userID);
	public UserModel fetchUserByLogin(String email, String password);
	public boolean isEmailTaken(String email);
	
}
