package com.pb.dept;

public class PersonelDept extends Department {
	/**
	 * 人事部
	 */	
	private int count;//本月计划招聘人数
	
	public PersonelDept(String name,String manager,String responsibility,int count){
		super(name,manager, responsibility);		
		this.count=count;
	}		
	public int getCount() {
		return count;
	}
	public void setCount(int count){
		this.count = count;
	}
	
	
}
