package com.zxl.daily.base.jvm.shudaizi.classloader1;

public class MyTest7 {

	public static void main(String[] args) {
		Bar bar = new Bar();
		System.out.println("bar j = "+bar.getValue());
	}
}

class Foo{
	int i = 1;
	Foo(){	//构造函数
		System.out.println("foo i = "+i);
		int x = getValue();
		System.out.println("foo x = "+x);
	}
	
	{	//构造代码块
		i = 2;
	}
	
	protected int getValue() {
		return i;
	}
}

//子类
class Bar extends Foo{
	int j = 1;
	
	Bar(){
		j = 2;
	}
	
	{
		j = 3;
	}
	
	@Override
	protected int getValue() {
		return j;
	}
}
