
/**
 * 狗狗类
 */
public class Dog extends Pet {
	@Override
	void toHospital() {
		System.out.println("打针、吃药");
	}
	
	public void run(){
		System.out.println("狗狗在草坪上疯狂着跑着...");
	}
}
