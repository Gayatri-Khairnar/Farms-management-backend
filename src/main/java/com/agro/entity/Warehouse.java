package com.agro.entity;
import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

import com.agro.entity.Address;

@Entity
@Table(name="warehouse")
public class Warehouse {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="warehouse_id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="capacity")
	private int capacity;
	
	@OneToOne
	@JoinColumn(name="addr_id")
	private Address address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

	
}