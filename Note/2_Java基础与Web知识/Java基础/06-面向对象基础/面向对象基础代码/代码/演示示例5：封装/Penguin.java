

/**
 * ��������࣬�����췽�����Ϸ���ֵ���ͻ����ʲô����أ�
 */
class Penguin {
	private String name =null; // �ǳ�
	private int health = 0; // ����ֵ
	private int love = 0; // ���ܶ�
	private String sex =null; // �Ա�

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
			System.out.println("����ֵӦ����0��100֮�䣬Ĭ��ֵΪ60��");
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
			System.out.println("���ܶ�Ӧ����0��100֮�䣬Ĭ��ֵΪ10��");
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
	 * ���������Ϣ��
	 */
	public void print() {
		System.out.println("������԰ף�\n�ҵ����ֽ�" + this.getName() 
				+ "������ֵ��" + this.getHealth()	+ "�������˵����ܶ���" 
				+ this.getLove() + "���ҵ��Ա��� " + this.getSex() + "��");
	}
	
}
