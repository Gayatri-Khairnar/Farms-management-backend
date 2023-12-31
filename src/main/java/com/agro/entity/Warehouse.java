package com.agro.entity;

import com.agro.entity.Address;

import jakarta.persistence.*;

@Entity
@Table(name="warehouse")
public class Warehouse {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="warehouse_id")
	private int id;
	private String name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
}
