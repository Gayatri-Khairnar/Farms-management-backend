package com.agro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.agro.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{
	
	@Query(value="Select * from role where role_name = ?",nativeQuery=true)
	Role findByRoleName(String roleName);
	
}
