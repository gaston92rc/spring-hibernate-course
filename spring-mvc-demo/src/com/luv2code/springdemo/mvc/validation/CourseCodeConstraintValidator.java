package com.luv2code.springdemo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

   private String[] coursePrefix;

   public void initialize(CourseCode courseCode) {
      coursePrefix = courseCode.value();
   }

   public boolean isValid(String code, ConstraintValidatorContext constraintValidatorContext) {

      boolean result = false;

      if(code != null) {
         for (String tempPrefix : coursePrefix) {
            result = code.startsWith(tempPrefix);

            if (result) {
               break;
            }
         }
      }else{
         result = true;
      }
      return result;
   }
}
