package com.agro.entity;

import com.agro.entity.Role;
import com.agro.entity.User;

import jakarta.persistence.*;

@Entity
@Table(name="user_role")
public class UserRole {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_role_id")
	private int id;
	
	@ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
