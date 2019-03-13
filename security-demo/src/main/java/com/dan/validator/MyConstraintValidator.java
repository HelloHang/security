package com.dan.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/**
 * Created by dangao on 3/5/2019.
 */
public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object>
{
	@Override
	public void initialize(MyConstraint constraintAnnotation)
	{

	}

	@Override
	public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext)
	{
		System.out.println(o);
		return true;
	}
}
