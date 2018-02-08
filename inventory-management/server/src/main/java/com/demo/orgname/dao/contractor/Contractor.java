package com.demo.orgname.dao.contractor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="contractor", catalog = "sbw")
public class Contractor {

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
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public String getPhone() {
		return phone;
	}
}
