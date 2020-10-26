package com.zxl.daily.base.jvm.shudaizi.classloader1;

/*
 * 实例初始化不一定要在类初始化结束之后才开始初始化。
 * 实际上是把实例初始化嵌入到了静态初始化流程中，并且在上面的程序中，嵌入到了静态初始化的起始位置。
 */

public class MyTest5 {
	
	public static void main(String[] args) {
		StaticTest.staticFunction();
	}

}

class StaticTest{
	
	static StaticTest st = new StaticTest();
	
	static {	//静态代码块
		System.out.println("1");
	}
	
	{	//实例代码块
		System.out.println("2");
	}
	
	StaticTest(){	//实例构造器
		System.out.println("3");
		System.out.println("a="+a+",b="+b);
	}
	
	public static void staticFunction() {
		System.out.println("4");
	}
	
	int a = 110;
	static int b = 112;
	
	
}
