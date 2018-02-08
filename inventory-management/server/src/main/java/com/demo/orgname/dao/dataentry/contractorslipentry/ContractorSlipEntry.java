package com.demo.orgname.dao.dataentry.contractorslipentry;

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
@Table(name="dataentry_contractor_slip_entry_metadata", catalog = "sbw")
public class ContractorSlipEntry {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "id", nullable = false)
	private String id;
	@Column(name = "date_of_entry", nullable = false)
	private String dateOfEntry;
	@Column(name = "transaction_no", nullable = false)
	private String transactionNo; // auto generate - day wise
	// below are Contractor Production
	@Column(name = "contractor_code", nullable = false)
	private String contractorCode;
	@Column(name = "product_godown_code", nullable = false)
	private String productGodownCode;
	@Column(name = "checker_code", nullable = false)
	private String checkerCode;
	@Column(name = "passed_by_checker_code", nullable = false)
	private String passedByCheckerCode;
	@Column(name = "no_of_checkers", nullable = false)
	private String noOfCheckers;
	// TODO: consumption rate code is not done yet
	@Column(name = "consumption_rate", nullable = false)
	private String consumptionRate;
	// below are Contractor Consumption
	// TODO: substract these from respective godowns
	@Column(name = "given_tobacco_quantity", nullable = false)
	private String givenTobaccoQuantity;
	@Column(name = "given_leaves_quantity", nullable = false)
	private String givenLeavesQuantity;
	@Column(name = "given_leaves_bag_quantity", nullable = false)
	private String givenLeavesBagQuantity;
	@Column(name = "given_yarn_quantity", nullable = false)
	private String givenYarnQuantity;
	@Column(name = "challan_no", nullable = false)
	private String challanNo; // auto generate - day wise
	@Column(name = "given_consumption_rate", nullable = false)
	private String givenConsumptionRate;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "contractorSlipEntry", cascade = CascadeType.ALL)
    private List<ContractorSlipEntryData> contractorSlipEntryDataEntries;
	
	public ContractorSlipEntry() {
	}

	public ContractorSlipEntry(String id, String dateOfEntry, String transactionNo, String contractorCode,
			String productGodownCode, String checkerCode, String passedByCheckerCode, String noOfCheckers,
			String consumptionRate, String givenTobaccoQuantity, String givenLeavesQuantity,
			String givenLeavesBagQuantity, String givenYarnQuantity, String challanNo, String givenConsumptionRate,
			List<ContractorSlipEntryData> contractorSlipEntryDataEntries) {
		super();
		this.id = id;
		this.dateOfEntry = dateOfEntry;
		this.transactionNo = transactionNo;
		this.contractorCode = contractorCode;
		this.productGodownCode = productGodownCode;
		this.checkerCode = checkerCode;
		this.passedByCheckerCode = passedByCheckerCode;
		this.noOfCheckers = noOfCheckers;
		this.consumptionRate = consumptionRate;
		this.givenTobaccoQuantity = givenTobaccoQuantity;
		this.givenLeavesQuantity = givenLeavesQuantity;
		this.givenLeavesBagQuantity = givenLeavesBagQuantity;
		this.givenYarnQuantity = givenYarnQuantity;
		this.challanNo = challanNo;
		this.givenConsumptionRate = givenConsumptionRate;
		this.contractorSlipEntryDataEntries = contractorSlipEntryDataEntries;
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

	public String getTransactionNo() {
		return transactionNo;
	}

	public void setTransactionNo(String transactionNo) {
		this.transactionNo = transactionNo;
	}

	public String getContractorCode() {
		return contractorCode;
	}

	public void setContractorCode(String contractorCode) {
		this.contractorCode = contractorCode;
	}

	public String getProductGodownCode() {
		return productGodownCode;
	}

	public void setProductGodownCode(String productGodownCode) {
		this.productGodownCode = productGodownCode;
	}

	public String getCheckerCode() {
		return checkerCode;
	}

	public void setCheckerCode(String checkerCode) {
		this.checkerCode = checkerCode;
	}

	public String getPassedByCheckerCode() {
		return passedByCheckerCode;
	}

	public void setPassedByCheckerCode(String passedByCheckerCode) {
		this.passedByCheckerCode = passedByCheckerCode;
	}

	public String getNoOfCheckers() {
		return noOfCheckers;
	}

	public void setNoOfCheckers(String noOfCheckers) {
		this.noOfCheckers = noOfCheckers;
	}

	public String getConsumptionRate() {
		return consumptionRate;
	}

	public void setConsumptionRate(String consumptionRate) {
		this.consumptionRate = consumptionRate;
	}

	public String getGivenTobaccoQuantity() {
		return givenTobaccoQuantity;
	}

	public void setGivenTobaccoQuantity(String givenTobaccoQuantity) {
		this.givenTobaccoQuantity = givenTobaccoQuantity;
	}

	public String getGivenLeavesQuantity() {
		return givenLeavesQuantity;
	}

	public void setGivenLeavesQuantity(String givenLeavesQuantity) {
		this.givenLeavesQuantity = givenLeavesQuantity;
	}

	public String getGivenLeavesBagQuantity() {
		return givenLeavesBagQuantity;
	}

	public void setGivenLeavesBagQuantity(String givenLeavesBagQuantity) {
		this.givenLeavesBagQuantity = givenLeavesBagQuantity;
	}

	public String getGivenYarnQuantity() {
		return givenYarnQuantity;
	}

	public void setGivenYarnQuantity(String givenYarnQuantity) {
		this.givenYarnQuantity = givenYarnQuantity;
	}

	public String getChallanNo() {
		return challanNo;
	}

	public void setChallanNo(String challanNo) {
		this.challanNo = challanNo;
	}

	public String getGivenConsumptionRate() {
		return givenConsumptionRate;
	}

	public void setGivenConsumptionRate(String givenConsumptionRate) {
		this.givenConsumptionRate = givenConsumptionRate;
	}

	public List<ContractorSlipEntryData> getContractorSlipEntryDataEntries() {
		return contractorSlipEntryDataEntries;
	}

	public void setContractorSlipEntryDataEntries(List<ContractorSlipEntryData> contractorSlipEntryDataEntries) {
		this.contractorSlipEntryDataEntries = contractorSlipEntryDataEntries;
	}

	
}
