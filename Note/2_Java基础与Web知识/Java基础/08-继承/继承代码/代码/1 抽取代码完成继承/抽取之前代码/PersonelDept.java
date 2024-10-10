package com.pb.dept;
/**
	 * 人事部
	 */	
public class PersonelDept extends Department {
	private int ID;//部门编号
	private String name="待定";//部门名称
	private int amount=0;//部门人数
	private String responsibility="待定";//部门职责
	private String manager="无名氏";//部门经理
	private int count;//本月计划招聘人数
	
	public PersonelDept(String name,String manager,String responsibility,int count){
		this.name=name;
		this.manager=manager;
		this.responsibility=responsibility;	
		this.count=count;
	}		
	public int getCount() {
		return count;
	}
	public void setCount(int count){
		this.count = count;
	}
	
	public void printDetail() {
		System.out.println("部门:" + 
				this.name + "\n经理：" + this.manager 
				+ "\n部门职责："+this.responsibility+ "\n****************"+"本月计划招聘人数:"+this.count+"\n");
	
	}
	
}
