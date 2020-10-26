package com.zxl.daily.base.designpattern.hanshunping.principle.liskov;

/**
 * 里式替换原则1
 *
 */
public class LisKov {

	public static void main(String[] args) {
		A a = new A();
		System.out.println("11 - 3 = " + a.func1(11, 3));
		System.out.println("1 - 8 = " + a.func1(1, 8));
		
		System.out.println("---------------------");
		B b = new B();
		System.out.println("11 - 3 = " + b.func1(11, 3));
		System.out.println("1 - 8 = " + b.func1(1, 8));
		System.out.println("11 + 3 + 9 = " + b.func2(11, 3));
	}

}

class A {
	public int func1(int num1, int num2) {
		return num1 - num2;
	}
}

/**
 * 增加一个新功能：完成两个数相加，然后和9求和
 */
class B extends A {
	/**
	 * 这里重写 A 的方法，可能是无意识
	 */
	public int func1(int a, int b) {
		return a + b;
	}

	public int func2(int a, int b) {
		return func1(a, b) + 9;
	}
}
