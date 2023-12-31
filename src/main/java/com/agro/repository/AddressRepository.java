package com.agro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agro.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
	
}
