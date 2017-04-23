package com.hirath.goldenberry.api;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ReturnOperation2PSignatureTests {
	
	@Test
	public void callReturnOperation1P_Builder(){
		List<String> list = new ArrayList<>();
		DelegateBuilder<List<String>> builder = DelegateBuilder.as(new DelegateType<List<String>>(){});
		Object ret = builder.<Boolean,String>upon(List::add).convert(Boolean.class,String.class).call(list::add);
		Assertions.assertThat(ret).isEqualTo(builder);
	}
}
