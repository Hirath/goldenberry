package com.hirath.goldenberry.core.resolver;

import java.lang.reflect.Method;
import java.util.Map;

import com.hirath.goldenberry.core.OperationFactory;

public interface MethodResolver<T> {
	public Map<Method,OperationFactory> resolve(Class<?> sourceClass, T object);
}
