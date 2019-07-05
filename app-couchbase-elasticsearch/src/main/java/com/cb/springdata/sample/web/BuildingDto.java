package com.cb.springdata.sample.web;

import javax.validation.constraints.NotNull;

public class BuildingDto {
	
	@NotNull
    private String id;

    @NotNull
    private String name;

    @NotNull
    private String companyId;

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

	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}

}
