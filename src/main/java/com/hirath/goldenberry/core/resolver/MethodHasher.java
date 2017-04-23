package com.hirath.goldenberry.core.resolver;

import java.lang.reflect.Method;

public class MethodHasher {

	public static String getMethodHash(Method method){
		return method.getName();
	}
}
