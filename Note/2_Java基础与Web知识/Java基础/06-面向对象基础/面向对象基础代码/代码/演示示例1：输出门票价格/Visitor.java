/*
 * 游客类
 * */
public class Visitor {
	//属性:姓名      年龄
	String name;
	int age;
	
	//方法:根据不同年龄计算不同的门票价格
	public void showPrice(){
		if(age<=10){
			System.out.println("门票免费");
		}else if(age<=60){
			System.out.println("门票全费：20元");
		}else{
			System.out.println("门票半价：10元");
		}
	}
}
