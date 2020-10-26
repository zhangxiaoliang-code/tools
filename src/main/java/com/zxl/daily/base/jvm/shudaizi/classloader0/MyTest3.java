package com.zxl.daily.base.jvm.shudaizi.classloader0;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 命名空间
 * 1.每个类加载器都有自己的命名空间，命名空间有该加载器及所有父加载器所加载类组成
 * 2.在同一个命名空间中，不会出现类的完整名字（包括类的包名）相同的两个类
 * 3.在不同的命名空间中，有可能会出现类的完整名字（包括类的包名）相同的两个类
 */

public class MyTest3 extends ClassLoader{

	private String classLoaderName;
	
	private String path;
	
	private final String fileExtension=".class";
	

	public MyTest3(String classLoaderName) {
		super();	//将系统类加载器当做该类加载器的父加载器
		this.classLoaderName = classLoaderName;
	}
	
	public MyTest3(ClassLoader parent, String classLoaderName) {
		super(parent);	//显示指定该类加载器的父类加载器
		this.classLoaderName = classLoaderName;
	}
	
	public void setPath(String path) {
		this.path = path;
	}

	@Override
	protected Class<?> findClass(String className) throws ClassNotFoundException {
		System.out.println("findClass: "+className);
		
		byte[] data = this.loadClassData(className);
		return this.defineClass(className, data, 0, data.length);
	}
	
	private byte[] loadClassData(String className) {
		byte[] data = null;
		InputStream is = null;
		ByteArrayOutputStream baos = null;
		
		className = className.replace(".", "\\");
		try {
			is = new FileInputStream(new File(this.path + className + this.fileExtension));
			baos = new ByteArrayOutputStream();
			int ch = 0;
			while(-1 != (ch = is.read())) {
				baos.write(ch);
			}
			data = baos.toByteArray();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				is.close();
				baos.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return data;
	}
	
	public static void main(String[] args) throws Exception {
		MyTest3 loader1 = new MyTest3("loader1");
		
		loader1.setPath("D:\\Users\\");
		
		Class<?> clazz = loader1.loadClass("com.zxl.test.classloader0.MyTest1");
		System.out.println("clazz: "+clazz.hashCode());
		Object obj = clazz.newInstance();
		System.out.println(obj);
		
		System.out.println("-----------------");
		
		MyTest3 loader2 = new MyTest3("loader2");
		loader2.setPath("D:\\Users\\");
		Class<?> clazz2 = loader2.loadClass("com.zxl.test.classloader0.MyTest1");
		System.out.println("clazz2"+clazz2.hashCode());
		Object obj2 = clazz2.newInstance();
		System.out.println(obj2);
		
		
		
		
		
		
		
		
		
		
		
//		System.out.println(System.nanoTime());
//		System.out.println(transferLongToDate("yyyy-MM-dd HH:mm:ss",652276968955300));
	}
	
	/*public static String transferLongToDate(String dateFormat, long millSec) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Date date = new Date(millSec);
		return sdf.format(date);
	}*/
}
