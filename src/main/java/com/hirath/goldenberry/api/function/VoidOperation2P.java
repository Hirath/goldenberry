package com.hirath.goldenberry.api.function;

public interface VoidOperation2P<P1,P2> extends Operation{
    void perform(P1 param1, P2 param2) throws Exception;
	
	default Object execute(Object[] params) throws Exception {
		this.perform(get(0, params), get(1, params));
		return null;
	}
}
