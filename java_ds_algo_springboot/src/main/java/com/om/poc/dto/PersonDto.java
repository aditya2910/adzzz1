package com.om.poc.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.om.poc.util.CustomValidator;
import com.om.poc.util.ValidateDate;

//@JsonDeserialize(using = PersonDtoDeSerializer.class)
public class PersonDto {



  @NotNull
  private int id;
  private String name;

//  @Min( value = 1459)
//  @UpToNextYear
//  private Integer birthdate;


  @JsonFormat(with = {JsonFormat.Feature.WRITE_DATES_WITH_ZONE_ID}, shape=JsonFormat.Shape.STRING, lenient= OptBoolean.FALSE, pattern="yyyy-MM-dd")
  //@ValidateDate(format = "yyyy-MM-dd")
  //@JsonDeserialize(using = CustomValidator.class)
  private Date birthdate;

  public int getId() {
    return id;
  }

  public void setId(final int id) {

    this.id = id;

  }

  public String getName() {
    return name;
  }

  public void setName(final String name) {
    this.name = name;
  }


  public Date getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(final Date birthdate) {
    this.birthdate = birthdate;
  }

  @Override
  public String toString() {
    return "PersonDto{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", birthdate=" + birthdate + '}';
  }
}
