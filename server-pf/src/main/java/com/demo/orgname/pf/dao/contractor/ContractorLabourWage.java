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
	@Column(name = "contractor_labours_wage")
	private String contractorLaboursWage;
	
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
	public String getContractorLaboursWage() {
		return contractorLaboursWage;
	}
	public void setContractorLaboursWage(String contractorLaboursWage) {
		this.contractorLaboursWage = contractorLaboursWage;
	}
}
