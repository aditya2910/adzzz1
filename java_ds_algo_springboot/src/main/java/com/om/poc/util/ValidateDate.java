package com.om.poc.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target( {ElementType.FIELD, ElementType.METHOD, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention( RetentionPolicy.RUNTIME)
@Constraint( validatedBy = ValidateDateImpl.class)
public @interface ValidateDate {
  String message() default
      "The value of year must be between 1459 and next year!";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};

  String format();
}