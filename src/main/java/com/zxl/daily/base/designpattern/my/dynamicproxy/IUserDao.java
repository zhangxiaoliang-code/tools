package com.zxl.daily.base.designpattern.my.dynamicproxy;

public class IUserDao implements UserDao{
    @Override
    public void save() {
        System.out.println("save data");
    }
}
