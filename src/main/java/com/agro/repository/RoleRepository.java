package com.agro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agro.entity.Role;
import com.agro.entity.Role.Roles;
import com.agro.entity.User;

public interface RoleRepository extends JpaRepository<Role, Integer>{

	Optional<User> findByRoleName(Roles roleName);

	Role findById(Long roleId);
	
}
