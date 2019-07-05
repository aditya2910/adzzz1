package com.cb.springdata.sample.entities;

import com.couchbase.client.java.repository.annotation.Field;
//import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Document
public class Building {

    @NotNull
    @Id
    private String id;

    @NotNull
    @Field
    private String name;

    @NotNull
    @Field
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
