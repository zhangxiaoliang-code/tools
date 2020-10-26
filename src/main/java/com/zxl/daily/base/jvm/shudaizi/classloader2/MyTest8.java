package com.zxl.daily.base.jvm.shudaizi.classloader2;

/*
 * 在创建一个对象的过程中，成员变量在上面时候赋值的
 * (父子父父子子)父类的类构造器<clinit>()->子类的类构造器<clinit>()->父类的成员变量和实例代码块->父类的构造函数->子类的成员变量和实例代码块->子类的构造函数
 */
public class MyTest8 {

	public static void main(String[] args) {
//		System.out.println(ConstructorExample8.class.getSuperclass());
		ConstructorExample8 ce = new ConstructorExample8();
//		ConstructorExample8.a();
	}
}

class ConstructorExample8{
	
	static int i = 3;
	
	int j = 4;
	
	static {
		System.out.println("ConstructorExample static block");
		System.out.println(i);
	}
	
	{
		System.out.println(j);
		System.out.println("ConstructorExample example block");
	}
	
	public ConstructorExample8() {
		System.out.println("constructor8");
	}
	
	public static void a() {
		System.out.println("aaaaaaaa");
	}
}
