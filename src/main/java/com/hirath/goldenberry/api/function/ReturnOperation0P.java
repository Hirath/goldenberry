package com.hirath.goldenberry.api.function;

@FunctionalInterface
public interface ReturnOperation0P<R> extends Operation{
	public R perform() throws Exception;

	default Object execute(Object[] params) throws Exception {
		return this.perform();
	}
}
