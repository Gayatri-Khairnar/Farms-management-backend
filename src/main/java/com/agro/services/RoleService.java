package com.agro.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agro.entity.Role;
import com.agro.repository.RoleRepository;
import com.agro.utils.Roles;
@Service
public class RoleService {
	@Autowired
	private RoleRepository roleRepository;

	public int registerRole(Role role) {
		
		Role responseRole = roleRepository.findByRoleName(role.getRoleName().getValue());
		return responseRole.getId();
	}
}
