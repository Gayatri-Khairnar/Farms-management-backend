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
	
	
	/*
	 * Following method is used for validatig user registration request and registration
	 */
	
	@Transactional
	public void registerUser(User user) throws GenricProcessException {
		
		validateRequest(user);
		
		try {
		roleService.registerRole(user.getRole());
		addressService.registerUserAddress(user.getAddress());		
		
		Optional<User> userCheck = userRepositoy.findByEmail(user.getEmail());
		if(userCheck.isEmpty()) {
			Address address = user.getAddress();
			if(address != null) {
				address.setUser(user);
			}
		userRepositoy.save(user);			
		userRoleService.registerUserRole(user,user.getRole());
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

   
}
