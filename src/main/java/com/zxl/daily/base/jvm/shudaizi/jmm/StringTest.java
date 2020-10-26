package com.zxl.daily.base.jvm.shudaizi.jmm;

public class StringTest {

	/**
	 * 1.直接使用双引号创建字符串
	 * 	判断这个常量是否存在于常量池
	 * 		如果存在
	 * 			判断这个常量存在的是引用还是常量
	 * 				如果是引用，返回引用地址并指向堆空间对象
	 * 				如果是常量，则直接返回常量池常量
	 * 		如果不存在
	 * 			在常量池中创建该常量，并返回此常量
	 */
	public static void test1() {
		String a1 = "AA";	//在常量池中创建此常量
		String a2 = "AA";	//直接返回已存在的常量AA
		System.out.println(a1 == a2);	//false
		
		String a3 = new String("AA");	//在堆空间创建对象AA
		a3.intern();	//在常量池上创建对象AA的引用
		String a4 = "AA";	//在常量池上存在引用AA，直接返回该引用指堆空间的对象，即a3
		System.out.println(a3 == a4);	//false
		System.out.println(a3.equals(a4));	//true
	}
	/**
	 * 1.使用双引号创建字符串
	 * 判断这个常量是否在常量池
	 * 
	 * if(在){
	 * 		存在的是常量还是引用
	 * 		if（常量）{
	 * 			return 常量；
	 * 		}else{
	 * 			return 引用地址（指向堆空间对象的地址）；
	 * 		}
	 * }else{
	 * 		不存在
	 * 		return 在常量池中创建常量并返回常量；
	 * }
	 * 
	 * 2.new String创建字符串
	 * 
	 * 首先在堆上创建对象（无论堆上是否存在相同字面量的对象）
	 * 然后判断常量池中是否有字面量的对象
	 * if（不存在）{
	 * 		在常量池行创建常量
	 * }else{
	 * 		存在，不做任何操作
	 * 
	 * }
	 * 
	 * 3.双引号相加
	 * 	判断这两个常量、相加后的常量在常量池上是否存在
	 * 	if（不存在）{
	 * 		则在常量池中创建相应的常量
	 * 	}else{
	 * 		存在
	 * 		判断这个常量池存在的引用还是常量
	 * 		if（引用）{
	 * 			return 引用地址（指向的堆空间的对象）；
	 * 		}else{
	 * 			常量
	 * 			return 常量池中的常量；
	 * 		}
	 * 	}
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
	
	
	/**
	 * 2.new String创建字符串
	 * 	首先在堆上创建对象（无论堆上是否存在相同字面量对象），
	 * 	然后判断常量池上是否存在字符串的字面量，
	 * 		如果不存在
	 * 			在常量池上创建常量
	 * 		如果存在
	 * 			不做任何操作
	 */
	public static void test2() {
		String a1 = new String("AA");
		String a2 = new String("AA");
		System.out.println(a1 == a2);	//false
		
		//如果常量池上不存在常量BB,也不存在引用BB，则创建常量BB
		String b = new String("BB");
		String b1 = "BB";
		System.out.println(b == b.intern());	//false
		System.out.println(b == b1);	//false
	}
	
	/**
	 * 3.双引号相加
	 * 	判断两个常量、相加后的常量在常量池是否存在
	 * 		如果不存在
	 * 			则在常量池上创建相应的常量
	 * 		如果存在
	 * 			判断这个常量存在的是引用还是常量
	 * 				如果是引用，则返回引用地址指向的堆空间对象
	 * 				如果是常量，则直接返回常量池常量
	 */
	
	public static void test3() {
		String a1 = "AA" + "BB";	//在常量池上创建AA、BB和AABB，并返回AABB
		
		//常量池上存在AABB
		String a2 = "AABB";
		String a3 = "AA" + "BB";
		System.out.println(a2 == a3);//true
		
		//常量池上存在引用AABB
		String a4 = new String("AA") + new String("BB");//在堆上创建AA、BB和AABB，在常量池上创建AA和BB
		a4.intern();
		String a5 = "AA" + "BB";
		System.out.println(a4 == a5);//true
	}
	
	/**
	 * 4.两个new String相加
	 * 	首先会创建这两个对象以及相加后的对象
	 * 	然后判断常量池中是否存在这两个对象的字面量常量
	 * 		如果存在
	 * 			不做任何操作
	 * 		如果不存在
	 * 			则在常量池创建对应的常量
	 */
	public static void test4() {
		//常量AA不存在，所以第一步就是在常量池中创建了常量AA
		String a2 = new String("AA") + new String("BB");
		String a3 = new String("A") + new String("A");
		System.out.println(a3 == a3.intern()); //false
		
		//只在堆上创建AABB对象，没有在常量池中创建AABB
		String a4 = new String("AA") + new String("BB");
		System.out.println(a4 == a4.intern()); //true
	}
	
	/**
	 * 5.双引号字符串与new String字符串
	 * 	首先创建两个对象，一个是new String的对象，一个是相加后的对象
	 * 	然后判断双引号常量与new String的字面量在常量池是否存在
	 * 		如果存在
	 * 			不做操作
	 * 		如果不存在
	 * 			则在常量池创建对象的常量
	 */
	public static void test5() {
		String a1 = "AABB";
		String a2 = "AA" + new String("BB");
		System.out.println(a1 == a2.intern()); //true
		System.out.println(a2 == a2.intern()); //false
	}
	
	/**
	 * 二、String.intern()分析
	 * 	判断这个常量是否存在于常量池
	 * 		如果存在
	 * 			判断内容是引用还是常量
	 * 				引用
	 * 					返回引用地址指向堆空间对象
	 * 				常量
	 * 					直接返回常量池中的常量
	 * 		如果不存在
	 * 			将当前对象引用赋值到常量池，并且返回是当前对象的引用
	 *	
	 */
	public static void testInternMethod() {
		String a1 = "AA";
		System.out.println(a1 == a1.intern());
		String a2 = new String("B") + new String("B");
		a2.intern();
		String a3 = new String("B") + new String("B");
		System.out.println("a2："+a2.hashCode());
		System.out.println("a2："+a2.intern().hashCode());
		System.out.println("a3："+a3.hashCode());
		System.out.println("a3："+a3.intern().hashCode());
		System.out.println(a2 == a2.intern());
		System.out.println(a2 == a3.intern());
		System.out.println(a3 == a3.intern());
	}
	
	public static void test() {
		String str2 = new String("str") + new String("01");
		str2.intern();
		String str1 = "str01";
		System.out.println(str2 == str1);
	}
	
	public static void main(String[] args) {
		StringTest.test();
//		StringTest.test4();
//		StringTest.testInternMethod();
	}
}
