package com.pb.dept;

/**
 * 父类：Department
 */
public class Department {
	private int ID;//部门编号
	private String name="待定";//部门名称
	private int amount=0;//部门人数
	private String responsibility="待定";//部门职责
	private String manager="无名氏";//部门经理
	
	public Department(){
		
	}
	
	public Department(String name,String manager,String responsibility){
		this.name=name;
		this.manager=manager;
		this.responsibility=responsibility;
	}
	public int getID() {
		return ID;
	}
	public void setID(int id) {
		this.ID = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getResponsibility() {
		return responsibility;
	}
	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	
	public void printDetail() {
		System.out.println("部门:" + 
				this.name + "\n经理：" + this.manager 
				+ "\n部门职责："+this.responsibility+ "\n****************");
	}
	

}
