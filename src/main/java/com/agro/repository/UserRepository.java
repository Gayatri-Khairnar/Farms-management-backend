package com.agro.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agro.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public Optional<User> findByEmail(String email);
}
