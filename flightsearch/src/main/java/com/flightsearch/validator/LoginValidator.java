package com.flightsearch.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.flightsearch.DTO.UserLoginDTO;
import com.flightsearch.DTO.UserRegistrationDTO;
import com.flightsearch.service.UserService;

@Component
public class LoginValidator implements Validator {

	@Autowired
	UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return UserLoginDTO.class.equals(clazz);
	}

	@Override
   public void validate(Object obj, Errors err) {

  
      ValidationUtils.rejectIfEmpty(err, "email", "loginDetails.email.empty");
      ValidationUtils.rejectIfEmpty(err, "password", "loginDetails.password.empty");
      
     
//      UserLoginDTO loginDetails = (UserLoginDTO) obj;
//      
//      if(userService.fetchUserByLogin(loginDetails.getEmail(), loginDetails.getPassword()) == null) {
//    	  err.rejectValue("email", "registrationDetails.email.taken");
//      }

   }

}
