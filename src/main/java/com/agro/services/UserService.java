package com.agro.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agro.entity.Role;
import com.agro.entity.User;
import com.agro.exception.UserServiceException;
import com.agro.repository.RoleRepository;
import com.agro.repository.UserRepository;

/*@Service
public class UserService {
	
	 @Autowired
	    private UserRepository userRepository;

	    @Autowired
	    private RoleRepository roleRepository;

	    
	
	public int register(User user) {
		Optional<User> userCheck= userRepository.findByEmail(user.getEmail());
		if(userCheck.isEmpty()) {
			User savedUser = userRepository.save(user);
			return savedUser.getId();
		}
		else {
			throw new UserServiceException("User alredy registered");
			
		}
	}
}*/

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public int register(User user, Long roleId) {
        Optional<User> userCheck = userRepository.findByEmail(user.getEmail());
        if (userCheck.isEmpty()) {
            // Set role for the user
            Role role = roleRepository.findById(roleId);
            user.setRole(role);

            // Save the user
            User savedUser = userRepository.save(user);
            return savedUser.getId();
        } else {
            throw new UserServiceException("User already registered");
        }
    }
    
    // Other user-related methods...
}
