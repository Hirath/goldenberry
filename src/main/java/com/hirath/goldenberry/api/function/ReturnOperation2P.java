package com.hirath.goldenberry.api.function;

@FunctionalInterface
public interface ReturnOperation2P<R,P1,P2> extends Operation{
	public R perform(P1 param1, P2 param2) throws Exception;

	default Object execute(Object[] params) throws Exception {
		return this.perform(get(0, params), get(1, params));
	}
}
