package com.demo.orgname.dao.storage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

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
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public String getArea() {
		return area;
	}
	public String getAddress() {
		return address;
	}
	public String getPhone() {
		return phone;
	}
}
