package com.pb.dept;

/**
 * ���ࣺDepartment
 */
public class Department {
	private int ID;//���ű��
	private String name="����";//��������
	private int amount=0;//��������
	private String responsibility="����";//����ְ��
	private String manager="������";//���ž���
	
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
	//��дequals()����������������ơ�����ְ����ͬ��֤����ͬһ������
	/*public boolean equals(Object o){
		if(this==o){
			return true;
		}
		if(! (o instanceof Department)){
			return false;
		}
		Department obj=(Department)o;
		if(this.name.equals(obj.name) && this.manager.equals(obj.manager)&& this.responsibility.equals(obj.responsibility)){
			return true;
		}else{
			return false;
		}		
	}*/
	public void printDetail() {
		System.out.println("����:" + 
				this.name + "\n����" + this.manager 
				+ "\n����ְ��"+this.responsibility+ "\n****************");
	}
	

}
