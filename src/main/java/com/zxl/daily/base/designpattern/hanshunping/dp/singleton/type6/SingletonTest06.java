package com.zxl.daily.base.designpattern.hanshunping.dp.singleton.type6;

import com.zxl.test.designpattern.hanshunping.dp.singleton.type6.Singleton;

public class SingletonTest06 {

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
 * 双重检查
 * 1.私有构造方法
 * 2.类的内部创建对象
 * 3.向外暴露一个公共静态方法
 *
 * 虽然达到了按需初始化目的，但却带来了线程不安全的问题
 * 可以通过synchronized解决，但也带来了效率下降
 *
 */
class Singleton {
	
	private Singleton() {}
	
	private static Singleton instance;
	
	public static Singleton getInstance() {
		if(instance == null) {
			synchronized(Singleton.class) {
				if(instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
}
