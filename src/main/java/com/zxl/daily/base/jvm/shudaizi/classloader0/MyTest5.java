package com.zxl.daily.base.jvm.shudaizi.classloader0;

import java.io.InputStream;

public class MyTest5 {
	
	public static void main(String[] args) throws Exception, IllegalAccessException, ClassNotFoundException {
		//一个简单的类加载器，逆向双亲委派机制
		//可以加载与自己在同一路径下的Class文件
		ClassLoader myClassLoader1 = new ClassLoader() {
			
			@Override
			public Class<?> loadClass(String name) throws ClassNotFoundException {
				try {
					String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
					InputStream is = getClass().getResourceAsStream(fileName);
					if(is == null) {
						return super.loadClass(name);//递归调用父类加载器
					}
					byte[] b = new byte[is.available()];
					is.read(b);
					return defineClass(fileName, b, 0, b.length);
				}catch(Exception e) {
					throw new ClassNotFoundException(name);
				}
			}
			
		};
		
		Object obj = myClassLoader1.loadClass("com.zxl.test.jvm.classloader0.MyTest5").newInstance();
		System.out.println(obj.getClass());
		System.out.println(obj instanceof com.zxl.test.jvm.shudaizi.classloader0.MyTest5);
		
	}

}
