package com.agro.entity;
import java.util.List;
import java.util.Set;

import com.agro.utils.Roles;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.persistence.*;

@Entity
@Table(name = "role")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="role_name")
    private String roleName;
    
    @OneToMany(mappedBy="role")
    private List<User> users;

	@Enumerated(EnumType.STRING)
    private Roles roleName;
    
    public static enum Roles {
        ADMIN, FARMER, BUYER;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}


}
