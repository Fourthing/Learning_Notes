package com.pb.test;

import com.pb.dept.*;

public class DeptTest {

	/**
	 * ������ļ̳�
	 */
	
	public static void main(String[] args) {
		//PersonelDept pd=new PersonelDept("���²�","������","����˾���˲���Ƹ����ѵ��",18);
		//ResearchDept rd=new ResearchDept("�ֻ�ͨѶ");
		
		ResearchDept rd=new ResearchDept("�з���","���","����˾�²�Ʒ�Ŀ�����������","�ֻ�ͨѶ");
		ResearchDept rd2=new ResearchDept("�з���","���","����˾�²�Ʒ�Ŀ�����������","�ֻ�ͨѶ");
			
		rd.printDetail();
		
		
	}

}
