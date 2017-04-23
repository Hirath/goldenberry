package com.hirath.goldenberry.core.resolver;

import java.lang.reflect.Method;
import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import com.hirath.goldenberry.core.OperationFactory;

import javassist.expr.MethodCall;

public class ClassMethodResolver implements MethodResolver<Class<?>>{
		
	public Map<Method,OperationFactory> resolve(Class<?> sourceClass, Class<?> delegateClass,  int index){
		Method[] methods = sourceClass.getDeclaredMethods();
		return Arrays.stream(methods)
		       .sorted(Comparator.comparing(MethodHasher::getMethodHash))
		       .map(method -> getMatching(method, delegateClass, index))
		       .filter(Optional::isPresent)
		       .map(Optional::get)
		       .collect(Collectors.toMap(Entry::getKey, Entry::getValue));
	}
	
	private Optional<Entry<Method,OperationFactory>> getMatching(Method sourceMethod, Class<?> delegateClass, int index){
		try {
			OperationFactory operation;
				Method delegateMethod = delegateClass.getMethod(sourceMethod.getName(), sourceMethod.getParameterTypes());
				operation = new OperationFactory(index, new MethodCall(delegateMethod));
			return Optional.of(new SimpleEntry<>(sourceMethod, operation));
		} catch (NoSuchMethodException | SecurityException e) {
			return Optional.empty();
		}
	}
}
