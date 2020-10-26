package com.zxl.daily.base.designpattern.hanshunping.principle.inversion.improve;

/**
 * @author fengunion
 * 
 * 依赖倒置原则3
 *
 */
public class DependencyPass {

	public static void main(String[] args) {
		OpenAndClose openAndClose = new OpenAndClose();
	}
}

// 方式一：通过接口传递实现依赖
// 开关接口
//interface IOpenAndClose {
//	void open(ITV tv);	//抽象方法，接收接口
//}
//
//interface ITV {
//	void play();
//}
//
//// 实现接口
//class OpenAndClose implements IOpenAndClose{
//	public void open(ITV tv) {
//		tv.play();
//	}
//}

// 方式二：通过构造方法依赖传递
//interface IOpenAndClose {
//	void open();
//}
//
//interface ITV {
//	void play();
//}
//
//class OpenAndClose implements IOpenAndClose{
//	
//	public ITV tv;
//	
//	public OpenAndClose(ITV tv) {
//		this.tv = tv;
//	}
//	
//	public void open() {
//		tv.play();
//	}
//}

// 方式三 通过setter方法传递参数
interface IOpenAndClose {
	void open();
}

interface ITV {
	void play();
}

class OpenAndClose implements IOpenAndClose{
	private ITV tv;
	
	public void setTv(ITV tv) {
		this.tv = tv;
	}
	
	public void open() {
		tv.play();
	}
}