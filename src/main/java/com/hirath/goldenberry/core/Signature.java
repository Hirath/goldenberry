package com.hirath.goldenberry.core;

public class Signature {
	Class<?> returnType;
	Class<?>[] parametersType;
	
	public Signature(Class<?> returnType, Class<?>[] parametersType) {
		this.returnType = returnType;
		this.parametersType = parametersType;
	}
	
	public Class<?> getReturnType() {
		return returnType;
	}

	public Class<?>[] getParametersType() {
		return parametersType;
	}
}
