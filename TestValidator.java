package com.dcml.cms.controller;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class TestValidator implements ConstraintValidator<TestAnno,Integer> {
    @Override
    public void initialize(TestAnno constraintAnnotation) {

    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return  value % 2 != 0 ;
    }
	
	 
}
