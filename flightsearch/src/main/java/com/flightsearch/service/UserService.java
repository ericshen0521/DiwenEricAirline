package com.flightsearch.service;

import java.util.List;

import com.flightsearch.DTO.UserRegistrationDTO;
import com.flightsearch.modal.UserModel;

public interface UserService {
	public void addUser(UserModel user);
	
	public UserModel registerUser(UserRegistrationDTO registrationDetails);
	public void updateUser(UserModel user);
	public void deleteUser(UserModel user);
	public List<UserModel> fetchUser();
	
	public UserModel fetchUserByID(int userID);
	
}
