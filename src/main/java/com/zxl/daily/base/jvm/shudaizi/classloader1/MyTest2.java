package com.zxl.daily.base.jvm.shudaizi.classloader1;

/*
 * 3.常量再编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化。
 */

public class MyTest2 {

	public static void main(String[] args) {
		System.out.println(ConstClass.CONSTANT);
	}
}

class ConstClass{
	static {
		System.out.println("ConstClass static block!");
	}
	
	public static final String CONSTANT= "hello world!";
}
