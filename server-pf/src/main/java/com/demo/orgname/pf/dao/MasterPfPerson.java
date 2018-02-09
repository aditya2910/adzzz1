package com.demo.orgname.pf.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "master_pf_person", catalog = "org_pf")
public class MasterPfPerson {

	@Id
	@TableGenerator(name = "TABLE_GEN", table = "T_GENERATOR", pkColumnName = "GEN_KEY", pkColumnValue = "MONITOR2012.T_JUST_FOR_TEST", valueColumnName = "GEN_VALUE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TABLE_GEN")
	@Column(name = "id", nullable = false)
	private long id;
	@Column(name = "uan_no")
	private String uanNo;
	@Column(name = "name")
	private String name;
	@Column(name = "address")
	private String address;
	@Column(name = "munshi_code")
	private String munshiCode;

	public MasterPfPerson(String uanNo, String name, String address, String munshiCode) {
		super();
		this.uanNo = uanNo;
		this.name = name;
		this.address = address;
		this.munshiCode = munshiCode;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getMunshiCode() {
		return munshiCode;
	}

	public void setMunshiCode(String munshiCode) {
		this.munshiCode = munshiCode;
	}
}
