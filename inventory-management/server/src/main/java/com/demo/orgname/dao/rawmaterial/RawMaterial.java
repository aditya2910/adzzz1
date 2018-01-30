package com.demo.orgname.dao.rawmaterial;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="raw_material")
public class RawMaterial {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "id", nullable = false)
	private String id;
	@Column(name = "name", unique=true, nullable = true)
    private String name;
	@Column(name = "unit")
    private String unit;
	@Column(name = "type")
    private String type;
    
    public RawMaterial() {
	}
    
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getUnit() {
		return unit;
	}
	public String getType() {
		return type;
	}
}
