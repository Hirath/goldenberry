package com.hirath.goldenberry.api;

import java.util.HashMap;
import java.util.Map;

import com.hirath.goldenberry.api.function.Operation;
import com.hirath.goldenberry.api.function.ReturnOperation1P;
import com.hirath.goldenberry.api.function.ReturnOperation2P;
import com.hirath.goldenberry.core.converter.ArrayConverter;
import com.hirath.goldenberry.core.converter.Converter;

public class UponReturnOperation2P<R,T,P1> implements UponOperation {

	DelegateBuilder<T> builder;

	ReturnOperation2P<R,T,P1> operation;
	
	OperationSignature signature;
	
	UponReturnOperation2P(DelegateBuilder<T> builder, ReturnOperation2P<R,T,P1> operation) {
		this.builder = builder;
		this.operation = operation;
	}

	public <R2,P12> ReturnOperation2PSignature<R2,T,P12> convert(Class<R2> returnType, Class<P12> paramType) {
		ReturnOperation2PSignature<R2,T,P12> signature =  new ReturnOperation2PSignature<>(builder, returnType, paramType);
		this.signature = signature;
		return signature;
	}

	ReturnOperation1P<Object[],Object[]> preProcessor;
	@Override
	public Map<Operation, Operation> resolve() {
		Map<Operation, Operation> operations = new HashMap<>();
		ReturnOperation1P<Object[],Object[]> preProcessor = new ArrayConverter(signature.getParametersType())::convert;
		ReturnOperation1P<Object,Object> postProcessor = new Converter(signature.getReturnType())::convert;
		operations.put(operation, signature.getOperation().before(preProcessor).after(postProcessor));
		return operations;
	}

	public DelegateBuilder<T> call(ReturnOperation1P<R,P1> opertaion) {
		return convert((Class<R>)null, (Class<P1>)null).call(opertaion);
	}
}
