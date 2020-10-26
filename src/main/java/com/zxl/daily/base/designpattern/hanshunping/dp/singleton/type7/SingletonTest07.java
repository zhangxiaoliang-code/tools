package com.zxl.daily.base.designpattern.hanshunping.dp.singleton.type7;

import com.zxl.test.designpattern.hanshunping.dp.singleton.type7.Singleton;

public class SingletonTest07 {

	public static void main(String[] args) {
		//测试
		Singleton instance1 = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
		System.out.println(instance1 == instance2);
		System.out.println(instance1.hashCode());
		System.out.println(instance2.hashCode());
	}
}

/**
 * 静态内部类
 * JVM保证单例
 * 加载外部类时不会加载内部类，这样可以实现懒汉
 *
 */
class Singleton{
	private Singleton() {}
	
	private static class SingletonInstance{
		private static final Singleton INSTANCE = new Singleton();
	}
	
	public static Singleton getInstance() {
		return SingletonInstance.INSTANCE;
	}
}
