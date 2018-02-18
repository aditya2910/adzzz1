package com.demo.orgname.dao.rawmaterial;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.demo.orgname.service.rawmaterial.RawMaterialBo;

@Entity
@Table(name="raw_material", catalog = "sbw")
public class RawMaterial {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "id", nullable = false)
	private String id;
	@Column(name = "name", unique=true, nullable = false)
    private String name;
	@Column(name = "unit")
    private String unit;
	@Column(name = "type")
    private String type;
    
    public RawMaterial() {
	}
    
    public RawMaterial(RawMaterialBo bo) {
    		this.setId(bo.getId());
    		this.setName(bo.getName());
    		this.setType(bo.getType());
    		this.setUnit(bo.getUnit());
    }
    
	public String getId() {
		return id;
	}

	protected void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	protected void setUnit(String unit) {
		this.unit = unit;
	}

	public String getType() {
		return type;
	}

	protected void setType(String type) {
		this.type = type;
	}
    
	
}
