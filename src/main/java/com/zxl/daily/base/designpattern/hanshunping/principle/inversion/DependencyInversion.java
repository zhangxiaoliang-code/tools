package com.zxl.daily.base.designpattern.hanshunping.principle.inversion;

/**
 * @author fengunion
 * 
 * 依赖倒置原则1
 *
 */
public class DependencyInversion {

	public static void main(String[] args) {
		Person person = new Person();
		person.receive(new Email());
	}

}

class Email {
	public String getInfo() {
		return "电子邮件信息：hello world ！";
	}
}

//完成Person接收消息的功能
/**
 * 方式1分析
 * 1.简单，比较容易想到
 * 2.如果我们接到对象是微信，短信等等，则新增类，同时Person也要增加相应的接收方法
 * 3.解决思路：引入一个抽象的IReceiver，表示一个接收者，这样Person类与接口IReceiver发生依赖
 * 	 因为Email、微信、短信等等属于接收范围，它们各自实现IReveiver 接口就OK，这样我们就符合依赖倒置原则
 */
class Person {
	public void receive(Email email) {
		System.out.println(email.getInfo());
	}
}
