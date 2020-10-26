package com.zxl.daily.base.jvm.shudaizi.classloader2;

import java.lang.reflect.Constructor;

/*
 * 使用newInstance方法的这两种方式创建对象使用的就是java的反射机制，事实上Class的newInstance方法内部调用的也是Constructor的newInstance方法
 */
public class MyTest1 {

	public static void main(String[] args) throws Exception {
		Constructor<Student1> constructor = Student1.class.getConstructor(Integer.class);
		
		Student1 stu = constructor.newInstance(123);
	}
}

class Student1{
	private int id;
	
	public Student1(Integer id) {
		this.id = id;
	}
}
