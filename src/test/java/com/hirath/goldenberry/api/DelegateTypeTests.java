package com.hirath.goldenberry.api;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class DelegateTypeTests {

	@Test
	public void getType_List_List() throws Exception {
		DelegateType<List<String>> type = new DelegateType<List<String>>() {};
		Assertions.assertThat(type.getType()).isEqualTo(List.class);
	}
	
	@Test
	public void getType_String_String() throws Exception {
		DelegateType<String> type = new DelegateType<String>() {};
		Assertions.assertThat(type.getType()).isEqualTo(String.class);
	}

}
