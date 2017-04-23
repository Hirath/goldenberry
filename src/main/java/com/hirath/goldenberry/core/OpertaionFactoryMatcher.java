package com.hirath.goldenberry.core;

import java.util.Optional;

import com.hirath.goldenberry.api.function.Operation;

public class OpertaionFactoryMatcher {
	Operation operation;
	
	public OpertaionFactoryMatcher(Operation operation) {
		this.operation = operation;
	}
	
	public static OpertaionFactoryMatcher whichFactoryMatches(Operation operation) {
		return new OpertaionFactoryMatcher(operation);
	}

	public Optional<OperationFactory> on(Class<?> type) {
		return Optional.empty();
	}

}
