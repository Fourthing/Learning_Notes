/*
 * �ο���
 * */
public class Visitor {
	//����:����      ����
	String name;
	int age;
	
	//����:���ݲ�ͬ������㲻ͬ����Ʊ�۸�
	public void showPrice(){
		if(age<=10){
			System.out.println("��Ʊ���");
		}else if(age<=60){
			System.out.println("��Ʊȫ�ѣ�20Ԫ");
		}else{
			System.out.println("��Ʊ��ۣ�10Ԫ");
		}
	}
}
