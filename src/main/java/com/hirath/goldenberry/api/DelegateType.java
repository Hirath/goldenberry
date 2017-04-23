package com.hirath.goldenberry.api;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class DelegateType<T> {
	Class<?> getType(){
		Type type = this.getClass().getGenericSuperclass();
		ParameterizedType parametrizedType = (ParameterizedType) type;
		Type delagateType = parametrizedType.getActualTypeArguments()[0];
		if(delagateType instanceof ParameterizedType){
			ParameterizedType delagateParametrizedType = (ParameterizedType) delagateType;
			return (Class<?>) delagateParametrizedType.getRawType();
		}else{
			return (Class<?>) delagateType;
		}
	}
}
