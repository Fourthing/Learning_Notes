package cn.pb.polymorphic;

public class Test {

	public static void main(String[] args) {
		Doctor doc=new Doctor();
		Pet pet=new Dog();
		//Pet pet=new Bird();
		//Pet pet=new Pig();
		doc.cure(pet);

	}

}
