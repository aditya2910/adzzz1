package com.demo.orgname.dao.storage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.demo.orgname.service.storage.FactoryBo;

@Entity
@Table(name="rm_factory", catalog = "sbw")
public class Factory {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "id", nullable = false)
	private String id;
	@Column(name = "name", nullable = false)
    private String name;
	@Column(name = "type", unique=true, nullable = false)
    private String type; // TODO: keep type as empty till PROD
	@Column(name = "area", nullable = false)
    private String area;
	@Column(name = "address", unique=true, nullable = false)
    private String address;
	@Column(name = "phone", unique=true, nullable = false)
    private String phone;
	
	public Factory() {
	}
	
	public Factory(FactoryBo bo) {
		this.setId(bo.getId());
		this.setName(bo.getName());
		this.setType(bo.getType());
		this.setArea(bo.getArea());
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
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
