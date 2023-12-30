package com.agro.entity;

import com.agro.entity.PaymentHistory;
import com.agro.entity.User;

public class StorageReserve {
	private int id;
	
	private User user;
	private Warehouse warehouse;
	private Crop crop;
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
