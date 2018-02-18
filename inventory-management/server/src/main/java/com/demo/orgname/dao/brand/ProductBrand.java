package com.demo.orgname.dao.brand;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.demo.orgname.service.brand.ProductBrandBo;

@Entity
@Table(name = "product_brand", catalog = "sbw")
public class ProductBrand {
	// TODO: make a OneToMany Table for storing the names of RM used to make biris of different brands.
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "id", nullable = false)
	private String id;
	@Column(name = "name", unique = true, nullable = false)
	private String name;
	@Column(name = "type", nullable = false)
	private String type;
	
	public ProductBrand() {
	}
	
	public ProductBrand(ProductBrandBo bo) {
		this.setId(bo.getId());
		this.setName(bo.getName());
		this.setType(bo.getType());
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
}
