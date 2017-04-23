package com.hirath.goldenberry.core.selector;

import java.lang.reflect.Method;
import java.util.Map;

import com.hirath.goldenberry.core.OperationFactory;

public interface OperationFactorySelector<T,E> {
    boolean matches(E delegate);
    Map<Method,OperationFactory> selectMatchingOperationFactories(Class<T> type, E delegateType);
}
