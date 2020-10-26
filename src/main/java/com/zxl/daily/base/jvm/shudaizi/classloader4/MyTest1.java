package com.zxl.daily.base.jvm.shudaizi.classloader4;


import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MyTest1 {
	
	public static void main(String[] args) throws ScriptException {
		System.out.println("aa");
		int a = -1;
		
//		a = a * 1 || 10;
		ScriptEngineManager script = new ScriptEngineManager();
		ScriptEngine engine = script.getEngineByName("javascript");
		Object o = engine.eval("var a = -1; a = a * 1 || 10;");
		System.out.println(a);
		System.out.println(o);
		
//		ServiceLoader
		//线程上下文类加载器
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		System.out.println(Thread.currentThread().getContextClassLoader());
	}

}
