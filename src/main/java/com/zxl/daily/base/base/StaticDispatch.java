package com.zxl.daily.base.base;

public class StaticDispatch {
    public static void main(String[] args) {
        Father father  = new Son();
        StaticDispatch a = new StaticDispatch();

        //编译期确定类型是Father
        //所以调用的是第一个方法。
        a.play(father);
        //向下转型后，引用类型是Son，此时调用第二个方法。
        //所以编译期只确认了引用，运行期在进行实例化。
        a.play((Son) father);
        //当没有Son引用类型的方法时，会自动向上转型调用第一个方法。
        a.smoke(father);
    }

    public void smoke(Father father){
        System.out.println("father smoke");
    }

    public void play(Father father){
        System.out.println("father");
        //father.drive();
    }

    public void play(Son son){
        System.out.println("son");
        //son.drive();
    }
}
