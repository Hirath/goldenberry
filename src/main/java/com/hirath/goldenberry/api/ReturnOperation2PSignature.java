package com.hirath.goldenberry.api;

import com.hirath.goldenberry.api.function.Operation;
import com.hirath.goldenberry.api.function.ReturnOperation1P;

public class ReturnOperation2PSignature<R,T,P1> extends OperationSignature{
	DelegateBuilder<T> builder;
	Class<R> returnType;
	Class<P1> paramType;
	Operation operation;
	
	public ReturnOperation2PSignature(DelegateBuilder<T> builder, Class<R> returnType, Class<P1> paramType) {
		this.builder = builder;
		this.returnType = returnType;
		this.paramType = paramType;
	}

	public DelegateBuilder<T> call(ReturnOperation1P<R,P1> operation) {
		this.operation = operation;
		return builder;
	}

	@Override
	public Operation getOperation() {
		return operation;
	}

	@Override
	public Class<?> getReturnType() {
		return returnType;
	}

	@Override
	public Class<?>[] getParametersType() {
		return new Class<?>[]{paramType};
	}
}
