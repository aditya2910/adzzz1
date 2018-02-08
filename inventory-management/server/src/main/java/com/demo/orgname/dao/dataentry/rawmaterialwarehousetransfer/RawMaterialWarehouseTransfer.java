package com.demo.orgname.dao.dataentry.rawmaterialwarehousetransfer;

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
@Table(name="dataentry_rm_warehouse_transfer_metadata", catalog = "sbw")
public class RawMaterialWarehouseTransfer {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "id", nullable = false)
	private String id;
	@Column(name = "challan_no", nullable = false)
	private String challanNo; //e.g.- PKR/OT/125; PKR-jaha se raw material originate kiya, OT-other material, TB-tobacco
	@Column(name = "received_or_issued_Date", nullable = false)
	private String receivedOrIssuedDate;
	@Column(name = "receiver_godown_code", nullable = false)
	private String receiverGodownCode;
	@Column(name = "issuer_godown_code", nullable = false)
	private String issuerGodownCode;
	@Column(name = "vehicle_type", nullable = false)
	private String vehicleType;
	@Column(name = "vehicle_no", nullable = false)
	private String vehicleNo;
	@Column(name = "transporter_name", nullable = false)
	private String transporterName;
	@Column(name = "transporter_phone", nullable = false)
	private String transporterPhone;
	@Column(name = "transporter_address", nullable = false)
	private String  transporterAddress;
	@Column(name = "no_of_items", nullable = false)
	private int noOfItems;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "rawMaterialWarehouseTransfer", cascade = CascadeType.ALL)
    private List<RawMaterialWarehouseTransferData> RawMaterialWarehouseTransferDataEntries;

	public RawMaterialWarehouseTransfer() {
	}

	public RawMaterialWarehouseTransfer(String id, String challanNo, String receivedOrIssuedDate,
			String receiverGodownCode, String issuerGodownCode, String vehicleType, String vehicleNo,
			String transporterName, String transporterPhone, String transporterAddress, int noOfItems,
			List<RawMaterialWarehouseTransferData> rawMaterialWarehouseTransferDataEntries) {
		super();
		this.id = id;
		this.challanNo = challanNo;
		this.receivedOrIssuedDate = receivedOrIssuedDate;
		this.receiverGodownCode = receiverGodownCode;
		this.issuerGodownCode = issuerGodownCode;
		this.vehicleType = vehicleType;
		this.vehicleNo = vehicleNo;
		this.transporterName = transporterName;
		this.transporterPhone = transporterPhone;
		this.transporterAddress = transporterAddress;
		this.noOfItems = noOfItems;
		RawMaterialWarehouseTransferDataEntries = rawMaterialWarehouseTransferDataEntries;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getChallanNo() {
		return challanNo;
	}

	public void setChallanNo(String challanNo) {
		this.challanNo = challanNo;
	}

	public String getReceivedOrIssuedDate() {
		return receivedOrIssuedDate;
	}

	public void setReceivedOrIssuedDate(String receivedOrIssuedDate) {
		this.receivedOrIssuedDate = receivedOrIssuedDate;
	}

	public String getReceiverGodownCode() {
		return receiverGodownCode;
	}

	public void setReceiverGodownCode(String receiverGodownCode) {
		this.receiverGodownCode = receiverGodownCode;
	}

	public String getIssuerGodownCode() {
		return issuerGodownCode;
	}

	public void setIssuerGodownCode(String issuerGodownCode) {
		this.issuerGodownCode = issuerGodownCode;
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

	public String getTransporterName() {
		return transporterName;
	}

	public void setTransporterName(String transporterName) {
		this.transporterName = transporterName;
	}

	public String getTransporterPhone() {
		return transporterPhone;
	}

	public void setTransporterPhone(String transporterPhone) {
		this.transporterPhone = transporterPhone;
	}

	public String getTransporterAddress() {
		return transporterAddress;
	}

	public void setTransporterAddress(String transporterAddress) {
		this.transporterAddress = transporterAddress;
	}

	public int getNoOfItems() {
		return noOfItems;
	}

	public void setNoOfItems(int noOfItems) {
		this.noOfItems = noOfItems;
	}

	public List<RawMaterialWarehouseTransferData> getRawMaterialWarehouseTransferDataEntries() {
		return RawMaterialWarehouseTransferDataEntries;
	}

	public void setRawMaterialWarehouseTransferDataEntries(
			List<RawMaterialWarehouseTransferData> rawMaterialWarehouseTransferDataEntries) {
		RawMaterialWarehouseTransferDataEntries = rawMaterialWarehouseTransferDataEntries;
	}
}
