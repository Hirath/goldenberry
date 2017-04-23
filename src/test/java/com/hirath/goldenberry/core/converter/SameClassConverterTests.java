package com.hirath.goldenberry.core.converter;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class SameClassConverterTests {

	SameClassConverter converter = new SameClassConverter();

	@Test
	public void matches_StringToString_0() {
		int result = converter.matches("input", String.class);
		
		Assertions.assertThat(result).isEqualTo(0);
	}
	
	@Test
	public void matches_IntToString_GreaterThen0() {
		int result = converter.matches(0, String.class);
		
		Assertions.assertThat(result).isGreaterThan(0);
	}
	
	@Test
	public void matches_NullToString_0() {
		int result = converter.matches(null, String.class);
		
		Assertions.assertThat(result).isEqualTo(0);
	}
	
	@Test
	public void matches_StringToNull_0() {
		int result = converter.matches("input", null);
		
		Assertions.assertThat(result).isEqualTo(0);
	}
	
	@Test
	public void convert_StringToString_0() {
		Object result = converter.convert("input", String.class);
		
		Assertions.assertThat(result).isEqualTo("input");
	}
}
