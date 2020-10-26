package com.zxl.daily.base.jvm.shudaizi.classloader0;

/*
 * 1.类加载器本身就是一个对象，它的作用是负责加载类。ClassLoader是一个抽象类。当给定一个类的二进制名字，
 * 类加载器应该尝试定位或生成构成类定义的数据。一个典型策略是将这个二进制名字转换成文件名字然后去文件系统读取
 * 这个名字所包含的字节码文件。
 * 2.每一个class对象都会包含定义着ClassLoader定义的引用。
 * 3.对于数组类的对象并不是由类加载器来创建的，而是根据java虚拟机运行时根据需要自动创建的。Class.getClassLoader()
 * 返回的数组类的类加载器与其elementtype的类加载器相同，如果元素类型是基本类型，则数组类是没有类加载器。
 * 4.应用程序实现ClassLoader的子类，以扩展Java虚拟机动态加载类的方式。
 * 5.安全管理通常可以使用类加载器来指示安全区域。
 * 6.ClassLoader类使用了委派模型来搜索类和资源。ClassLoader每个实例都会有一个父类加载器，当请求查找类和资源时，
 * ClassLoader实例会在尝试查找类和资源本身之前将对类或资源的搜索委托给其父类加载器。虚拟机内置的加载器，称为“bootstrap”
 * 类加载器，本身不具有父类加载器，但可以作为ClassLoader实例的父级。
 * 7.支持并发加载类的类加载器称为并行类加载器，需要通过调用ClassLoader.regisAsParallelCapable方法在类初始化时注册自己。
 * 请注意，ClassLoader类默认注册为parallelcapable。但是，如果他们具有并行能力，它的子类仍然需要注册自己。
 * 8.在委托模型不是严格的层次环境中，类加载器需要具有并行能力，否则类加载器会导致死锁，因为加载器锁定是为了加载类加载过程（请参阅loadClass方法）。
 * 9.通常，Java虚拟机以与平台相关的方式从本地文件系统加载类，例如，在UNIX系统上，虚拟机从CLASSPATH环境变量定义的目录中加载类。
 * 10.但是，某些类可能不是源自文件，他们可能来自其他来源，例如网络，或者他们可以通过应用来构建。方法defineClass将字节数组转换为类Class的实例。
 * 可以使用Class.newInstance创建此新定义的类的实例。
 * 11.由加载器创建对象的方法和构造函数可以引用其他类。为了确定所引用的类，java虚拟机调用最初创建该类的类加载器的loadClass方法
 */
public class MyTest4 {
	public static void main(String[] args) {
		String[] strings = new String[2];
		//启动类加载器
		System.out.println(strings.getClass().getClassLoader());
		System.out.println(String.class.getClassLoader());
		
		System.out.println("---------------");
		
		MyTest4[] myTest4 = new MyTest4[2];
		System.out.println(myTest4.getClass().getClassLoader());
		
		System.out.println("---------------");
		
		int[] ii = new int[2];
		//如果元素类型是基本类型的话，那么这种数组类是没有加载器
		System.out.println(ii.getClass().getClassLoader());
		
	}

}
