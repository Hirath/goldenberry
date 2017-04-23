package com.hirath.goldenberry.api.function;

@FunctionalInterface
public interface ReturnOperation1P<R,P1> extends Operation{
	R perform(P1 param1) throws Exception;

	default Object execute(Object[] params) throws Exception {
		return this.perform(get(0, params));
	}
}
