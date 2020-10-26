package com.zxl.daily.base.designpattern.hanshunping.principle.ocp;

/**
 * 开闭原则1
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
		if(s.type == 1)
			drawRectangle(s);
		else if(s.type == 2)
			drawCircle(s);
		else if(s.type == 3)
			drawTriangle(s);
	}
	
	public void drawRectangle(Shape s) {
		System.out.println(" 绘制矩形 ");
	}
	
	public void drawCircle(Shape s) {
		System.out.println(" 绘制圆形 ");
	}
	
	public void drawTriangle(Shape s) {
		System.out.println(" 绘制三角形 ");
	}
}

class Shape {
	int type;
}

class Rectangle extends Shape{
	Rectangle(){
		super.type = 1;
	}
}

class Circle extends Shape{
	Circle(){
		super.type = 2;
	}
}

class Triangle extends Shape{
	Triangle(){
		super.type = 3;
	}
}
