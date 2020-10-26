package com.zxl.daily.base.jvm.shudaizi.classloader0;

public class MyTest2 {

	public static void main(String[] args) {
		try {
			//查看当前系统类路径中包含的路径条目
			System.out.println(System.getProperty("java.class.path"));
			//调用加载当前类的类加载器（这里即为系统类加载器）加载TestBean
			Class typeLoaded = Class.forName("com.zxl.test.classloader0.TestBean");
			//查看被加载的TestBean类型是那个类加载器加载的
			System.out.println(typeLoaded.getClassLoader());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}

class TestBean{
	public TestBean() {}
}
