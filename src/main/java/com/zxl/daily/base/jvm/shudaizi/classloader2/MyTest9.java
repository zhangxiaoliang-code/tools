package com.zxl.daily.base.jvm.shudaizi.classloader2;

public class MyTest9 {

}

class ConstructorExample9{
	private int i;
	
	ConstructorExample9(){
		this(1);
	}
	
	ConstructorExample9(int i){
		this.i = i;
	}
}
