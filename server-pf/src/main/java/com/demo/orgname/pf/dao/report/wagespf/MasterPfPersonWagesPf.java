package com.demo.orgname.pf.dao.report.wagespf;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "master_pf_person_wages_pf", catalog = "org_pf")
public class MasterPfPersonWagesPf {
	
	@Id
	@TableGenerator(name = "TABLE_GEN", table = "T_GENERATOR", pkColumnName = "GEN_KEY", pkColumnValue = "MONITOR2012.T_JUST_FOR_TEST", valueColumnName = "GEN_VALUE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
	@Column(name = "id", nullable = false)
	private long id;
	@Column(name = "report_gen_date")
	private String reportGenDate;
	@Column(name = "uan_no", unique = true)
	private String uanNo;
	@Column(name = "name")
	private String name;
	@Column(name = "address")
	private String address;
	@Column(name = "contractor_code")
	private String contractorCode;
	@Column(name = "wage")
	private String wage;
	// TODO: create all the columns needs for all report in this table itself
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getReportGenDate() {
		return reportGenDate;
	}
	public void setReportGenDate(String reportGenDate) {
		this.reportGenDate = reportGenDate;
	}
	public String getUanNo() {
		return uanNo;
	}
	public void setUanNo(String uanNo) {
		this.uanNo = uanNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContractorCode() {
		return contractorCode;
	}
	public void setContractorCode(String contractorCode) {
		this.contractorCode = contractorCode;
	}
	public String getWage() {
		return wage;
	}
	public void setWage(String wage) {
		this.wage = wage;
	}
	
	
}
