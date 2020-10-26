package com.zxl.daily.base.designpattern.mashibing.factorymethod;

/**
 * 
 * 简单工厂的扩展性不好
 *
 */
public class SimpleVehicleFactory {
	
	public Car create() {
		//before processing
		return new Car();
	}
	
	public Broom createBroom() {
		//before processing
		return new Broom();
	}
	
	public Plane createPlane() {
		//before processing
		return new Plane();
	}
}
