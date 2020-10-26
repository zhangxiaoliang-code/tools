package com.zxl.daily.base.jvm.shudaizi.classloader0;

public class MyTest6 {

	public static void main(String[] args) {
		try {
			WrongClassLoader loader = new WrongClassLoader();
			Class classLoaded = loader.loadClass("com.zxl.test.classloader0.MyTest1");  
            System.out.println(classLoaded.getName());  
            System.out.println(classLoaded.getClassLoader());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}

//用户自定义类加载器WrongClassLoader.java（覆写loadClass逻辑）
class WrongClassLoader extends ClassLoader{
	
	public Class<?> loadClass(String name) throws ClassNotFoundException{
		return this.findClass(name);
	}
	
	public Class<?> findClass(String name) throws ClassNotFoundException {
		// 假设此处只是到工程以外的特定目录D:\library下去加载类  
        // 具体实现代码省略
		
		return null;
	}
	
}
