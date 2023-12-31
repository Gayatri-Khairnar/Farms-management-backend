package com.agro.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agro.entity.Address;
import com.agro.repository.AddressRepository;

@Service
public class AddressService {
	@Autowired
	private AddressRepository addressRepository;

	public void registerUserAddress(Address address) {
		addressRepository.save(address);
	}

}
