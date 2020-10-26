package com.zxl.daily.base.designpattern.mashibing.abstractfactory;

import java.awt.Frame;
import java.lang.reflect.Proxy;

public class Main {

	public static void main(String[] args) {
		AbstractFactory f = new ModernFactory();
		
		Vehicle c = f.createVehicle();
		c.go();
		
		Weapon w = f.createWeapon();
		w.shoot();
		
		Food b = f.createFood();
		b.printName();
		
		System.out.println(5 != 5);
		
		Frame frame = new Frame();
		
//		Proxy.newProxyInstance(loader, y, h)
	}
}
