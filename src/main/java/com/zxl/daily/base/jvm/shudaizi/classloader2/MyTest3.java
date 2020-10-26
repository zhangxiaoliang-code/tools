package com.zxl.daily.base.jvm.shudaizi.classloader2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;

public class MyTest3 {

	public static void main(String[] args) throws Exception {
		Constructor<Student3> constructor = Student3.class.getConstructor(Integer.class);
		Student3 stu3 = constructor.newInstance(123);
		
		//写对象
		ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("student3.bin"));
		output.writeObject(stu3);
		output.close();
		
		//读对象
		ObjectInputStream input = new ObjectInputStream(new FileInputStream("student3.bin"));
		Student3 stu31 = (Student3) input.readObject();
		System.out.println(stu31);
		input.close();
	}
}

class Student3 implements Cloneable,Serializable{
	private int id;
	
	public Student3(Integer id) {
		this.id = id;
	}
}
