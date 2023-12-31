package com.agro.entity;

import com.agro.entity.PaymentHistory;
import com.agro.entity.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="storage_reserve")
public class StorageReserve {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="quantity_stored")
    private int quantity_stored;
    
	//private PaymentHistory paymentHistory;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "warehouse_id", referencedColumnName = "id")
    private Warehouse warehouse;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "crop_id", referencedColumnName = "id")
    private Crop crop;

	
	public int getQuantity_stored() {
		return quantity_stored;
	}

	public void setQuantity_stored(int quantity_stored) {
		this.quantity_stored = quantity_stored;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Crop getCrop() {
		return crop;
	}

	public void setCrop(Crop crop) {
		this.crop = crop;
	}

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}


}
