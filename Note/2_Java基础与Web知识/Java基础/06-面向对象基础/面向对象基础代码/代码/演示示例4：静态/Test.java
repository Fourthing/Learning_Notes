

/**
 * ���Ծ�̬������ʹ�á�

 */
public class Test {
	public static void main(String[] args) {
		Penguin pgn = null;
		pgn = new Penguin();
		System.out.println("��һ�������Ա���" + pgn.sex + "��");

		pgn = new Penguin();
		pgn.sex = Penguin.SEX_FEMALE;
		System.out.println("�ڶ��������Ա���" + pgn.sex + "��");

		pgn = new Penguin();
		pgn.sex = Penguin.SEX_MALE;
		System.out.println("�����������Ա���" + pgn.sex + "��");
	}
}
