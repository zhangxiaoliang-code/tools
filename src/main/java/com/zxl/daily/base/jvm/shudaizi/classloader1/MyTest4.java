package com.zxl.daily.base.jvm.shudaizi.classloader1;

import com.zxl.test.jvm.shudaizi.classloader1.DealLoopTest.DeadLoopClass;

public class MyTest4 {
	
	public static void main(String[] args) {
		Runnable script = new Runnable() {	//匿名内部类
			@Override
			public void run() {
				System.out.println(Thread.currentThread()+" start");				
				DealLoopTest.DeadLoopClass dlt = new DealLoopTest.DeadLoopClass();
				System.out.println(Thread.currentThread()+" run over");
			}
		};
		
		Thread thread1 = new Thread(script);
		Thread thread2 = new Thread(script);
		thread1.start();
		thread2.start();
	}

}

class DealLoopTest{
	static {
		System.out.println("DealLoopTest static block!");
	}
	
	static class DeadLoopClass{
		static {
			if(true) {
				System.out.println(Thread.currentThread()+"init DeadLoopClass");
				while(true) {//模拟耗时长的操作
				}
			}
		}
	}
}
