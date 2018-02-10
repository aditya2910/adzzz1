package com.demo.orgname.pf.dao.contractor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "contractor_labour_wage", catalog = "org_pf")
public class ContractorLabourWage {

	@Id
	@TableGenerator(name = "TABLE_GEN", table = "T_GENERATOR", pkColumnName = "GEN_KEY", pkColumnValue = "MONITOR2012.T_JUST_FOR_TEST", valueColumnName = "GEN_VALUE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
	@Column(name = "id", nullable = false)
	private long id;
	@Column(name = "contractor_code", unique = true)
	private String contractorCode;
	@Column(name = "contractor_labour_gross_wage")
	private String contractorLabourGrossWage;
	@Column(name = "contractor_labour_epf_wage")
	private String contractorLabourEpfWage;
	@Column(name = "ncp_days")
	private int ncpDays;
	
	public int getNcpDays() {
		return ncpDays;
	}
	public void setNcpDays(int ncpDays) {
		this.ncpDays = ncpDays;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContractorCode() {
		return contractorCode;
	}
	public void setContractorCode(String contractorCode) {
		this.contractorCode = contractorCode;
	}
	public String getContractorLabourGrossWage() {
		return contractorLabourGrossWage;
	}
	public void setContractorLabourGrossWage(String contractorLabourGrossWage) {
		this.contractorLabourGrossWage = contractorLabourGrossWage;
	}
	public String getContractorLabourEpfWage() {
		return contractorLabourEpfWage;
	}
	public void setContractorLabourEpfWage(String contractorLabourEpfWage) {
		this.contractorLabourEpfWage = contractorLabourEpfWage;
	}
	
	
	
}
