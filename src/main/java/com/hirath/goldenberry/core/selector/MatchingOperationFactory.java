package com.hirath.goldenberry.core.selector;

import java.lang.reflect.Method;
import java.security.Signature;
import java.util.Optional;

import com.hirath.goldenberry.api.function.Operation;

class MatchingOperationFactory {
	public Optional<Operation> from(Signature s) {
		return Optional.ofNullable(null);
	}
	
	public Optional<Operation> from(Method s) {
		return Optional.ofNullable(null);
	}
}
