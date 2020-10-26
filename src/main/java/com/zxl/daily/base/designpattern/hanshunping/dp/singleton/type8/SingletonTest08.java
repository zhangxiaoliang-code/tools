package com.zxl.daily.base.designpattern.hanshunping.dp.singleton.type8;

import com.zxl.test.designpattern.hanshunping.dp.singleton.type8.Singleton;

public class SingletonTest08 {

	public static void main(String[] args) {
		//测试
		Singleton instance1 = Singleton.INSTANCE;
		Singleton instance2 = Singleton.INSTANCE;
		System.out.println(instance1 == instance2);
		System.out.println(instance1.hashCode());
		System.out.println(instance2.hashCode());
		
		instance1.method();
	}
}

/**
 * 枚举
 * 不仅可以解决线程同步问题，还可以防止反序列化
 */
enum Singleton{
	INSTANCE;
	
	public void method() {
		System.out.println("method");
	}
}
