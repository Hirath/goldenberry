package com.hirath.goldenberry.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InstanceExampleFactory {
	private static final Map<String, Object> values = new HashMap<>();

	InstanceExampleFactory(){
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
	
	private void add(Object object) {
		values.put(object.getClass().getName(), object);
	}

	public static Object anyValueOf(String typeName){
		return values.get(typeName);
	}

	public static Object anyOf(Class<?> type){
		return anyValueOf(type.getName());
	}

	public static List<Object> randomValues() {
		return new ArrayList<>(values.values());
	}
}
