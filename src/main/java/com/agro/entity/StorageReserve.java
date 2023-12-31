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
	@Column(name="quantity_stored")
    private int quantity_stored;
    
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "warehouse_id", referencedColumnName = "id")
    private Warehouse warehouse;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "crop_id", referencedColumnName = "id")
    private Crop crop;

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
