/**
 * 宠物类
 */
public abstract class Pet {

	private String name; //宠物名字
	private String sex;  //宠物性别
	private int health;  //宠物健康值
	abstract void toHospital(); //宠物看病
	
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
