package com.agro.entity;
import java.util.List;

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
    @Column(name = "role_id")
    private int id;

    @OneToMany(mappedBy="role")
    private List<User> users;

	@Enumerated(EnumType.STRING)
    private Roles roleName;

    // getters and setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Roles getRoleName() {
		return roleName;
	}

	public void setRoleName(Roles roleName) {
		this.roleName = roleName;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public boolean isPresent() {
		return true;
	}

}
