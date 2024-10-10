

/**
 * 小鸟类
 */
public class Bird extends Pet {

	@Override
	void toHospital() {
		System.out.println("吃药、疗养");
	}
	
	public void run(){
		System.out.println("小鸟在树上快乐的跳来跳去...");
	}
}
