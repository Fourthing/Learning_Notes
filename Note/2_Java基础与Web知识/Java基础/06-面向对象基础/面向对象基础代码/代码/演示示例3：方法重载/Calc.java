package structMehtod;

public class Calc {
	public int getSum(int num1,int num2){
		System.out.println("int");
		return num1+num2;
	}
	
	public double getSum(double num1,double num2){
		System.out.println("double");
		return num1+num2;
	}
	
	public double getSum(double num1,double num2,double num3){
		return num1+num2+num3;
	}
	
	public static void main(String[] args) {
		Calc calc=new Calc();
		System.out.println(calc.getSum(67, 89));
		System.out.println(calc.getSum(67, 89,78.4));
	}
}
