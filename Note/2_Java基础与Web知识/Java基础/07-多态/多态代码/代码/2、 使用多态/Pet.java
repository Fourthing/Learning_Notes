/**
 * ������
 */
public abstract class Pet {

	private String name; //��������
	private String sex;  //�����Ա�
	private int health;  //���｡��ֵ
	abstract void toHospital(); //���￴��
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
}
