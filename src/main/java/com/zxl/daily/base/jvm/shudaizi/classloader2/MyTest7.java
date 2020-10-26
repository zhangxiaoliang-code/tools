package com.zxl.daily.base.jvm.shudaizi.classloader2;

public class MyTest7 {

	public static void main(String[] args) {
		InstanceInitializer7 ii = new InstanceInitializer7();
		System.out.println(ii.j);
	}
}

class InstanceInitializer7{
	
	public int j  = getI();
	
	private int i = 1;
	
	public InstanceInitializer7() {
		i = 2;
	}
	
	private int getI() {
		return i;
	}
	
}
