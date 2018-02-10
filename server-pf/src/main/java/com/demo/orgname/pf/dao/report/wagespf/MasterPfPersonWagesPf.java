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
	@Column(name = "gross_wage")
	private String grossWage;
	@Column(name = "epf_wage")
	private String epfWage;
	@Column(name = "eps_wage")
	private String epsWage;
	@Column(name = "edli_wage")
	private String edliWage;
	
	@Column(name = "ee_pf")
	private String eePf;
	@Column(name = "eps_pf")
	private String epsPf;
	@Column(name = "er_pf")
	private String erPf;
	
	@Column(name = "ncp_days")
	private String ncpDays;
	@Column(name = "refunds")
	private String refunds;
	
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
	public String getGrossWage() {
		return grossWage;
	}
	public void setGrossWage(String grossWage) {
		this.grossWage = grossWage;
	}
	public String getEpfWage() {
		return epfWage;
	}
	public void setEpfWage(String epfWage) {
		this.epfWage = epfWage;
	}
	public String getEpsWage() {
		return epsWage;
	}
	public void setEpsWage(String epsWage) {
		this.epsWage = epsWage;
	}
	public String getEdliWage() {
		return edliWage;
	}
	public void setEdliWage(String edliWage) {
		this.edliWage = edliWage;
	}
	public String getEePf() {
		return eePf;
	}
	public void setEePf(String eePf) {
		this.eePf = eePf;
	}
	public String getEpsPf() {
		return epsPf;
	}
	public void setEpsPf(String epsPf) {
		this.epsPf = epsPf;
	}
	public String getErPf() {
		return erPf;
	}
	public void setErPf(String erPf) {
		this.erPf = erPf;
	}
	public String getNcpDays() {
		return ncpDays;
	}
	public void setNcpDays(String ncpDays) {
		this.ncpDays = ncpDays;
	}
	public String getRefunds() {
		return refunds;
	}
	public void setRefunds(String refunds) {
		this.refunds = refunds;
	}
}
