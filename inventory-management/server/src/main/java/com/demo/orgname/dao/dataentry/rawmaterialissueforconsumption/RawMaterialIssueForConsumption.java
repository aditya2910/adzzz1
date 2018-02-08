package com.demo.orgname.dao.dataentry.rawmaterialissueforconsumption;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="dataentry_rm_issue_for_consumption_metadata", catalog = "sbw")
public class RawMaterialIssueForConsumption {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "id", nullable = false)
	private String id;
	@Column(name = "date_of_entry", nullable = false)
	private String dateOfEntry;
	@Column(name = "challan_no", nullable = false)
	private String challanNo;
	@Column(name = "challan_date", nullable = false)
	private String challanDate;
	@Column(name = "godown_code", nullable = false)
	private String godownCode;
	@Column(name = "no_of_items", nullable = false)
	private int noOfItems;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "rawMaterialIssueForConsumption", cascade = CascadeType.ALL)
    private List<RawMaterialIssueForConsumptionData> rawMaterialIssueForConsumptionDataEntries;
	
	public RawMaterialIssueForConsumption() {
	}

	public RawMaterialIssueForConsumption(String id, String dateOfEntry, String challanNo, String challanDate,
			String godownCode, int noOfItems,
			List<RawMaterialIssueForConsumptionData> rawMaterialIssueForConsumptionDataEntries) {
		super();
		this.id = id;
		this.dateOfEntry = dateOfEntry;
		this.challanNo = challanNo;
		this.challanDate = challanDate;
		this.godownCode = godownCode;
		this.noOfItems = noOfItems;
		this.rawMaterialIssueForConsumptionDataEntries = rawMaterialIssueForConsumptionDataEntries;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDateOfEntry() {
		return dateOfEntry;
	}

	public void setDateOfEntry(String dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
	}

	public String getChallanNo() {
		return challanNo;
	}

	public void setChallanNo(String challanNo) {
		this.challanNo = challanNo;
	}

	public String getChallanDate() {
		return challanDate;
	}

	public void setChallanDate(String challanDate) {
		this.challanDate = challanDate;
	}

	public String getGodownCode() {
		return godownCode;
	}

	public void setGodownCode(String godownCode) {
		this.godownCode = godownCode;
	}

	public int getNoOfItems() {
		return noOfItems;
	}

	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}

	public List<RawMaterialIssueForConsumptionData> getRawMaterialIssueForConsumptionDataEntries() {
		return rawMaterialIssueForConsumptionDataEntries;
	}

	public void setRawMaterialIssueForConsumptionDataEntries(
			List<RawMaterialIssueForConsumptionData> rawMaterialIssueForConsumptionDataEntries) {
		this.rawMaterialIssueForConsumptionDataEntries = rawMaterialIssueForConsumptionDataEntries;
	}

	
}
