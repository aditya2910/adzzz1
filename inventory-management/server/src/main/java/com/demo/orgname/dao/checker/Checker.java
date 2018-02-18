package com.demo.orgname.dao.checker;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.demo.orgname.service.checker.CheckerBo;

@Entity
@Table(name="checker", catalog = "sbw")
public class Checker {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "id", nullable = false)
	private String id;
	@Column(name = "name", nullable = false)
    private String name;
	@Column(name = "address", nullable = false)
    private String address;
	@Column(name = "phone", unique=true, nullable = false)
    private String phone;
	
	public Checker() {
		super();
	}

	public Checker(CheckerBo bo) {
		this.setId(bo.getId());
		this.setName(bo.getName());
		this.setAddress(bo.getAddress());
		this.setPhone(bo.getPhone());
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
