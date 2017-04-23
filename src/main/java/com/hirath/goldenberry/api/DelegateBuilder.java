package com.hirath.goldenberry.api;

import java.util.List;
import java.util.Optional;

import com.hirath.goldenberry.api.function.ReturnOperation2P;
import com.hirath.goldenberry.api.function.VoidOperation1P;

public class DelegateBuilder<T> {

	Class<?> delegateType;
	List<UponOperation> upons;
	
	DelegateBuilder(Class<?> type){
		this.delegateType = type;
	}
	
	public static <T>  DelegateBuilder<T> as(Class<T> type) {
		return Optional.ofNullable(type)
				.filter(Class::isInterface)
				.map(DelegateBuilder<T>::new)
				.orElseThrow(()-> new InterfaceRequiredException());
	}

	public static <T>  DelegateBuilder<T> as(DelegateType<T> type) {
		return Optional.ofNullable(type)
				.map(DelegateType::getType)
				.filter(Class::isInterface)
				.map(DelegateBuilder<T>::new)
				.orElseThrow(()-> new InterfaceRequiredException());
	}

	public <R,P1> UponReturnOperation2P<R,T,P1> upon(ReturnOperation2P<R,T,P1> operation) {
		return new UponReturnOperation2P<>(this, operation);
	}

	public <P1> UponVoidOperation0P<T> upon(VoidOperation1P<T> operation) {
		return new UponVoidOperation0P<>();
	}
}
