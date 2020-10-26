package com.zxl.daily.base.jvm.shudaizi.jmm;

import java.util.ArrayList;
import java.util.List;

public class MyTest2 {

	public static void main(String[] args) {
		List list = new ArrayList(); //持有大对象的引用，放置垃圾回收
		while(true) {
			int[] temp = new int[1000000]; //不断创建 “大对象”
			list.add(temp);
		}
	}

}
