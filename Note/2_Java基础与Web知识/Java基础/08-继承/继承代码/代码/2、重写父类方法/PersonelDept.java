package com.pb.dept;

public class PersonelDept extends Department {
	/**
	 * ���²�
	 */	
	private int count;//���¼ƻ���Ƹ����
	
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
	//��д����ķ���printDetail()
	public void printDetail() {
		super.printDetail();
		System.out.println("���¼ƻ���Ƹ����:"+this.count+"\n");
	}
	
}
