import java.util.Scanner;

/*
 * 测试：不同的游客，计算不同的票价
 * */
public class TestVisitor {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String answer="";
		
		do{
			Visitor v1=new Visitor();
			System.out.print("请输入姓名：");
			v1.name=input.next();
			System.out.print("请输入年龄：");
			v1.age=input.nextInt();
			v1.showPrice();
			
			System.out.println("是否继续（y/n）？");
			answer=input.next();
			
		}while(answer.equals("y"));
		
		System.out.println("程序结束！");
		
	}
}
