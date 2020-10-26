package com.zxl.daily.base.jvm.shudaizi.classloader1;

public class TestClassLoader {

	public static void main(String[] args) {
		System.out.println(MyChild.str2);
		MyChild mc = new MyChild();
		System.out.println(mc.str3);
		System.out.println("启动类加载器："+System.getProperty("sun.boot.class.path"));
		System.out.println("扩展类加载器："+System.getProperty("java.ext.dirs"));
		System.out.println("系统类加载器："+System.getProperty("java.class.path"));
	}
	
}

class MyParent{
	public static String str1 = "hello world!";
	
	static {
		System.out.println("my parent static");
	}
}

class MyChild extends MyParent{
	public static String str2 = "welcome!";
	
	public String str3 = "hi";
	
	static {
		System.out.println("my child static");
	}
	
	public static void ss() {
		System.out.println(2222);
	}
}
