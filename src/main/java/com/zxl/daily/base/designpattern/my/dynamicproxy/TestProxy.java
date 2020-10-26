package com.zxl.daily.base.designpattern.my.dynamicproxy;

//import org.junit.Test;

public class TestProxy {

//    @Test
    public void testDynadicProxy() {
        UserDao userDao = new IUserDao();
        System.out.println(userDao.getClass()); //输出目标对象信息
        ProxyFactory proxyFactory = new ProxyFactory(userDao);
        UserDao proxy = (UserDao) proxyFactory.getProxyInstance();
        System.out.println(proxy.getClass());   //输出代理信息
        proxy.save();
    }

    public static void main(String[] args) {
        B b = new B();
    }
}

class A{
    private String s1;
    String s2;
    protected String s3;
    public String s4;

    private void m1(){}
    void m2(){}
    protected void m3(){}
    public void m4(){}

    public A(String s){
        System.out.println("A class");
        this.s1 = s;
    }
    public A(){}
}

class B extends A{
    public B(){
//        super();
        System.out.println("B class");
    }
}
