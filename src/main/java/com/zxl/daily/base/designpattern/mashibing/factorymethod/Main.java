package com.zxl.daily.base.designpattern.mashibing.factorymethod;

public class Main {
	public static void main(String[] args) {
		Moveable m = new CarFactor().create();
		m.go();
	}
}
