package com.zxl.daily.base.jvm.shudaizi.gc;

import java.util.Vector;

public class MyTest2 {

	private static Vector v = new Vector();
	
	public static void main(String[] args) {
		MyTest2 test = new MyTest2();
		test.test(v);
	}
	
	public void test(Vector v) {
		for (int i = 1; i < 100; i++) {
			Object o = new Object();
			v.add(o);
			o = null;
		}
	}
}
