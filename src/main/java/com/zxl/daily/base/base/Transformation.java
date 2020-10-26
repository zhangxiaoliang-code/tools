package com.zxl.daily.base.base;

import java.util.*;

public class Transformation {
    public static void main(String[] args) {

        Son son = new Son();
        //首先先明确一点，转型指的是左侧引用的改变。
        //father引用类型是Father，指向Son实例，就是向上转型，既可以使用子类的方法，也可以使用父类的方法。
        //向上转型，此时运行的father的方法。
        Father father = son;
        father.smoke();
        //不能使用子类独有的方法
        //father.play();编译会报错
        father.drive();
        //Son类型引用指向Father实例，所以是向下转型，不能使用子类非重写的方法，可以使用父类的方法。

        //向下转型，此时运行了son的方法
        Son son1 = (Son)father;
        //转型了就是一个正常的Son实例了
        son1.play();
        son1.drive();
        son1.smoke();

        //因为向下转型前必须先经历向上转型
        //向下转型分为两种情况：
        //情况一：如果父类引用的对象时指向子类，那么向下转型的过程是安全的。也就是在编译时不会出现错误。
        //因为运行期Son实例确实有这些方法
        Father f1 = new Son();
        Son s1 = (Son)f1;
        s1.smoke();
        s1.drive();
        s1.play();
        //情况二：如果父类的引用指向的是父类的对象，那么向下转型过程中是不安全的，编译不会出错。
        //但是在运行时会出现 java.lang.ClassCastExecption 错误。它可以使用 instanceof 来避免出现此类错误。
        //因为运行期Father实例并没有这些方法。
        Father f2 = new Father();
        Son s2  = (Son) f2;
        s2.smoke();
        s2.drive();
        s2.play();

        //向下转型和向上转型的应用，有些人觉得这个操作没意义，何必先向上转型再向下转型呢，不是多此一举么。其实可以用于方法参数中的类型聚合，然后具体操作再进行分解。
        //比如add方法用List引用类型作为参数传入，传入具体类时经历了向下转型
        add(new LinkedList());
        add(new ArrayList());

        //总结：
        //向上转型和向下转型都是针对引用转型，是编译器进行的转型，根据引用类型来判断使用哪个方法
        //并且在传入方法时会自动进行转型（有需要的话）。运行期将引用指向实例，如果是不安全的转型则会报错。
        //若安全继续执行方法

    }

    public static void add(List list){
        System.out.println(list);
        //在操作具体集合时又经历了向上转型
        //ArrayList arr = (ArrayList)list;
        //LinkedList link = (LinkedList)list;
    }
}
