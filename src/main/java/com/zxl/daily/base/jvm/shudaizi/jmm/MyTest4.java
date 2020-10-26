package com.zxl.daily.base.jvm.shudaizi.jmm;

public class MyTest4 {

	public static void main(String[] args) {
		String str1 = new StringBuilder("计算机").append("软件").toString();
		System.out.println(str1.intern() == str1); //true
		
		String str2 = new StringBuilder("java").toString();
		System.out.println(str2.intern() == str2); //false
	}
}
