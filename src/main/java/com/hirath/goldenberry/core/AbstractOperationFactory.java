package com.hirath.goldenberry.core;

import java.util.List;

import com.hirath.goldenberry.api.function.Operation;

public abstract class AbstractOperationFactory implements OperationFactory{
	String name;
	Operation operation;
	@Override
	public Operation from(List<Operation> operations, List<Object> inferrences) {
		// TODO Auto-generated method stub
		return null;
	}

}
