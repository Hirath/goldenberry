package com.hirath.goldenberry.api;

import com.hirath.goldenberry.api.function.Operation;

abstract class OperationSignature {
	abstract Operation getOperation();
	abstract Class<?> getReturnType();
	abstract Class<?>[] getParametersType();
}
