package com.zxl.daily.base.designpattern.my.staticproxy;

public class TestProxy {
    public static void main(String[] args) {
        //目标对象
        IUserDao userDao = new IUserDao();
        //代理对象
        UserDaoProxy userDaoProxy = new UserDaoProxy(userDao);
        userDaoProxy.save();
    }
}
