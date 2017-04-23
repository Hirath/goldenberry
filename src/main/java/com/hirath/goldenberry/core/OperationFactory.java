package com.hirath.goldenberry.core;

import java.util.List;

import com.hirath.goldenberry.api.function.Operation;

public interface OperationFactory {
	Operation from(List<Operation> operations, List<Object> inferrences);
}