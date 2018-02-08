package com.demo.orgname.dao.dataentry.rawmaterialissueforconsumption;

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
@Table(name="dataentry_rm_issue_for_consumption_data", catalog = "sbw")
public class RawMaterialIssueForConsumptionData {
	
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
	@Column(name = "quantity_in_weight")
	private String quantityInWeight;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "deId", referencedColumnName = "id")
	private RawMaterialIssueForConsumption rawMaterialIssueForConsumption;
	
	public RawMaterialIssueForConsumptionData() {
	}

	public RawMaterialIssueForConsumptionData(String rmCode, String rmType, String bagQuantity, String quantityInWeight,
			RawMaterialIssueForConsumption rawMaterialIssueForConsumption) {
		super();
		this.rmCode = rmCode;
		this.rmType = rmType;
		this.bagQuantity = bagQuantity;
		this.quantityInWeight = quantityInWeight;
		this.rawMaterialIssueForConsumption = rawMaterialIssueForConsumption;
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

	public String getQuantityInWeight() {
		return quantityInWeight;
	}

	public void setQuantityInWeight(String quantityInWeight) {
		this.quantityInWeight = quantityInWeight;
	}

	public RawMaterialIssueForConsumption getRawMaterialIssueForConsumption() {
		return rawMaterialIssueForConsumption;
	}

	public void setRawMaterialIssueForConsumption(RawMaterialIssueForConsumption rawMaterialIssueForConsumption) {
		this.rawMaterialIssueForConsumption = rawMaterialIssueForConsumption;
	}
}
