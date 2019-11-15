package com.om.poc.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidateDateImpl implements ConstraintValidator<ValidateDate, Date> {

  private String dateFormat;

  @Override
  public void initialize( ValidateDate arg0) {
    dateFormat = arg0.format();
  }
  @Override
  public boolean isValid( Date date,
                          ConstraintValidatorContext context) {
    System.out.println(date);
    System.out.println(this.dateFormat);

//    SimpleDateFormat sdf = new SimpleDateFormat(this.dateFormat);
//    Date date2 = sdf.parse(date);
    return true;
  }
}