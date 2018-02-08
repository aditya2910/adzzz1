package com.demo.orgname.dao.dataentry.contractorslipentry;

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
@Table(name="dataentry_contractor_slip_entry_data", catalog = "sbw")
public class ContractorSlipEntryData {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "id", nullable = false)
	private String deId;
	// TODO: create checker object
	@Column(name = "checker_code", nullable = false)
	private String checkerCode;
	@Column(name = "checker_name", nullable = false)
	private String checkerName;
	@Column(name = "time_from_to", nullable = false)
	private String timeFromTo;
	@Column(name = "neat_product_count", nullable = false)
	private String neatProductCount;
	@Column(name = "chhat_product_count", nullable = false)
	private String chhatProductCount;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "deId", referencedColumnName = "id")
	private ContractorSlipEntry contractorSlipEntry;
	
	public ContractorSlipEntryData() {
	}

	public ContractorSlipEntryData(String checkerCode, String checkerName, String timeFromTo, String neatProductCount,
			String chhatProductCount, ContractorSlipEntry contractorSlipEntry) {
		super();
		this.checkerCode = checkerCode;
		this.checkerName = checkerName;
		this.timeFromTo = timeFromTo;
		this.neatProductCount = neatProductCount;
		this.chhatProductCount = chhatProductCount;
		this.contractorSlipEntry = contractorSlipEntry;
	}

	public String getDeId() {
		return deId;
	}

	public void setDeId(String deId) {
		this.deId = deId;
	}

	public String getCheckerCode() {
		return checkerCode;
	}

	public void setCheckerCode(String checkerCode) {
		this.checkerCode = checkerCode;
	}

	public String getCheckerName() {
		return checkerName;
	}

	public void setCheckerName(String checkerName) {
		this.checkerName = checkerName;
	}

	public String getTimeFromTo() {
		return timeFromTo;
	}

	public void setTimeFromTo(String timeFromTo) {
		this.timeFromTo = timeFromTo;
	}

	public String getNeatProductCount() {
		return neatProductCount;
	}

	public void setNeatProductCount(String neatProductCount) {
		this.neatProductCount = neatProductCount;
	}

	public String getChhatProductCount() {
		return chhatProductCount;
	}

	public void setChhatProductCount(String chhatProductCount) {
		this.chhatProductCount = chhatProductCount;
	}

	public ContractorSlipEntry getContractorSlipEntry() {
		return contractorSlipEntry;
	}

	public void setContractorSlipEntry(ContractorSlipEntry contractorSlipEntry) {
		this.contractorSlipEntry = contractorSlipEntry;
	}
}
