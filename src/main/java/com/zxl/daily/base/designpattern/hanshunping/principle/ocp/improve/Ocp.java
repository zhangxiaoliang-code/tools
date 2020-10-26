package com.zxl.daily.base.designpattern.hanshunping.principle.ocp.improve;


/**
 * 开闭原则2
 *
 */
public class Ocp {

	public static void main(String[] args) {
		GraphicEditor graphicEditor = new GraphicEditor();
		graphicEditor.drawShape(new Rectangle());
		graphicEditor.drawShape(new Circle());
		graphicEditor.drawShape(new Triangle());
	}

}

//用于绘制图形类{适用方}
class GraphicEditor {
	//接收Shape对象，然后根据type，来绘制不同的图形
	public void drawShape(Shape s) {
		s.draw();
	}
}

// Shape类 基类
abstract class Shape {
	int type;
	
	abstract void draw();
}

class Rectangle extends Shape{
	Rectangle(){
		super.type = 1;
	}
	
	public void draw() {
		System.out.println(" 绘制矩形 ");
	}
}

class Circle extends Shape{
	Circle(){
		super.type = 2;
	}
	
	public void draw() {
		System.out.println(" 绘制圆形 ");
	}
}

class Triangle extends Shape{
	Triangle(){
		super.type = 3;
	}
	
	public void draw() {
		System.out.println(" 绘制三角形 ");
	}
}
