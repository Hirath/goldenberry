package com.hirath.goldenberry.core;

import java.awt.List;
import java.lang.reflect.Method;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class OpertaionFactoryMatcherTests {
	
	@Test
	public void whichFactoryMatches_Null_Empty(){
		Optional<OperationFactory> result = OpertaionFactoryMatcher.whichFactoryMatches(null).on(List.class);
		Assertions.assertThat(result).isEmpty();
	}
	
	@Test
	public void whichFactoryMatches_AddMethod$List_Empty() throws NoSuchMethodException, SecurityException{
		Method add = List.class.getMethod("add", Object.class);
		Optional<OperationFactory> result = OpertaionFactoryMatcher.whichFactoryMatches(add).on(List.class);
		Assertions.assertThat(result).isNotEmpty();
	}
}
