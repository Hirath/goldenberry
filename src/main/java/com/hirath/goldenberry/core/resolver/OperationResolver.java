package com.hirath.goldenberry.core.resolver;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.hirath.dynamics.api.functions.Operation;
import com.hirath.dynamics.core.operation.OperationCall;
import com.hirath.dynamics.core.operation.OperationFactory;

public class OperationResolver {

	private static final Map<String, Object> PARMETERS = new HashMap<>();
	static {
		add("");
		add(true);
		add((int) 0);
		add((short) 0);
		add((byte) 0);
		add((long) 0);
		add((double) 0);
		add((float) 0);
		add('a');
		add(new ArrayList<String>());
		add(new Thread());
		add(new Exception());
		add(new NumberFormatException());
	}

	private static void add(Object object) {
		PARMETERS.put(object.getClass().getName(), object);
	}

	public Map<Method, OperationFactory> resolve(Class<?> sourceClass, List<Operation> operations) {
		Map<Method, OperationFactory> uponMappings = new HashMap<>();
		for (int i = 0; i < operations.size(); i++) {
			Operation operation = operations.get(i);
			Entry<Method, OperationFactory> uponOpertaion = resolveMethod(sourceClass, operation, i);
			uponMappings.put(uponOpertaion.getKey(), uponOpertaion.getValue());
		}
		return uponMappings;
	}

	private <T> Entry<Method, OperationFactory> resolveMethod(Class<T> klass, Operation function, int index) {
		List<Method> resolvedMethods = new ArrayList<>();
		List<Object> parameterValues = new ArrayList<>();

		Object proxy = Proxy.newProxyInstance(klass.getClassLoader(), new Class[] { klass }, (p, method, args) -> {
			resolvedMethods.add(method);
			Class<?> returnType = method.getReturnType();
			return PARMETERS.get(returnType.getName());
		});

		parameterValues.add(proxy);
		parameterValues.addAll(PARMETERS.values());

		Exception exception;
		do {
			try {
				function.execute(parameterValues.toArray());
				exception = null;
			} catch (ClassCastException e) {
				String[] classes = e.getMessage().split(" cannot be cast to ");
				replace(parameterValues, classes[0], classes[1]);
				exception = e;
			} catch (Exception e) {
				exception = null;
			}
		} while (exception != null);

		Method method = resolvedMethods.get(resolvedMethods.size() - 1);
		OperationFactory factory = new OperationFactory(index, new OperationCall());
		return new SimpleEntry<>(method, factory);
	}

	private void replace(List<Object> parameterValues, String source, String target) {
		int index = 0;
		Class<?> klass;
		try {
			klass = Class.forName(source);
			for (int i = 0; i < parameterValues.size(); i++) {
				Object object = parameterValues.get(i);
				if (klass.isInstance(object)) {
					index = i;
				}
			}
			parameterValues.set(index, PARMETERS.get(target));
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

}
