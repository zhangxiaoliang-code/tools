package com.zxl.daily.base.jvm.shudaizi.classloader2;

public class MyTest5 {
	public static void main(String[] args) {
		new InstanceVariableInitializer(8);
	}

}

class InstanceVariableInitializer{
	
	private int i = 1;
	
	private int j = i + 1;
	
	public InstanceVariableInitializer(int var) {
		System.out.println(i);//1
		System.out.println(j);//5
		this.i = var;
		System.out.println(i);//8
		System.out.println(j);//5
	}
	
	{	//实例代码块
		j += 3;
	}
	
}

