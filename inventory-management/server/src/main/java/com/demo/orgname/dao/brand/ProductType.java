package com.demo.orgname.dao.brand;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.demo.orgname.service.brand.ProductTypeBo;
import com.demo.orgname.service.rawmaterial.RawMaterialUnitBo;

@Entity
@Table(name = "product_type", catalog = "sbw")
public class ProductType {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "id", nullable = false)
	private String id;
	@Column(name = "name", unique = true, nullable = false)
	private String name;
	
	public ProductType() {
	}
	
	public ProductType(ProductTypeBo bo) {
		this.setId(bo.getId());
		this.setName(bo.getName());
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
	
	
}
