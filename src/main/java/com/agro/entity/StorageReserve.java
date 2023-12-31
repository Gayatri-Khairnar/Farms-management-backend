package com.agro.entity;

import com.agro.entity.PaymentHistory;
import com.agro.entity.User;

import jakarta.persistence.*;

@Entity
@Table(name="storagereserve")
public class StorageReserve {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToOne
	@JoinColumn(name="warehouse_id")
	private Warehouse warehouse;
	
	@OneToOne
	@JoinColumn(name="crop_id")
	private Crop crop;
	
	@OneToOne
	@JoinColumn(name="paymenthistory_id")
	private PaymentHistory paymentHistory;

	private int reserve;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public Crop getCrop() {
		return crop;
	}

	public void setCrop(Crop crop) {
		this.crop = crop;
	}

	public int getReserve() {
		return reserve;
	}

	public void setReserve(int reserve) {
		this.reserve = reserve;
	}
	
}
