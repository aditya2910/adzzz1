package com.demo.orgname.dao.dataentry.rawmaterialinward;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="dataentry_rm_inward", catalog = "sbw")
public class RawMaterialInwardDataEntry implements Serializable {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "id", nullable = false)
	private String de_id;
	@Column(name = "identifier")
	private String identifier;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "de_id", referencedColumnName="id")
	private RawMaterialInwardDataEntryMaster rawMaterialInwardDataEntryMaster;
	
	public RawMaterialInwardDataEntry() {
		
	}

	public RawMaterialInwardDataEntry(String de_id, String identifier,
			RawMaterialInwardDataEntryMaster rawMaterialInwardDataEntryMaster) {
		super();
		this.identifier = identifier;
		this.rawMaterialInwardDataEntryMaster = rawMaterialInwardDataEntryMaster;
	}

	public String getDe_id() {
		return de_id;
	}

	public void setDe_id(String de_id) {
		this.de_id = de_id;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public RawMaterialInwardDataEntryMaster getRawMaterialInwardDataEntryMaster() {
		return rawMaterialInwardDataEntryMaster;
	}

	public void setRawMaterialInwardDataEntryMaster(RawMaterialInwardDataEntryMaster rawMaterialInwardDataEntryMaster) {
		this.rawMaterialInwardDataEntryMaster = rawMaterialInwardDataEntryMaster;
	}

	
	
}
