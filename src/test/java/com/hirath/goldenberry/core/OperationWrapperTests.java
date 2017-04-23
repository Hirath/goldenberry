package com.hirath.goldenberry.core;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import com.hirath.goldenberry.api.function.Operation;
import com.hirath.goldenberry.api.function.ReturnOperation1P;

public class OperationWrapperTests {

	@Test
	public void testBefore() throws Exception {
		List<String> list = new ArrayList<>();
		ReturnOperation1P<Boolean,String> operation = list::add;
		Operation before = operation.before(params -> new String[]{"test"});
		before.execute(new Integer[]{4});
		Assertions.assertThat(list).contains("test");
	}
	
	@Test
	public void testAfter() throws Exception {
		List<String> list = new ArrayList<>();
		ReturnOperation1P<Boolean,String> operation = list::add;
		Operation after = operation.after(params -> 4);
		Object result = after.execute(new String[]{"test"});
		Assertions.assertThat(result).isEqualTo(4);
	}

}
