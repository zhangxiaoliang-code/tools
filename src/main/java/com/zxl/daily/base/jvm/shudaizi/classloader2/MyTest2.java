package com.zxl.daily.base.jvm.shudaizi.classloader2;

import java.lang.reflect.Constructor;

public class MyTest2 {

	public static void main(String[] args) throws Exception {
		Constructor<Student2> constructor = Student2.class.getConstructor(Integer.class);
		Student2 stu21 = constructor.newInstance(123);
		Student2 stu22 = (Student2) stu21.clone();
	}
}

class Student2 implements Cloneable{
	private int id;
	
	public Student2(Integer id) {
		this.id = id;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}