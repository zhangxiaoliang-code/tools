package com.zxl.daily.base.jvm.shudaizi.classloader1;

public class MyTest6 {
	public static void main(String[] args) {
		StaticTest6.staticFunction();
	}
}

class StaticTest6{
	static StaticTest6 st = new StaticTest6();
	
	static {
		System.out.println("1");
	}
	
	{
		System.out.println("2");
	}
	
	StaticTest6(){
		System.out.println("3");
		System.out.println("a = " + a + ",b = " + b);
	}
	
	public static void staticFunction() {
		System.out.println("4");
	}
	
	int a = 110;
	static int b = 112;
	static StaticTest6 st1 = new StaticTest6();
}
