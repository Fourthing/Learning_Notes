

/**
 * 宠物企鹅类，给构造方法加上返回值类型会出现什么情况呢？
 */
class Penguin {
	private String name =null; // 昵称
	private int health = 0; // 健康值
	private int love = 0; // 亲密度
	private String sex =null; // 性别

	public Penguin() {
		
	}
	
	public Penguin(String name,int health,String sex){
		this.name=name;
		this.health=health;
		this.sex=sex;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		if(health<0||health>100){
			System.out.println("健康值应该在0至100之间，默认值为60。");
			this.health=60;
			return;
		}
		this.health = health;
	}

	public int getLove() {
		return love;
	}

	public void setLove(int love) {
		if(love<0||love>100){
			System.out.println("亲密度应该在0至100之间，默认值为10。");
			this.love=10;
			return;
		}
		this.love = love;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}


	/**
	 * 输出企鹅的信息。
	 */
	public void print() {
		System.out.println("宠物的自白：\n我的名字叫" + this.getName() 
				+ "，健康值是" + this.getHealth()	+ "，和主人的亲密度是" 
				+ this.getLove() + "，我的性别是 " + this.getSex() + "。");
	}
	
}
