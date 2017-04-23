package com.hirath.goldenberry.core.operation;

import java.lang.reflect.Method;

import com.hirath.goldenberry.api.function.Operation;

public interface OperationBuilder<T> {
	Operation from(Method upon, T signature);
}
