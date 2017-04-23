package com.hirath.goldenberry.core.converter;

public class ArrayConverter {
	Class<?>[] type;

	public ArrayConverter(Class<?>[] type) {
		this.type = type;
	}

	public Object[] convert(Object[] object){
		return object;
	}
}
