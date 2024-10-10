package structMehtod;
//学生类
public class Student {
	//属性
	public String name;//姓名
	public int score;
	
	public Student(String name,int score){
		this.name=name;
		this.score=score;
	}
	//方法
	public void showInfo(){
		System.out.println(name+"的成绩是："+score);
	}
}
