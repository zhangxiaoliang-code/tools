package com.zxl.daily.base.designpattern.hanshunping.principle.inversion.improve;

/**
 * @author fengunion
 * 
 * 依赖倒置原则2
 *
 */
public class DependencyInversion {

	public static void main(String[] args) {
		//客户端无需变化
		Person person = new Person();
		person.receive(new Email());
		
		person.receive(new Weixin());
	}
}

interface IReceiver{
	public String getInfo();
}

class Email implements IReceiver{
	public String getInfo() {
		return "电子邮件信息： hello world ！";
	}
}

class Weixin implements IReceiver {
	public String getInfo() {
		return "电子邮件消息： hello ok ！";
	}
}

class Person {
	public void receive(IReceiver i) {
		System.out.println(i.getInfo());
	}
}