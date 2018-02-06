package com.demo.orgname.dao.rawmaterial;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rm_units")
public class RawMaterialUnit {
	
	@Id
	@Column(name = "id", nullable = false)
	private String id;
	@Column(name = "unit", unique=true, nullable = false)
    private String unit;
	
	public RawMaterialUnit() {
		
	}

	public String getId() {
		return id;
	}

	public String getUnit() {
		return unit;
	}
	
	

}
