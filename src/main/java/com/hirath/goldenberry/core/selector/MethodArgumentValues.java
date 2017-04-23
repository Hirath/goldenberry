package com.hirath.goldenberry.core.selector;

import java.util.ArrayList;
import java.util.List;

import com.hirath.goldenberry.core.InstanceExampleFactory;

class MethodArgumentValues {
	List<Object> argumentValues = new ArrayList<>();
	int offset = 0;

	MethodArgumentValues(Object head) {
		argumentValues.add(head);
		argumentValues.addAll(InstanceExampleFactory.randomValues());
	}
	
	void updateFirst(String sourceTypeName, String targetTypeName) {
		String valueTypeName="";
		while( offset < argumentValues.size() && ! sourceTypeName.equals(valueTypeName)){
			Object value = argumentValues.get(offset);
			valueTypeName = value.getClass().getName();
			offset++;
		}
		argumentValues.set(offset-1, InstanceExampleFactory.anyValueOf(targetTypeName));
	}

	public Object[] toArray() {
		return argumentValues.toArray();
	}
}
