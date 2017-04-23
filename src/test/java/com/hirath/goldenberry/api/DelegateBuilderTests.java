package com.hirath.goldenberry.api;


import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class DelegateBuilderTests {

	@Test
	public void as_List_DelegateBuilder(){
		Object ret = DelegateBuilder.as(List.class);
		Assertions.assertThat(ret).isInstanceOf(DelegateBuilder.class);
	}
	
	@Test
	public void as_NullClass_ThrowInterfaceRequiredException(){
		Throwable ex = Assertions.catchThrowable(() -> DelegateBuilder.as((Class<?>)null));
		Assertions.assertThat(ex).isInstanceOf(InterfaceRequiredException.class);
	}
	
	@Test
	public void as_NullDelegateType_ThrowInterfaceRequiredException(){
		Throwable ex = Assertions.catchThrowable(() -> DelegateBuilder.as((DelegateType<?>)null));
		Assertions.assertThat(ex).isInstanceOf(InterfaceRequiredException.class);
	}
	
	@Test
	public void as_NonInterface_ThrowInterfaceRequiredException(){
		Throwable ex = Assertions.catchThrowable(() -> DelegateBuilder.as(String.class));
		Assertions.assertThat(ex).isInstanceOf(InterfaceRequiredException.class);
	}
	
	@Test
	public void as_DelegateGenericType_DelegateBuilder(){
		DelegateBuilder<List<String>> build = DelegateBuilder.as(new DelegateType<List<String>>() {});
		Assertions.assertThat(build).isInstanceOf(DelegateBuilder.class);
	}
	
	@Test
	public void as_DelegateNotGenericType_DelegateBuilder(){
		Object build = DelegateBuilder.as(new DelegateType<Runnable>() {});
		Assertions.assertThat(build).isInstanceOf(DelegateBuilder.class);
	}
	
	@Test
	public void upon_VoidOperation1P_DelegateBuider(){
		DelegateBuilder<Runnable> builder = DelegateBuilder.as(Runnable.class);
		Object ret =  builder.upon(Runnable::run);
		Assertions.assertThat(ret).isInstanceOf(UponOperation.class);
	}
	
	@Test
	public void upon_GenericReturnOperation2P_DelegateBuider(){
		DelegateBuilder<List<String>> builder = DelegateBuilder.as(new DelegateType<List<String>>() {});
		Object ret =  builder.<Boolean,String>upon(List<String>::add);
		Assertions.assertThat(ret).isInstanceOf(UponReturnOperation2P.class);
	}
	
	@Test
	public void upon_Operation_SaveOperation(){
		DelegateBuilder<List<String>> builder = DelegateBuilder.as(new DelegateType<List<String>>() {});
		Object ret =  builder.<Boolean,String>upon(List<String>::add);
		Assertions.assertThat(ret).isInstanceOf(UponReturnOperation2P.class);
	}
}
