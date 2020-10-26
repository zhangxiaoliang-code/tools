package com.zxl.daily.base;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Test {

	static final int hash(Object key) {
		int h;
		return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	}

    private static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(2, 0.75f);
	
	public static void main(String[] args) {

		String[] s = {"a","a","b","c","d","e","f","f","f"};
		Map<String, Integer> map = new HashMap<String, Integer>();
		int temp = 1;
		Integer value;
		for (int i = 0; i < s.length; i++) {
			String key = s[i];
			if(!"".equals(value = map.get(key)) && null != value){
				value += temp;
			}else{
				value = temp;
			}
			map.put(key, value);
		}

		for(int i = 0; i < s.length; i++){

		}

		System.out.println(map);

	    /*map.put(5, 55);

	    new Thread("thread1"){
	        public void run(){
	             map.put(7, 77);
                System.out.println(map);
            }
        }.start();

	    new Thread("thread2"){
	        public void run (){
	            map.put(3, 33);
                System.out.println(map);
            }
        }.start();

        System.out.println(Integer.highestOneBit(10));
        System.out.println(Integer.highestOneBit(15));
        System.out.println(Integer.highestOneBit(16));


        ConcurrentHashMap hashMap = new ConcurrentHashMap();

        List list = new ArrayList();*/


		/*int a;
		System.out.println(Test.hash("zxll"));
		System.out.println("zxl".hashCode());
		System.out.println("a".hashCode()^"a".hashCode() >>> 16);
		System.out.println(1<<30);
		System.out.println((int)'a');*/

//		System.out.println((int)'y');

//		Map linkMap = new LinkedHashMap();
//		Map map = new HashMap();
//		map.put(null,1);
//		map.put(null,2);
//		System.out.println(map.get(null));
//		map.put("a",null);
//		map.put("b",null);
//		System.out.println(map.get("a"));
//		System.out.println(map.get("b"));

		//再试一次修改更新
		/*List<String> list1 = new ArrayList<String>();
		list1.add("A");
		list1.add("B");
		list1.add("C");
		
		List<String> list2 = new ArrayList<String>();
		list2.add("B");
		list2.add("C");
		list2.add("D");*/
		
		//并集
		/*list1.addAll(list2);
		System.out.println(list1);*/
		//交集
		/*list1.retainAll(list2);
		System.out.println(list1);*/
		//差集合并
		/*List<String> list3 = new ArrayList<String>();
		list3.addAll(list1);
		System.out.println("list3:"+list3);
		list3.removeAll(list2);
		list3.addAll(list2);
		System.out.println("list3:"+list3);
		list1.retainAll(list2);
		System.out.println("list1:"+list1);
		list3.removeAll(list1);
		System.out.println("list3:"+list3);*/
		//无重复并集
		/*list2.removeAll(list1);
		System.out.println(list1);
		System.out.println(list2);
		list1.addAll(list2);
		System.out.println(list1);*/
		
//		System.arraycopy(src, srcPos, dest, destPos, length);
		
		/*List<Student> list1 = new ArrayList<Student>();
		Student s1 = new Student(1, "张三", 19, null);
		Student s2 = new Student(2, "李四", 20, null);
		Student s3 = new Student(3, "王五", 21, null);
		list1.add(s1);
		list1.add(s2);
		list1.add(s3);
		
		List<Student> list2 = new ArrayList<Student>();
		Student s22 = new Student(2, null, null, "备注2");
		Student s33 = new Student(3, null, null, "备注3");
		list2.add(s22);
		list1.add(s33);
		
		list1.addAll(list2);
		Map<Integer, Student> map = new HashMap<Integer, Student>();
		for (int i = 0; i < list1.size(); i++) {
			Student newStu = list1.get(i);
			Student stu = null;
			if(null!= (stu = map.get(newStu.getId()))) {
				if(newStu.getName()!=null) {
					stu.setName(newStu.getName());
				}
				if(newStu.getAge()!=null) {
					stu.setAge(newStu.getAge());
				}
				if(newStu.getOther()!=null) {
					stu.setOther(newStu.getOther());
				}
			}else {
				map.put(newStu.getId(), newStu);
			}			
		}
		System.out.println(123);
		System.out.println(map);
		for(Integer key: map.keySet()) {
			Student ss = map.get(key);
			System.out.println("id:"+ss.getId()+" name: "+ss.getName()+" age: "+ss.getAge()+" other: "+ss.getOther());
		}*/
		
//		System.out.println(24L * 3600 * 1000);
//
//		System.out.println(TimeZone.getDefault().getRawOffset());
//
//		StringBuilder sb = new StringBuilder("abc");
//		sb.append("d");
//		System.out.println(sb.toString());
	}
	
	
	
	private static final class MillisTimerTask implements Runnable {

		/**
		 * 一天 24 小时有多少毫秒
		 */
		private static final long MILLIS_IN_DAY = 24L * 3600 * 1000;
		
		/**
		 * 系统默认时区的偏移毫秒值
		 */
		private final int TIME_ZONE_OFFSET = TimeZone.getDefault().getRawOffset();
		
		/**
		 * 当前毫秒时间
		 */
		private final AtomicLong current;
		
		/**
		 * 自 1970 年至当前时间过去了多少天
		 */
		private final AtomicInteger oldUnixDays;
		
		/**
		 * 当前计算压缩的日期
		 */
		private final AtomicInteger compressedDay;
		
		
		
		private MillisTimerTask() {
			this.current = new AtomicLong(System.currentTimeMillis());
			this.oldUnixDays = new AtomicInteger();
			this.compressedDay = new AtomicInteger();
		}
		
		private static long mask(long num, long mask, long multi) {
			return (num & Long.MAX_VALUE) % mask * multi;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	}

}

class Student {

	private int id;
	
	private String name;
	
	private Integer age;
	
	private String other;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public Student(int id, String name, Integer age, String other) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.other = other;
	}
}

