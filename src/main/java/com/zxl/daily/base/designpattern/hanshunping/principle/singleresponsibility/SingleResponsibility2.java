package com.zxl.daily.base.designpattern.hanshunping.principle.singleresponsibility;

public class SingleResponsibility2 {

	public static void main(String[] args) {
		RoadVehicle2 roadVehicle = new RoadVehicle2();
		roadVehicle.run("汽车");
		roadVehicle.run("摩托车");

		AirVehicle2 airVehicle = new AirVehicle2();
		airVehicle.run("飞机");
	}

}

// 方法2的分析
// 1. 遵守单一 职责原则
// 2. 但是这样做改动很大，即将类分解，同时修改客户端
// 3. 改进：直接修改Vehicle类， 改动的代码会比较少 => 方案3

class RoadVehicle2 {
	public void run(String vehicle) {
		System.out.println(vehicle + " 在公路上运行...");
	}
}

class AirVehicle2 {
	public void run(String vehicle) {
		System.out.println(vehicle + " 在天空中运行...");
	}
}

class WeterVehicle2 {
	public void run(String vehicle) {
		System.out.println(vehicle + " 在水里运行...");
	}
}
