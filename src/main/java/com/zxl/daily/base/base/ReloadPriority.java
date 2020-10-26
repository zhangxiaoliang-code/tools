package com.zxl.daily.base.base;

import java.util.Arrays;

public class ReloadPriority {

    public static void main(String[] args) {
        ReloadPriority a = new ReloadPriority();
        //普通的重载一般就是同名方法不同参数。
        //这里我们讨论同名方法只有一个参数时的情况。
        //此时会调用char参数的方法。
        //当没有char参数的方法，会调用int参数的方法，如果没有int就会调用long
        //既存在一个调用顺序char->int->long->double->...
        //当没有基本类型对应的方法时，先自动装箱，调用包装类方法。
        //如果没有包装类方法，则调用包装类实现的接口方法。
        //最后在调用持有多个参数的char。。。方法
        a.eat('a');
        a.eat('a','b','c');
    }

    public void eat(short i){
        System.out.println("short");
    }
    public void eat(int i){
        System.out.println("int");
    }
    public void eat(double i){
        System.out.println("double");
    }
    public void eat(long i){
        System.out.println("long");
    }
    public void eat(Character c){
        System.out.println("Character");
    }
    public void eat(Comparable c){
        System.out.println("Comparable");
    }
    public void eat(char ... c){
        System.out.println(Arrays.toString(c));
        System.out.println("...");
    }
//    public void eat(char i){
//        System.out.println("char");
//    }
}
