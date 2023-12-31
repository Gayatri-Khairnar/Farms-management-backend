package com.agro.entity;
import java.util.List;
import java.util.Set;

import jakarta.persistence.*;
import jakarta.persistence.*;

@Entity
@Table(name="crop")
public class Crop {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="crop_id")
	private int id;	//1
	private String name;	//onion
	
	@Enumerated(EnumType.STRING)
	private CropType type;	//KHARIF
	
	@OneToOne(mappedBy = "crop")
    private StorageReserve storage_reserve;

	
	public static enum CropType{
		KHARIF , RABI , ZAID
	}

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

	public CropType getType() {
		return type;
	}

	public void setType(CropType type) {
		this.type = type;
	}	
}