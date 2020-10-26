package com.zxl.daily.base.designpattern.hanshunping.principle.demeter.improve;

import java.util.ArrayList;
import java.util.List;

/**
 * 迪米特法则2
 */
public class Demeter {

	public static void main(String[] args) {
		//创建了一个 SchoolManager 对象
		SchoolManager sm = new SchoolManager();
		//输出学院总部id 和 学校员工的id
		sm.printAllEmployee(new CollegeManager());
	}
}

//学校总部员工
class Employee {
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}

//学院的员工
class CollegeEmployee {
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}

//管理学院员工的管理类
class CollegeManager {
	//返回学院的所有员工
	public List<CollegeEmployee> getAllCollegeEmployee(){
		List<CollegeEmployee> list = new ArrayList<CollegeEmployee>();
		for (int i = 0; i < 10; i++) {
			CollegeEmployee emp = new CollegeEmployee();
			emp.setId("学院员工id=" + i);
			list.add(emp);
		}
		return list;
	}
	
	public void printCollegeEmployee() {
		List<CollegeEmployee> list1 = this.getAllCollegeEmployee();
		System.out.println("---------学院员工---------");
		for(CollegeEmployee e : list1) {
			System.out.println(e.getId());
		}
	}
}

//学校管理类
/**
 * 分析 SchoolManager 直接朋友（成员变量、方法参数和返回值类型）类有那些
 * CollegeEmployee 不是直接朋友，而是一个陌生类，这样就违反了 迪米特法则 
 */
class SchoolManager {
	//返回学校总部的员工
	public List<Employee> getAllEmployee(){
		List<Employee> list = new ArrayList<Employee>();
		for (int i = 0; i < 5; i++) {
			Employee emp = new Employee();
			emp.setId("学校总部员工id=" + i);
			list.add(emp);
		}
		return list;
	}
	
	//该方法完成输出学校总部和学院员工信息
	public void printAllEmployee(CollegeManager sub) {
		
		//分析问题
		//将输出学院的员工方法，封装到CollegeManager
		sub.printCollegeEmployee();
		
		List<Employee> list2 = this.getAllEmployee();
		System.out.println("---------学校总部员工--------");
		for(Employee e : list2) {
			System.out.println(e.getId());
		}
	}
}
