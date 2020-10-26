package com.zxl.daily.base.jvm.shudaizi.classloader1;

/**
 * 1.通过子类引用父类的静态字段，不会导致子类初始化
 * 2.通过数组定义来引用类，不会触发此类的初始化
 *
 */

public class MyTest {

	public static void main(String[] args) {
		System.out.println(SubClass.value);
//		SClass[] sca = new SClass[10];
	}
}

class SSClass{
	public static String value = "SSClass static variable";
	
	static {
		System.out.println("SSClass static block");
	}
}

class SClass extends SSClass {
//	public static String value = "SClass static variable";
	
	static {
		System.out.println("SClass static block");
	}
	
	public SClass() {
		System.out.println("SClass constructor");
	}
}

class SubClass extends SClass {
//	public static String value = "SubClass static variable";
	
	static {
		System.out.println("SubClass static block");
	}
	
	public SubClass() {
		System.out.println("SubClass constructor");
	}
}
