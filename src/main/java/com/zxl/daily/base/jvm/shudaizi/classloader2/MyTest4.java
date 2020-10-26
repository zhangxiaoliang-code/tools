package com.zxl.daily.base.jvm.shudaizi.classloader2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/*
 * 从java虚拟机层面看，除了使用new关键字创建对象的方式外，其他方式全部都是通过invokevirtual指令直接创建对象的。	
 */
public class MyTest4 {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, CloneNotSupportedException, FileNotFoundException, IOException {
		System.out.println("使用new关键字创建对象：");
		Student4 stu4 = new Student4(123);
		System.out.println(stu4);
		System.out.println("\n-----------------\n");
		
		System.out.println("使用Class的newInstance方法创建对象：");
		//对应类必须 具有无参构造方法，且只有这一种创建方式
		Student4 stu41 = Student4.class.newInstance();
		System.out.println(stu41);
		/*Class<?> clazz  = Class.forName("com.zxl.test.classloader2.Student4");
		ClassLoader stu41 = (ClassLoader) clazz.getClassLoader();
		Constructor constructor = clazz.getConstructor(Integer.class);
		System.out.println(stu41);
		System.out.println(constructor.newInstance(111));*/
		System.out.println("\n-----------------\n");
		
		System.out.println("使用Constructor的newInstance方法创建对象：");
		//调用有参构造函数
		Constructor<Student4> constructor = Student4.class.getConstructor(Integer.class);
		Student4 stu42 = constructor.newInstance(123);
		System.out.println(stu42);
		
		System.out.println("使用Clone方法创建对象：");
		Student4 stu43 = (Student4) stu42.clone();
		System.out.println(stu43);
		System.out.println("\n-----------------\n");
		
		System.out.println("使用（反）序列化机制创建对象！");
		//写对象
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("student4.bin"));
		output.writeObject(stu43);
		output.close();
		
		//读对象
		ObjectInputStream input = new ObjectInputStream(new FileInputStream("student4.bin"));
		Student4 stu44 = (Student4) input.readObject();
		System.out.println(stu44);
		System.out.println("\n-----------------\n");
		System.out.println("\n-----------------\n");
	}
}


class Student4 implements Cloneable, Serializable{
	private int id;
	
	public Student4(Integer id) {
		this.id = id;
	}
	

	public Student4() {
		super();
	}


	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	@Override
	public String toString() {
		return "Student4 [id=" + id + "]";
	}
	
	
	
}