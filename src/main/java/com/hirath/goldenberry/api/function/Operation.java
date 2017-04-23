package com.hirath.goldenberry.api.function;

import java.util.Optional;

public interface Operation {
	Object execute(Object[] params) throws Exception;
	
	@SuppressWarnings("unchecked")
	default <E> E get(int index, Object[] params){
		Object ret = Optional.ofNullable(params)
				.filter(p -> p.length > index)
				.map(p -> p[index])
				.orElse(null);
		return (E) ret;
	}
	
	default Operation before(ReturnOperation1P<Object[],Object[]> preProcessor){
		return  params -> this.execute(preProcessor.perform(params));
	}
	
	default Operation after(ReturnOperation1P<Object,Object> postProcessor){
		return  params -> postProcessor.perform(this.execute(params));
	}
	
}
