package com.pb.test;

import com.pb.dept.*;

public class DeptTest {

	/**
	 * 测试类的继承
	 */
	
	public static void main(String[] args) {
		//PersonelDept pd=new PersonelDept("人事部","王经理","负责公司的人才招聘和培训。",18);
		//ResearchDept rd=new ResearchDept("手机通讯");
		
		ResearchDept rd=new ResearchDept("研发部","李经理","负责公司新产品的开发和升级。","手机通讯");
		ResearchDept rd2=new ResearchDept("研发部","李经理","负责公司新产品的开发和升级。","手机通讯");
			
		rd.printDetail();
		
		
	}

}
