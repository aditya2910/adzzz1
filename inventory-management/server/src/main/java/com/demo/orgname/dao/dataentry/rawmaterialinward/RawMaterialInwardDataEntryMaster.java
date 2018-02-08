package com.demo.orgname.dao.dataentry.rawmaterialinward;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
//@JsonFilter("RawMaterialInwardDataEntryMaster")
@Table(name="dataentry_rm_inward_master", catalog = "sbw")
public class RawMaterialInwardDataEntryMaster implements Serializable {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "id", nullable = false)
	private String id;
	@Column(name = "noOfItems", nullable = false)
	private int noOfItems;     // types of supply
	@Column(name = "dateOfEntry", nullable = false)
	private String dateOfEntry;
	@Column(name = "supplierCode", nullable = false)
	private String supplierCode;    // jaha se maal aaya  -- create object of Suppliers
	@Column(name = "godownCode", nullable = false)
	private String godownCode;
	@Column(name = "dispatchedFrom", nullable = false)
	private String dispatchedFrom;
	@Column(name = "recceivedAt", nullable = false)
	private String recceivedAt;
	@Column(name = "challanNo", nullable = false)
	private String challanNo;
	@Column(name = "challanDate", nullable = false)
	private String challanDate;
	@Column(name = "vehicleType", nullable = false)
	private String vehicleType;
	@Column(name = "vehicleNo", nullable = false)
	private String vehicleNo;
	@Column(name = "waybillNo", nullable = false)
	private String waybillNo;
	@Column(name = "advanceFreightAmount", nullable = false)
	private String advanceFreightAmount;
	@Column(name = "totalAmount", nullable = false)
	private String totalAmount;
	@Column(name = "factoryCode", nullable = false)
	private String factoryCode;
	@Column(name = "transporterName", nullable = false)
	private String transporterName;
	@Column(name = "transporterAddress", nullable = false)
	private String transporterAddress;
	@Column(name = "transporterPhone", nullable = false)
	private String transporterPhone;
	
	//@JoinColumn (name="de_id")
	@JsonManagedReference
	//@OneToMany(mappedBy = "rawMaterialInwardDataEntryMaster", cascade = CascadeType.ALL, targetEntity = RawMaterialInwardDataEntry.class, fetch = FetchType.LAZY)
	@OneToMany(mappedBy = "rawMaterialInwardDataEntryMaster", cascade = CascadeType.ALL)
    private List<RawMaterialInwardDataEntry> rawMaterialInwardDataEntries;
	
	public RawMaterialInwardDataEntryMaster() {
			
	}

	public RawMaterialInwardDataEntryMaster(String id, int noOfItems, String dateOfEntry, String supplierCode,
			String godownCode, String dispatchedFrom, String recceivedAt, String challanNo, String challanDate,
			String vehicleType, String vehicleNo, String waybillNo, String advanceFreightAmount, String totalAmount,
			String factoryCode, String transporterName, String transporterAddress, String transporterPhone,
			String identifier, List<RawMaterialInwardDataEntry> rawMaterialInwardDataEntries) {
		super();
		this.id = id;
		this.noOfItems = noOfItems;
		this.dateOfEntry = dateOfEntry;
		this.supplierCode = supplierCode;
		this.godownCode = godownCode;
		this.dispatchedFrom = dispatchedFrom;
		this.recceivedAt = recceivedAt;
		this.challanNo = challanNo;
		this.challanDate = challanDate;
		this.vehicleType = vehicleType;
		this.vehicleNo = vehicleNo;
		this.waybillNo = waybillNo;
		this.advanceFreightAmount = advanceFreightAmount;
		this.totalAmount = totalAmount;
		this.factoryCode = factoryCode;
		this.transporterName = transporterName;
		this.transporterAddress = transporterAddress;
		this.transporterPhone = transporterPhone;
		this.rawMaterialInwardDataEntries = rawMaterialInwardDataEntries;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNoOfItems() {
		return noOfItems;
	}

	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}

	public String getDateOfEntry() {
		return dateOfEntry;
	}

	public void setDateOfEntry(String dateOfEntry) {
		this.dateOfEntry = dateOfEntry;
	}

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getGodownCode() {
		return godownCode;
	}

	public void setGodownCode(String godownCode) {
		this.godownCode = godownCode;
	}

	public String getDispatchedFrom() {
		return dispatchedFrom;
	}

	public void setDispatchedFrom(String dispatchedFrom) {
		this.dispatchedFrom = dispatchedFrom;
	}

	public String getRecceivedAt() {
		return recceivedAt;
	}

	public void setRecceivedAt(String recceivedAt) {
		this.recceivedAt = recceivedAt;
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

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getWaybillNo() {
		return waybillNo;
	}

	public void setWaybillNo(String waybillNo) {
		this.waybillNo = waybillNo;
	}

	public String getAdvanceFreightAmount() {
		return advanceFreightAmount;
	}

	public void setAdvanceFreightAmount(String advanceFreightAmount) {
		this.advanceFreightAmount = advanceFreightAmount;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getFactoryCode() {
		return factoryCode;
	}

	public void setFactoryCode(String factoryCode) {
		this.factoryCode = factoryCode;
	}

	public String getTransporterName() {
		return transporterName;
	}

	public void setTransporterName(String transporterName) {
		this.transporterName = transporterName;
	}

	public String getTransporterAddress() {
		return transporterAddress;
	}

	public void setTransporterAddress(String transporterAddress) {
		this.transporterAddress = transporterAddress;
	}

	public String getTransporterPhone() {
		return transporterPhone;
	}

	public void setTransporterPhone(String transporterPhone) {
		this.transporterPhone = transporterPhone;
	}

	public List<RawMaterialInwardDataEntry> getRawMaterialInwardDataEntries() {
		return rawMaterialInwardDataEntries;
	}

	public void setRawMaterialInwardDataEntries(List<RawMaterialInwardDataEntry> rawMaterialInwardDataEntries) {
		this.rawMaterialInwardDataEntries = rawMaterialInwardDataEntries;
	}
	
	
	
    
}
