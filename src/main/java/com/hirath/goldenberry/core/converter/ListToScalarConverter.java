package com.hirath.goldenberry.core.converter;

import static java.lang.Integer.MAX_VALUE;

import java.util.List;

public class ListToScalarConverter implements Converter{
	public Object convert(Object object, Class<?> toType){
		return null;
	}
	//&& ((List<?>) object).size() < 2

	@Override
	public int matches(Object object, Class<?> toType) {
		if(object instanceof List && ((List<?>) object).size() < 2 && !List.class.isAssignableFrom(toType)){
			return 0;
		}
		return MAX_VALUE;
	}
}
