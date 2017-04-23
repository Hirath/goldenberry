package com.hirath.goldenberry.core.selector;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.hirath.goldenberry.api.function.Operation;
import com.hirath.goldenberry.core.InstanceExampleFactory;

class FromOperationSelector implements MatchingMethodSelector<Operation> {
	public Optional<Method> selectMatchingMethod(Class<?> type, Operation operation) {
		if(type == null || operation == null)
			return Optional.empty();
		
		List<Method> resolvedMethods = new ArrayList<>();
		Object proxy = creationProxy(type, resolvedMethods);
		MethodArgumentValues parameterValues = new MethodArgumentValues(proxy);
		executeOperation(operation, parameterValues);
		return Optional.of(resolvedMethods).filter(l -> !l.isEmpty()).map(l -> l.get(0));
	}

	private Object creationProxy(Class<?> type, List<Method> resolvedMethods) {
		return Proxy.newProxyInstance(type.getClassLoader(), new Class[] { type }, (p, method, args) -> {
			resolvedMethods.add(method);
			return InstanceExampleFactory.anyOf(method.getReturnType());
		});
	}

	private void executeOperation(Operation operation, MethodArgumentValues parameterValues) {
		boolean executed = false;
		do {
			try {
				operation.execute(parameterValues.toArray());
				executed = true;
			} catch (ClassCastException e) {
				String[] classes = e.getMessage().split(" cannot be cast to ");
				parameterValues.updateFirst(classes[0], classes[1]);
				executed = false;
			} catch (Exception e) {
				executed = true;
			}
		} while (!executed);
	}
}
