//package com.agro.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.agro.dto.RegistrationStatus;
//import com.agro.entity.User;
//import com.agro.exception.UserServiceException;
//import com.agro.services.UserService;
//
//@RestController
//@CrossOrigin
//public class UserController {
//	
//	@Autowired
//	private UserService userServices;
//	
//	@PostMapping("/register")
//	public RegistrationStatus register(@RequestBody User user){
//		
//		try {
//			userServices.register(user,(long)user.getRole().getId());
//			RegistrationStatus rs = new RegistrationStatus();
//			rs.setStatus(true);
//			rs.setUserId(user.getId());
//			rs.setStatusMessage("User Added");
//			return rs;
//		}catch(UserServiceException e) {
//			RegistrationStatus rs = new RegistrationStatus();
//			rs.setStatus(false);
//			rs.setUserId(user.getId());
//			rs.setStatusMessage("usesr Already Exists");
//			return rs;
//		}
//	}
//}
