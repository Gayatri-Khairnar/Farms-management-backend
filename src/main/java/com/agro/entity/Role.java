package com.agro.entity;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name="role_name")
    private String roleName;
//    @OneToMany(mappedBy="role")
//    private List<User> users;

//	@Enumerated(EnumType.STRING)
//    private Roles roleName;

    // getters and setters

//	public enum Roles {
//	    ADMIN("Admin", 1),
//	    FARMER("Farmer", 2),
//	    BUYER("Buyer", 3);
//
//	    private final String value;
//	    private final int numericValue;
//
//	    private Roles(String value, int numericValue) {
//	        this.value = value;
//	        this.numericValue = numericValue;
//	    }
//
//	    public String getValue() {
//	        return value;
//	    }
//
//	    public int getNumericValue() {
//	        return numericValue;
//	    }
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public Roles getRoleName() {
//		return roleName;
//	}
//
//	public void setRoleName(Roles roleName) {
//		this.roleName = roleName;
//	}
//
//	public List<User> getUsers() {
//		return users;
//	}
//
//	public void setUsers(List<User> users) {
//		this.users = users;
//	}
//
//	public boolean isPresent() {
//		return true;
//	}

}
