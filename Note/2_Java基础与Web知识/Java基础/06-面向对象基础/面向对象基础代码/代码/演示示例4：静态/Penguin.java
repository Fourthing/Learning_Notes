
/**
 * ��������࣬ʹ�þ�̬������
 */
public class Penguin {
	String name = "������"; // �ǳ�
	int health = 100; // ����ֵ
	int love = 0; // ���ܶ�
	static final String SEX_MALE ="Q��";
	static final String SEX_FEMALE="Q��";	
	String sex = SEX_MALE; // �Ա�
	/**
	 * ���������Ϣ��
	 */
	public void print() {
		System.out.println("������԰ף�\n�ҵ����ֽ�" + this.name 
				+ "������ֵ��" + this.health 	+ "�������˵����ܶ���" 
				+ this.love + "���Ա��� " + this.sex + "��");
	}
}
