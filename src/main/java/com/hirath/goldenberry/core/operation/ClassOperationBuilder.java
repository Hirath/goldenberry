package com.hirath.goldenberry.core.operation;

import java.lang.reflect.Method;

import com.hirath.goldenberry.api.function.Operation;

public class ClassOperationBuilder implements OperationBuilder<Class<?>>{

	@Override
	public Operation from(Method upon, Class<?> type) {
		return null;
	}

}
