package com.hirath.goldenberry.core.converter;

public interface Converter {
	int matches(Object object, Class<?> toType);
	Object convert(Object object, Class<?> toType);
}
