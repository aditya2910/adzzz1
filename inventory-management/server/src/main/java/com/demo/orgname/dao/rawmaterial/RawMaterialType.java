package com.demo.orgname.dao.rawmaterial;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.demo.orgname.service.rawmaterial.RawMaterialTypeBo;

@Entity
@Table(name="rm_types", catalog = "sbw")
public class RawMaterialType {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "id", nullable = false)
	private String id;
	@Column(name = "type", unique=true, nullable = false)
    private String type;
	
	public RawMaterialType() {
		
	}
	
	public RawMaterialType(RawMaterialTypeBo bo) {
		this.setId(bo.getId());
		this.setType(bo.getType());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
	

}
