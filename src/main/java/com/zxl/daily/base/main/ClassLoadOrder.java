package com.zxl.daily.base.main;

/**
 * 测试类加载顺序
 */
public class ClassLoadOrder {

    public static void main(String[] args) {
        Derived derived = new Derived();

        /**
         * 预计输出:
         * 基类静态代码块和基类静态成员变量
         * Base Static Block 1
         * Base Static Fiels
         * Base Static Block 2
         *
         * 派生类静态代码块和派生类静态成员变量
         * Static Block 1
         * Static fiels
         * Static Block 2
         *
         *
         *
         * 基类代码块和基类普通成员变量
         * Base Normal Block 1
         * Base Normal Files
         * Base Normal Block 2
         *
         *
         *
         *
         * 基类构造函数
         * Base Constructor
         *
         * 派生类代码块和派生类普通成员变量
         * Normal Block 1
         * Normal Field
         * Normal Block 2
         *
         * 派生类构造函数
         * Derived Constructor
         *
         */
    }

}

class Log{
    public static String initLog(String log){
        System.out.println(log);
        return null;
    }
}

/**
 * 基类
 */
class Base{
    static {
        System.out.println("Base Static Block 1");
    }

    private static String staticValue = Log.initLog("Base Static Fiels");

    static {
        System.out.println("Base Static Block 2");
    }

    {
        System.out.println("Base Normal Block 1");
    }

    private String value = Log.initLog("Base Normal Files");

    {
        System.out.println("Base Normal Block 2");
    }

    Base() {
        System.out.println("Base Constructor");
    }
}

/**
 * 派生类
 */

class Derived extends Base {
    static {
        System.out.println("Static Block 1");
    }

    private static String staticValue = Log.initLog("Static fiels");

    static {
        System.out.println("Static Block 2");
    }

    {
        System.out.println("Normal Block 1");
    }

    private String value = Log.initLog("Normal Field");

    {
        System.out.println("Normal Block 2");
    }

    Derived() {
        System.out.println("Derived Constructor");
    }

    public static void main(String[] args) {
        System.out.println("2");
    }
}




