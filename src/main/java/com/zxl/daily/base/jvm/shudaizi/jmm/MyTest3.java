package com.zxl.daily.base.jvm.shudaizi.jmm;

public class MyTest3 {

	public static void main(String[] args) {
		MyTest3.method();
	}
	
	public static void method() {
		method();
	}
}
