package com.zxl.daily.base.jvm.shudaizi.classloader2;

/*
 * 由于Bar重载了Foo的getValue方法，所以根据java的多态特性可以知道，其调用的getValue方法是被Bar重载的那个getValue方法。
 * 但由于这是bar的构造函数还没被执行，因此此时j的值还是默认值0，所有输出就是0.
 * 
 */
public class MyTest11 {

	public static void main(String[] args) {
		Bar b = new Bar();
		System.out.println(b.getValue());
	}
}

class Foo{
	int i = 1;
	
	Foo(){
		System.out.println(i);
		int x = getValue();
		System.out.println(x);
	}
	
	{
		i = 2;
	}
	
	protected int getValue() {
		return i;
	}
}

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
