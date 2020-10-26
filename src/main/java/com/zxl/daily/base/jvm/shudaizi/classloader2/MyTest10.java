package com.zxl.daily.base.jvm.shudaizi.classloader2;

/*
 * Java通过对构造函数做出这种限制以保证一个类的实例能够在被使用之前正确地初始化
 */
public class MyTest10 {

}

class ConstructorExample10{
	private int i;
	
	ConstructorExample10(){
		super();
//		this(1);
	}
	
	ConstructorExample10(int i){
		this.i = i;
	}
}
