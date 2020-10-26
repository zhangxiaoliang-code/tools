package com.zxl.daily.base.jvm.shudaizi.jmm;

public class MyTest1 {
	
	public static void main(String[] args) {
		String s = "aa nn bb";
		String standard = s.intern();
		System.out.println(s == standard);
		
		String b = "BB";
		System.out.println(b == b.intern());
	}

}
