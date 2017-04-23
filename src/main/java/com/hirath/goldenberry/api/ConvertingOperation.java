package com.hirath.goldenberry.api;

import com.hirath.goldenberry.api.function.Operation;

public class ConvertingOperation implements Operation{
	Operation operation;
	Class<?> returnType;
	Class<?>[] paramTypes;
	
	public ConvertingOperation(Operation operation, Class<?> returnType, Class<?>... paramTypes) {
		this.operation = operation;
		this.returnType = returnType;
		this.paramTypes = paramTypes;
	}
	
	@Override
	public Object execute(Object[] params) throws Exception {
		
		Object result = operation.execute(paramTypes);
		return result;
	}
	
}
