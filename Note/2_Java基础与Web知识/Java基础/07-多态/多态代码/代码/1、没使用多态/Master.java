
/**
 * ������
 */
public class Master{

	/**
	 * ��С�������ķ���
	 * @param dog
	 */
	public void cure(Dog dog) {
        if (dog.getHealth() < 50) {
        	System.out.println("���롢��ҩ");
            dog.setHealth(60);
        }
    }
	
	/**
	 * ��С�񿴲��ķ���
	 * @param bird
	 */
	public void cure(Bird bird) {
        if (bird.getHealth() < 50) {
        	System.out.println("��ҩ������");
        	bird.setHealth(60);      
        }
    }
}
