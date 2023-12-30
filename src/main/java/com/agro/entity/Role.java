package com.agro.entity;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "role")
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

    public static enum Roles {
        ADMIN, FARMER, BUYER;
    }

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
