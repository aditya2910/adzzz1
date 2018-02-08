package com.demo.orgname.dao.dataentry.rawmaterialwarehousetransfer;

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
@Table(name = "dataentry_rm_warehouse_transfer_data", catalog = "sbw")
public class RawMaterialWarehouseTransferData {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "id", nullable = false)
	private String deId;
	@Column(name = "rm_code")
	private String rmCode;
	@Column(name = "rm_type")
	private String rmType;
	@Column(name = "bag_unit")
	private String bagUnit; // e.g.- bundle, sack, cartoon. 25sack=1bundle
	@Column(name = "rate")
	private String rate; // price per unit RM
	@Column(name = "gross_weight")
	private String grossWeight;
	@Column(name = "quantity_in_weight")
	private String quantityInWeight; // no. of items per unit
	@Column(name = "value_rupees")
	private String valueRupees;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "deId", referencedColumnName = "id")
	private RawMaterialWarehouseTransfer rawMaterialWarehouseTransfer;
	
	public RawMaterialWarehouseTransferData() {
	}

	public RawMaterialWarehouseTransferData(String rmCode, String rmType, String bagUnit, String rate,
			String grossWeight, String quantityInWeight, String valueRupees,
			RawMaterialWarehouseTransfer rawMaterialWarehouseTransfer) {
		super();
		this.rmCode = rmCode;
		this.rmType = rmType;
		this.bagUnit = bagUnit;
		this.rate = rate;
		this.grossWeight = grossWeight;
		this.quantityInWeight = quantityInWeight;
		this.valueRupees = valueRupees;
		this.rawMaterialWarehouseTransfer = rawMaterialWarehouseTransfer;
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

	public String getBagUnit() {
		return bagUnit;
	}

	public void setBagUnit(String bagUnit) {
		this.bagUnit = bagUnit;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getGrossWeight() {
		return grossWeight;
	}

	public void setGrossWeight(String grossWeight) {
		this.grossWeight = grossWeight;
	}

	public String getQuantityInWeight() {
		return quantityInWeight;
	}

	public void setQuantityInWeight(String quantityInWeight) {
		this.quantityInWeight = quantityInWeight;
	}

	public String getValueRupees() {
		return valueRupees;
	}

	public void setValueRupees(String valueRupees) {
		this.valueRupees = valueRupees;
	}

	public RawMaterialWarehouseTransfer getRawMaterialWarehouseTransfer() {
		return rawMaterialWarehouseTransfer;
	}

	public void setRawMaterialWarehouseTransfer(RawMaterialWarehouseTransfer rawMaterialWarehouseTransfer) {
		this.rawMaterialWarehouseTransfer = rawMaterialWarehouseTransfer;
	}

	
}
