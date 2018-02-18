package com.demo.orgname.dao.rawmaterial;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.demo.orgname.service.rawmaterial.RawMaterialUnitBo;

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
	@Column(name = "conversion_rate", nullable = false)
    private String conversionRate;
	
	public RawMaterialUnit() {
	}
	
	public RawMaterialUnit(RawMaterialUnitBo bo) {
		this.setId(bo.getId());
		this.setUnit(bo.getUnit());
		this.setCode(bo.getCode());
		this.setConversionRate(bo.getConversionRate());
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getConversionRate() {
		return conversionRate;
	}

	public void setConversionRate(String conversionRate) {
		this.conversionRate = conversionRate;
	}

	
}
