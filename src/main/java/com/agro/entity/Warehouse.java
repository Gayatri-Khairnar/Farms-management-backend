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
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="capacity")
	private int capacity;
	
	@OneToOne(mappedBy = "warehouse")
    private StorageReserve storage_reserve;


//	@OneToOne(mappedBy = "warehouse")
//	private List<StorageReserve> storageReserves;
	
	

	
}