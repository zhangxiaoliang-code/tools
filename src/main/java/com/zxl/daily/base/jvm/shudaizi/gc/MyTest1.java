package com.zxl.daily.base.jvm.shudaizi.gc;

public class MyTest1 {

	public static void main(String[] args) {
		System.out.println(ClassLoader.class.getClassLoader());
		System.out.println(ClassLoader.getSystemClassLoader());
		
		System.out.println(System.getProperty("java.system.class.loader"));
//		Vector<E>
	}
}

class ReferenceCountingGC{
	
	public Object instance = null;
	
	public static void testGC() {
		
		ReferenceCountingGC objA = new ReferenceCountingGC();
		ReferenceCountingGC objB = new ReferenceCountingGC();
		
		//对象之间相互循环引用，对象objA和objB之间的引用计数永远不可能为0；
		objA.instance = objB;
		objB.instance = objA;
		
		objA = null;
		objB = null;
		
		System.gc();
		
	}
	
	
	
}
