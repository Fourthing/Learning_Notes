import java.util.Scanner;

/*
 * ���ԣ���ͬ���οͣ����㲻ͬ��Ʊ��
 * */
public class TestVisitor {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String answer="";
		
		do{
			Visitor v1=new Visitor();
			System.out.print("������������");
			v1.name=input.next();
			System.out.print("���������䣺");
			v1.age=input.nextInt();
			v1.showPrice();
			
			System.out.println("�Ƿ������y/n����");
			answer=input.next();
			
		}while(answer.equals("y"));
		
		System.out.println("���������");
		
	}
}
