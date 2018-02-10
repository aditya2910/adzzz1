package com.demo.orgname.dao.rawmaterial;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rm_units", catalog = "sbw")
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

	public void setId(String id) {
		this.id = id;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	
	
	

}
