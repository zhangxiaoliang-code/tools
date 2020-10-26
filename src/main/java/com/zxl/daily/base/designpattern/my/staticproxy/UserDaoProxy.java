package com.zxl.daily.base.designpattern.my.staticproxy;

public class UserDaoProxy implements UserDao {

    private UserDao target;
    public UserDaoProxy(UserDao target){
        this.target = target;
    }
    @Override
    public void save() {
        System.out.println("开启事务");
        target.save();
        System.out.println("提交事务");
    }
}
