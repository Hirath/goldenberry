package com.hirath.goldenberry.core.converter;

import static java.lang.Integer.MAX_VALUE;

public class SameClassConverter implements Converter{
	public Object convert(Object object, Class<?> toType){
		return object;
	}

	@Override
	public int matches(Object object, Class<?> toType) {
		return object==null || toType==null || toType.isInstance(object) ? 0 : MAX_VALUE;
	}
}
