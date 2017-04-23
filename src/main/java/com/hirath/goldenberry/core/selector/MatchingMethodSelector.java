package com.hirath.goldenberry.core.selector;

import java.lang.reflect.Method;
import java.util.Optional;

interface MatchingMethodSelector<T> {
	Optional<Method> selectMatchingMethod(Class<?> type, T match);
}
