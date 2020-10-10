package com.flightsearch.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.flightsearch.DTO.UserRegistrationDTO;
import com.flightsearch.service.UserService;

@Component
public class RegistrationValidator implements Validator {

	@Autowired
	UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		return UserRegistrationDTO.class.equals(clazz);
	}

	@Override
   public void validate(Object obj, Errors err) {

      ValidationUtils.rejectIfEmpty(err, "firstName", "registrationDetails.firstName.empty");
      ValidationUtils.rejectIfEmpty(err, "lastName", "registrationDetails.lastName.empty");
      ValidationUtils.rejectIfEmpty(err, "email", "registrationDetails.email.empty");
      
      ValidationUtils.rejectIfEmpty(err, "password", "registrationDetails.password.empty");
      ValidationUtils.rejectIfEmpty(err, "passwordConfirm", "registrationDetails.passwordConfirm.empty");
      
     
      UserRegistrationDTO registrationDetails = (UserRegistrationDTO) obj;
      
      if(!registrationDetails.getPassword().equals(registrationDetails.getPasswordConfirm())) {
    	  err.rejectValue("passwordConfirm", "registrationDetails.password.nonMatch");
      }

      Pattern pattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE);
      if (!(pattern.matcher(registrationDetails.getEmail()).matches())) {
         err.rejectValue("email", "registrationDetails.email.invalid");
      }
      
      if(userService.isEmailTaken(registrationDetails.getEmail())) {
    	  err.rejectValue("email", "registrationDetails.email.taken");
      }

   }

}
