package com.hirath.goldenberry.core.converter;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ListToScalarConverterTests {
	ListToScalarConverter converter = new ListToScalarConverter();
	
	@Test
	public void matches_IntToString_MaxValue() {
		int result = converter.matches(0, String.class);
		
		Assertions.assertThat(result).isGreaterThan(0);
	}
	
	@Test
	public void matches_ListToString_0() {
		List<Object> list = new ArrayList<>();
		int result = converter.matches(list, String.class);
		
		Assertions.assertThat(result).isEqualTo(0);
	}
	
	@Test
	public void matches_ListToList_MaxValue() {
		List<Object> list = new ArrayList<>();
		int result = converter.matches(list, List.class);
		
		Assertions.assertThat(result).isEqualTo(Integer.MAX_VALUE);
	}
	
	@Test
	public void matches_ListOf2ElementsToString_MaxValue() {
		List<Object> list = new ArrayList<>();
		list.add(0);
		list.add(1);
		int result = converter.matches(list, String.class);
		
		Assertions.assertThat(result).isEqualTo(Integer.MAX_VALUE);
	}

}
