package com.hirath.goldenberry.core.selector;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import com.hirath.goldenberry.core.selector.MethodArgumentValues;

public class MethodArgumentValuesTests {
	@Test
	public void testUpdateFirst() throws Exception {
		MethodArgumentValues parameters = new MethodArgumentValues("test");
		parameters.updateFirst(String.class.getName(), Integer.class.getName());
		Assertions.assertThat(parameters.argumentValues).startsWith(0);
	}

	@Test
	public void testToArray() throws Exception {
		MethodArgumentValues parameters = new MethodArgumentValues("test");
		Assertions.assertThat(parameters.toArray()).startsWith("test");
	}
}
