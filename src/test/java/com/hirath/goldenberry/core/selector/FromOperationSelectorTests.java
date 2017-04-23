package com.hirath.goldenberry.core.selector;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import com.hirath.goldenberry.api.function.ReturnOperation2P;
import com.hirath.goldenberry.core.selector.FromOperationSelector;

public class FromOperationSelectorTests {

	FromOperationSelector selector = new FromOperationSelector();
	@Test
	public void selectMatchingMethod_AddOperationOnList_AddMethod() throws NoSuchMethodException, SecurityException{
		ReturnOperation2P<Boolean, List<String>, String> operation = List::add;
		
		Optional<Method> underlyingMethod = selector.selectMatchingMethod(List.class, operation);
		
		Assertions.assertThat(underlyingMethod).isNotEmpty();
		Method expectedMethod = List.class.getMethod("add", Object.class);
		Assertions.assertThat(underlyingMethod).hasValue(expectedMethod);
	}
	
	@Test
	public void selectMatchingMethod_AddOperationOnMap_AddMethod() throws NoSuchMethodException, SecurityException{
		ReturnOperation2P<Boolean, List<String>, String> operation = List::add;
		
		Optional<Method> underlyingMethod = selector.selectMatchingMethod(Map.class, operation);
		
		Assertions.assertThat(underlyingMethod).isEmpty();
	}
	
	@Test
	public void selectMatchingMethod_NullOperationOnMap_AddMethod() throws NoSuchMethodException, SecurityException{
		Optional<Method> underlyingMethod = selector.selectMatchingMethod(Map.class, null);
		
		Assertions.assertThat(underlyingMethod).isEmpty();
	}
	
	@Test
	public void selectMatchingMethod_AddOperationOnNull_AddMethod() throws NoSuchMethodException, SecurityException{
		ReturnOperation2P<Boolean, List<String>, String> operation = List::add;
		
		Optional<Method> underlyingMethod = selector.selectMatchingMethod(null, operation);
		
		Assertions.assertThat(underlyingMethod).isEmpty();
	}
	
}
