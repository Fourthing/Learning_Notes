package com.pb.dept;

public class ResearchDept extends Department {
	/**
	 * 研发部
	 */
	private String speciality;//研发方向
	
	public ResearchDept(String name,String manager,String responsibility,String speciality){
		super(name,manager, responsibility);
		this.speciality=speciality;		
	}
	public ResearchDept(String speciality){
		super();//默认调用父类的无参构造方法
		this.speciality=speciality;
	}
	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}	
	
	
}
