package com.pb.dept;

public class ResearchDept extends Department {
	/**
	 * �з���
	 */
	private String speciality;//�з�����
	
	public ResearchDept(String name,String manager,String responsibility,String speciality){
		super(name,manager, responsibility);
		this.speciality=speciality;		
	}
	public ResearchDept(String speciality){
		super();//Ĭ�ϵ��ø�����޲ι��췽��
		this.speciality=speciality;
	}
	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}	
	
	
}
