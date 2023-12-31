package com.agro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agro.entity.User;
import com.agro.exception.GenricProcessException;
import com.agro.services.AddressService;
import com.agro.services.RoleService;
import com.agro.services.UserRoleService;
import com.agro.services.UserService;
import com.agro.utils.APIResponse;
import com.agro.utils.CommonConstant;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

//import lombok.extern.slf4j.Slf4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

//@Slf4j
@RestController
@RequestMapping("/user")
@CrossOrigin
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class UserController {
	
//	 private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@PostMapping("register")
	public ResponseEntity<APIResponse> register(@RequestBody User user) throws GenricProcessException {
	
			userService.registerUser(user);			
			APIResponse response = new APIResponse(true,CommonConstant.USER_SUCCESSFULLY_REGISTERED,CommonConstant.SUCCESSFUL_RESPONSE_STATUS_CODE,null);
		    return ResponseEntity.ok(response);
	}
}

/*
 * @PostMapping("/customer/register")
	public Status register(@RequestBody Customer customer) {
		try {
			int id = customerService.register(customer);
			RegistrationStatus status = new RegistrationStatus();
			status.setStatus(true);
			status.setMessageIfAny("Registration successful!");
			status.setCustomerId(id);
			return status;
		}
		catch(CustomerServiceException e) {
			Status status = new Status();
			status.setStatus(false);
			status.setMessageIfAny(e.getMessage());
			return status;
		}
	}
 */