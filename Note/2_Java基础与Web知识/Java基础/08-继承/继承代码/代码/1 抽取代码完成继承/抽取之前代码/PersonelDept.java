package com.pb.dept;
/**
	 * ���²�
	 */	
public class PersonelDept extends Department {
	private int ID;//���ű��
	private String name="����";//��������
	private int amount=0;//��������
	private String responsibility="����";//����ְ��
	private String manager="������";//���ž���
	private int count;//���¼ƻ���Ƹ����
	
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
		System.out.println("����:" + 
				this.name + "\n����" + this.manager 
				+ "\n����ְ��"+this.responsibility+ "\n****************"+"���¼ƻ���Ƹ����:"+this.count+"\n");
	
	}
	
}
