package com.zxl.daily.base.reflect;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 反射机制：在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法和属性；
 *          这种动态获取的信息以及动态调用对象的方法的功能称为java语言的反射机制。
 *
 * 反射能做什么
 *  1.在运行时判断任意一个对象所属的类
 *  2.在运行时构造任意一个类的对象
 *  3.在运行时判断任意一个类所具有的成员变量和方法；
 *  4.在运行时调用任意一个对象的方法
 *  5.生成动态代理
 */
public class TestReflect extends User implements Serializable {

    private static final long serialVersionUID = -2862585049955236662L;

    private static int fPrivate = 99;

    public String  fPublic = "aa";

    protected String fProtected = "bb";

    private void mPrivate(){}

    protected void mProtected(){}

    public void mPublic(){}


    public static void main(String[] args) throws Exception {

        //通过一个对象获取完成的包名和类名类名称： com.zxl.test.TestReflect
        getTest1();

        //实例化class对象
        getTest2();

        //获取一个对象的父类与实现的接口
        getTest3();

        /**
         * 获取某个类中的全部构造函数
         * 通过反射机制实例化一个类的对象
         */
        getTest4();

        //获取某个类的全部属性
        getTest5();

        //获取某个类的全部方法
        getTest6();

    }

    /**
     * 通过一个对象获取完成的包名和类名类名称： com.zxl.test.TestReflect
     */
    public static void getTest1(){
        //class com.zxl.test.base.Father
        TestReflect reflect = new TestReflect();
        System.out.println(reflect.getClass().getName());
        //结果：com.zxl.test.TestReflect
        System.out.println("----------------------------");
    }

    /**
     * 实例化class对象
     */
    public static void getTest2() throws Exception {
        Class<?> clazz1 = null;
        Class<?> clazz2 = null;
        Class<?> clazz3 = null;
        clazz1 = Class.forName("com.zxl.test.reflect.TestReflect");
        clazz2 = new TestReflect().getClass();
        clazz3 = TestReflect.class;
        System.out.println("类名称： "+clazz1.getName());
        System.out.println("类名称： "+clazz2.getName());
        System.out.println("类名称： "+clazz3.getName());
        System.out.println("----------------------------");
    }

    /**
     * 获取一个对象的父类与实现的接口
     */
    public static void getTest3() throws Exception {
        Class<?> clazz = Class.forName("com.zxl.test.reflect.TestReflect");
        System.out.println("clazz的父类：" + clazz.getSuperclass());
        System.out.println("clazz实现的接口有：");
        Class<?> inters[] = clazz.getInterfaces();
        for (int i = 0; i < inters.length; i++){
            System.out.println(inters[i]);
        }
        System.out.println("----------------------------");
    }

    /**
     * 获取某个类中的全部构造函数
     * 通过反射机制实例化一个类的对象
     */
    public static void getTest4() throws Exception {
        Class<?> classUser = Class.forName("com.zxl.test.reflect.User");
        User user = (User)classUser.newInstance();
        user.setAge(12);
        user.setName("小小");
        System.out.println(user);
        Constructor<?> cons[] = classUser.getConstructors();
        System.out.println("User类的所有构造函数如下：");
        for (int i = 0; i < cons.length; i++) {
            System.out.println(cons[i]);
        }
        System.out.println("----------------------------");
    }

    /**
     * 获取某个类的全部属性
     */
    public static void getTest5() throws Exception{
        Class<?> clazz4 = Class.forName("com.zxl.test.reflect.TestReflect");
        System.out.println("===============本类属性===============");
        //是返回声明的所有字段
        Field[] fields = clazz4.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
//            System.out.println(fields[i]);
            //权限修饰符(获取修饰符所代表的数字，例如：private：1，public：2.。。。。)
            int mo = fields[i].getModifiers();
//            System.out.println(mo);
            //通过数字获取修饰符（例如：1：private，2：public.。。。。）
            String priv = Modifier.toString(mo);
            //属性类型
            Class<?> type = fields[i].getType();
//            System.out.println(fields[i].getName() + " : " + type.getName() + " : " + fields[i].getName() + ";");
            System.out.println(priv + " : " + type.getName() + " : " + fields[i].getName() + ";");
        }
        Method[] methods = clazz4.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
//            System.out.println(methods[i]);
        }
        System.out.println("==========其实是获取本类以及父类和实现接口的所有公有属性==========");
        // 其实是获取本类以及父类和实现接口的所有公有属性
        Field[] fields1 = clazz4.getFields();
        for (int i = 0; i < fields1.length; i++) {
            //权限修饰符
            int mo = fields1[i].getModifiers();
            String priv = Modifier.toString(mo);
            // 属性类型
            Class<?> type = fields1[i].getType();
            System.out.println(priv + " " + type.getName() + " " + fields1[i].getName() + ";");
        }
        System.out.println("----------------------------");
    }

    /**
     * 获取某个类的全部方法
     */
    public static void getTest6() throws Exception {
        Class<?> clazz = Class.forName("com.zxl.test.reflect.TestReflect");
        Method[] methods = clazz.getMethods();
//        Method[] methods = clazz.getDeclaredMethods();
        System.out.println(methods.length);
        for (int i = 0; i < methods.length; i++) {
            System.out.println(i + " : "+ methods[i]);
        }



    }

    /**
     *
     */
    public static void getTest7(){}

    /**
     *
     */
    public static void getTest8(){}
}

class User {
    public String ss;
    private int age;
    private String name;

    public User() {
        super();
    }

    public User(int age) {
        this.age = age;
    }

    public User(String name) {
        this.name = name;
    }

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" + "age=" + age + ", name='" + name + '\'' + '}';
    }
}
