package com.hirath.goldenberry.core.selector;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import com.hirath.goldenberry.core.TestInterface;

import com.hirath.goldenberry.core.selector.FromMethodSelector;

public class FromMethodSelectorTests {
	FromMethodSelector selector = new FromMethodSelector();
	@Test
	public void selectMatchingMethod_NullMethodOnList_Empty() throws Exception {
		Optional<Method> underlyingMethod = selector.selectMatchingMethod(List.class, null);

		Assertions.assertThat(underlyingMethod).isEmpty();
	}

	@Test
	public void selectMatchingMethod_AddMethodOnList_AddMethod() throws Exception {
		Method method = List.class.getMethod("add", Object.class);
		Optional<Method> underlyingMethod = selector.selectMatchingMethod(List.class, method);

		Assertions.assertThat(underlyingMethod).hasValue(method);
	}
	
	@Test
	public void selectMatchingMethod_AddMethodTestInterfaceOnList_AddMethod() throws Exception {
		Method method = TestInterface.class.getMethod("add", Object.class);
		Optional<Method> underlyingMethod = selector.selectMatchingMethod(List.class, method);

		Method expectedMethod = List.class.getMethod("add", Object.class);
		Assertions.assertThat(underlyingMethod).hasValue(expectedMethod);
	}

}
