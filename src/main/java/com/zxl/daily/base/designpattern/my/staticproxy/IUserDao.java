package com.zxl.daily.base.designpattern.my.staticproxy;

public class IUserDao implements UserDao{
    @Override
    public void save() {
        System.out.println("save data");
    }
}
