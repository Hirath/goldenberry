package com.hirath.goldenberry.core.operation;

import java.awt.List;
import java.lang.reflect.Method;

import org.junit.Test;

import com.hirath.goldenberry.core.Signature;
import com.hirath.goldenberry.core.operation.SignatureOperationBuilder;

public class SignatureOperationBuilderTests {

	SignatureOperationBuilder builder = new SignatureOperationBuilder();
	@Test
	public void testFrom() throws Exception {
		Method add = List.class.getMethod("add", Object.class);
		Signature signature = new Signature();
		builder.from(add, signature)
	}

}
