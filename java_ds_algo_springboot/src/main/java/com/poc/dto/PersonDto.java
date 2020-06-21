package com.poc.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;

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
