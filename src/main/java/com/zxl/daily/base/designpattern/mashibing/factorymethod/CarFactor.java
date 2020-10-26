package com.zxl.daily.base.designpattern.mashibing.factorymethod;

public class CarFactor {
	
	public Moveable create() {
		
		System.out.println("a car created!");
		
		return new Car();
	}

}
