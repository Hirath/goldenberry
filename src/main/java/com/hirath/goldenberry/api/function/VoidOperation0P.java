package com.hirath.goldenberry.api.function;

@FunctionalInterface
public interface VoidOperation0P extends Operation{
	public void perform() throws Exception;

	default Object execute(Object[] params) throws Exception {
		this.perform();
		return null;
	}
}
