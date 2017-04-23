package com.hirath.goldenberry.api;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import com.hirath.goldenberry.api.function.Operation;
import com.hirath.goldenberry.api.function.ReturnOperation2P;

public class UponReturnOperation2PTests {
	@Test
	public void convert_Signature_Signature(){
		DelegateBuilder<List<String>> builder = DelegateBuilder.as(new DelegateType<List<String>>(){});
		UponReturnOperation2P<Boolean,List<String>,String> uponOperation = builder
				                                                .<Boolean,String>upon(List::add);
		Assertions.assertThat(uponOperation.convert(Integer.class,String.class)).isInstanceOf(ReturnOperation2PSignature.class);
	}
	
	@Test
	public void uponReturnOperation2P_HasBuilder(){
		DelegateBuilder<List<String>> builder = DelegateBuilder.as(new DelegateType<List<String>>(){});
		UponReturnOperation2P<Boolean,List<String>,String> uponOperation = builder
				                                                .<Boolean,String>upon(List::add);
		Assertions.assertThat(uponOperation.builder).isEqualTo(builder);
	}
	
	@Test
	public void call_ReturnOperation1P_DelegateBuilder(){
		List<String> list = new ArrayList<>();
		DelegateBuilder<List<String>> builder = DelegateBuilder.as(new DelegateType<List<String>>(){});
		UponReturnOperation2P<Boolean,List<String>,String> uponOperation = builder
				                                                .<Boolean,String>upon(List::add);
		Assertions.assertThat(uponOperation.call(list::add)).isEqualTo(builder);
	}
	
	@Test
	public void resolve_Map(){
		List<String> list = new ArrayList<>();
		ReturnOperation2P<Boolean, List<String>, String> operation = List::add;
		UponReturnOperation2P<Boolean,List<String>,String> uponOperation = DelegateBuilder.as(new DelegateType<List<String>>(){})
				                                                                          .<Boolean,String>upon(operation);
		uponOperation.call(list::add);
		Assertions.assertThat(uponOperation.resolve()).containsKey(operation);
	}
	
	@Test
	public void resolve_MapWithOperationAndConvertingOperation(){
		List<String> list = new ArrayList<>();
		ReturnOperation2P<Boolean, List<String>, String> operation = List::add;
		UponReturnOperation2P<Boolean,List<String>,String> uponOperation = DelegateBuilder.as(new DelegateType<List<String>>(){})
				                                                                          .<Boolean,String>upon(operation);
		uponOperation.call(list::add);
		Assertions.assertThat(uponOperation.resolve().get(operation)).isInstanceOf(Operation.class);
	}
}
