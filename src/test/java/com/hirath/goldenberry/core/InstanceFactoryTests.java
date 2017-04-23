package com.hirath.goldenberry.core;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class InstanceFactoryTests {
	@Test
		public void testAnyValueOfString_Integer_Integer() throws Exception {
			InstanceExampleFactory factory = new InstanceExampleFactory();
			Assertions.assertThat(factory.anyValueOf(Integer.class.getName())).isInstanceOf(Integer.class);
		}
	
	@Test
		public void testAnyValueOfString_Object_Null() throws Exception {
			InstanceExampleFactory factory = new InstanceExampleFactory();
			Assertions.assertThat(factory.anyValueOf(Object.class.getName())).isNull();
		}
}
