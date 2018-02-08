package com.demo.orgname.dao.rawmaterial;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rm_types", catalog = "sbw")
public class RawMaterialType {
	
	@Id
	@Column(name = "id", nullable = false)
	private String id;
	@Column(name = "type", unique=true, nullable = false)
    private String type;
	
	public RawMaterialType() {
		
	}

	public String getId() {
		return id;
	}

	public String getType() {
		return type;
	}
	
	

}
