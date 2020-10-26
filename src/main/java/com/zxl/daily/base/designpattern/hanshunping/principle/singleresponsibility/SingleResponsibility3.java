package com.zxl.daily.base.designpattern.hanshunping.principle.singleresponsibility;

public class SingleResponsibility3 {
	public static void main(String[] args) {
		Vehicle3 vehicle = new Vehicle3();
		vehicle.runRoad("汽车");
		vehicle.runAir("飞机");
		vehicle.runWater("轮船");
	}
}

// 方式3的分析
// 1. 这种修改方法没有对原来的类做大的修改，只是增加方法	
// 2. 这里虽然没有在类的级别上遵循单一职责原则，但是在方法级别上，仍然是遵守单一职责原则
class Vehicle3 {
	public void runRoad(String vehicle) {
		System.out.println(vehicle + " 在公路上运行...");
	}

	public void runAir(String vehicle) {
		System.out.println(vehicle + " 在天空中运行...");
	}

	public void runWater(String vehicle) {
		System.out.println(vehicle + " 在水中运行...");
	}
}
