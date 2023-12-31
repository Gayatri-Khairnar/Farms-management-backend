package com.agro.services;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.util.StringUtils;

import com.agro.entity.Address;
import com.agro.entity.Role;
import com.agro.entity.User;
import com.agro.exception.GenricProcessException;
import com.agro.repository.RoleRepository;
import com.agro.repository.UserRepository;
import com.agro.request.LoginRequest;
import com.agro.utils.APIResponse;
import com.agro.utils.CommonConstant;

import jakarta.transaction.Transactional;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepositoy;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private AddressService addressService;
	
	@Autowired
	private UserRoleService userRoleService;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	/*
	 * Following method is used for validatig user registration request and registration
	 */
	
	@Transactional
	public void registerUser(User user) throws GenricProcessException {
		
		validateRequest(user);
		
		try {
			
		addressService.registerUserAddress(user.getAddress());		
		
		Role role = roleRepository.findByRoleId(user.getRoleId());
		
		User userCheck = userRepositoy.findByEmail(user.getEmail());
		if(Objects.isNull(userCheck)) {
			Address address = user.getAddress();
			if(address != null) {
				address.setUser(user);
			}
		user.setRoleId(user.getRoleId());
		userRepositoy.save(user);			
		}else {
			throw new GenricProcessException(CommonConstant.USER_ALREADY_REGISTERED,CommonConstant.FAILURE_STATUS_CODE);
		}
		}catch(Exception e) {
			throw new GenricProcessException(CommonConstant.GENERIC_FAILURE_MESSAGE,CommonConstant.FAILURE_STATUS_CODE);
		}
	}
	
	
	public void validateRequest(User user) throws GenricProcessException {
		
		if(Objects.isNull(user)) {
			throw new GenricProcessException(CommonConstant.GENERIC_FAILURE_MESSAGE,CommonConstant.FAILURE_STATUS_CODE);
		}
		
		if(user.getEmail() == null && !StringUtils.hasText(user.getEmail())) {
			throw new GenricProcessException(CommonConstant.EMAIL_REQUIRED,CommonConstant.FAILURE_STATUS_CODE);
		}	
	}


	public boolean login(LoginRequest loginRequest) throws GenricProcessException {
		
		if(loginRequest.getEmail() == null && loginRequest.getPassword() == null) {
			throw new GenricProcessException(CommonConstant.CREDENTIALS_REQUIRED,CommonConstant.FAILURE_STATUS_CODE);
		}
		
		User user = userRepository.findByEmail(loginRequest.getEmail());
		
		if(Objects.isNull(user)) {
			throw new GenricProcessException(CommonConstant.USER_EMAIL_DOES_NOT_EXIST,CommonConstant.FAILURE_STATUS_CODE);
		}
		else if(!user.getPassword().equals(loginRequest.getPassword())) {
			throw new GenricProcessException(CommonConstant.PASSOWRD_INCORRECT,CommonConstant.FAILURE_STATUS_CODE);
		}
		return true;	
	}
	
	

   
}
