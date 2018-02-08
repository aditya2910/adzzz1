package com.demo.orgname.dao.dataentry.rawmaterialinward;

import java.io.Serializable;

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
@Table(name = "dataentry_rm_inward", catalog = "sbw")
public class RawMaterialInward implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "id", nullable = false)
	private String de_id;
	@Column(name = "rm_code")
	private String rm_code;
	@Column(name = "rm_type")
	private String rm_type;
	@Column(name = "bag_quantity")
	private String bag_quantity;
	@Column(name = "unit_quantity")
	private String unit_quantity;
	@Column(name = "value_rupees")
	private String value_rupees;
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "de_id", referencedColumnName = "id")
	private RawMaterialInwardMetaData rawMaterialInwardDataEntryMaster;

	public RawMaterialInward() {
	}

	// NOTE: create parameterized constructor without having de_id column
	public RawMaterialInward(String bag_quantity, String rm_code, String rm_type, String unit_quantity,
			String value_rupees, RawMaterialInwardMetaData rawMaterialInwardDataEntryMaster) {
		super();
		this.bag_quantity = bag_quantity;
		this.rm_code = rm_code;
		this.rm_type = rm_type;
		this.unit_quantity = unit_quantity;
		this.value_rupees = value_rupees;
		this.rawMaterialInwardDataEntryMaster = rawMaterialInwardDataEntryMaster;
	}

	public String getDe_id() {
		return de_id;
	}

	public void setDe_id(String de_id) {
		this.de_id = de_id;
	}

	public String getBag_quantity() {
		return bag_quantity;
	}

	public void setBag_quantity(String bag_quantity) {
		this.bag_quantity = bag_quantity;
	}

	public String getRm_code() {
		return rm_code;
	}

	public void setRm_code(String rm_code) {
		this.rm_code = rm_code;
	}

	public String getRm_type() {
		return rm_type;
	}

	public void setRm_type(String rm_type) {
		this.rm_type = rm_type;
	}

	public String getUnit_quantity() {
		return unit_quantity;
	}

	public void setUnit_quantity(String unit_quantity) {
		this.unit_quantity = unit_quantity;
	}

	public String getValue_rupees() {
		return value_rupees;
	}

	public void setValue_rupees(String value_rupees) {
		this.value_rupees = value_rupees;
	}

	public RawMaterialInwardMetaData getRawMaterialInwardDataEntryMaster() {
		return rawMaterialInwardDataEntryMaster;
	}

	public void setRawMaterialInwardDataEntryMaster(RawMaterialInwardMetaData rawMaterialInwardDataEntryMaster) {
		this.rawMaterialInwardDataEntryMaster = rawMaterialInwardDataEntryMaster;
	}
}
