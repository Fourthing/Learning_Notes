
/**
 * 主人类
 */
public class Master{

	/**
	 * 给小狗看病的方法
	 * @param dog
	 */
	public void cure(Dog dog) {
        if (dog.getHealth() < 50) {
        	System.out.println("打针、吃药");
            dog.setHealth(60);
        }
    }
	
	/**
	 * 给小鸟看病的方法
	 * @param bird
	 */
	public void cure(Bird bird) {
        if (bird.getHealth() < 50) {
        	System.out.println("吃药、疗养");
        	bird.setHealth(60);      
        }
    }
}
