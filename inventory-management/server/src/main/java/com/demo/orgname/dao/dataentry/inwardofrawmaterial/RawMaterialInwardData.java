package com.demo.orgname.dao.dataentry.inwardofrawmaterial;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "dataentry_rm_inward_data", catalog = "sbw")
public class RawMaterialInwardData {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "id", nullable = false)
	private String deId;
	@Column(name = "rm_code")
	private String rmCode;
	@Column(name = "rm_type")
	private String rmType;
	@Column(name = "bag_quantity")
	private String bagQuantity;
	@Column(name = "unit_quantity")
	private String unitQuantity;
	@Column(name = "value_rupees")
	private String valueRupees;
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "deId", referencedColumnName = "id")
	private RawMaterialInward rawMaterialInward;

	// NOTE: create parameterized constructor without having deId column
	public RawMaterialInwardData() {
	}

	public RawMaterialInwardData(String rmCode, String rmType, String bagQuantity, String unitQuantity,
			String valueRupees, RawMaterialInward rawMaterialInward) {
		super();
		this.rmCode = rmCode;
		this.rmType = rmType;
		this.bagQuantity = bagQuantity;
		this.unitQuantity = unitQuantity;
		this.valueRupees = valueRupees;
		this.rawMaterialInward = rawMaterialInward;
	}

	public String getDeId() {
		return deId;
	}

	public void setDeId(String deId) {
		this.deId = deId;
	}

	public String getRmCode() {
		return rmCode;
	}

	public void setRmCode(String rmCode) {
		this.rmCode = rmCode;
	}

	public String getRmType() {
		return rmType;
	}

	public void setRmType(String rmType) {
		this.rmType = rmType;
	}

	public String getBagQuantity() {
		return bagQuantity;
	}

	public void setBagQuantity(String bagQuantity) {
		this.bagQuantity = bagQuantity;
	}

	public String getUnitQuantity() {
		return unitQuantity;
	}

	public void setUnitQuantity(String unitQuantity) {
		this.unitQuantity = unitQuantity;
	}

	public String getValueRupees() {
		return valueRupees;
	}

	public void setValueRupees(String valueRupees) {
		this.valueRupees = valueRupees;
	}

	public RawMaterialInward getRawMaterialInward() {
		return rawMaterialInward;
	}

	public void setRawMaterialInward(RawMaterialInward rawMaterialInward) {
		this.rawMaterialInward = rawMaterialInward;
	}

	
}
