package com.hirath.goldenberry.api.function;

public interface VoidOperation1P<P1> extends Operation{
    void perform(P1 param) throws Exception;
	
	default Object execute(Object[] params) throws Exception {
		this.perform(get(0, params));
		return null;
	}
}
