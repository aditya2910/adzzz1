package com.demo.orgname.dao.rawmaterial;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="rm_units", catalog = "sbw")
public class RawMaterialUnit {
	// TODO: create Conversion Rate table for conversion among different types
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "id", nullable = false)
	private String id;
	@Column(name = "unit", unique=true, nullable = false)
    private String unit;
	@Column(name = "code", unique=true, nullable = false)
    private String code;
	@Column(name = "conversion_rate", unique=true, nullable = false)
    private String conversionRate;
	
	public RawMaterialUnit() {
		
	}

	
}
