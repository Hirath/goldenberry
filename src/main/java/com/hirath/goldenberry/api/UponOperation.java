package com.hirath.goldenberry.api;

import java.util.Map;

import com.hirath.goldenberry.api.function.Operation;

public interface UponOperation {
	Map<Operation,Operation> resolve();
}
