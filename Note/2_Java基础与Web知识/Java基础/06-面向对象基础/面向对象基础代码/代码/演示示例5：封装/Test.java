public class Test {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("��ӭ����������꣡");
		// 1�� �����������
		System.out.print("������Ҫ������������֣�");
		String name = input.next();
		// 2�� ѡ���������
		System.out.print("��ѡ��Ҫ�����ĳ������ͣ���1������ 2����죩");
		switch (input.nextInt()) {
		case 1:
			// ʡ��ѡ�񹷹�
			
			break;
		case 2:
			// ��������,ѡ������Ա�
			System.out.print("��ѡ�������Ա𣺣�1��Q�� 2��Q�ã�");
			int sexId=input.nextInt();	
			String sex="Q��";
			if(sexId==1)
				sex="Q��";
			System.out.print("���������Ľ���ֵ��1~100֮�䣩��");
			int health=input.nextInt();
			// ���������󲢸�ֵ
			Penguin png=new Penguin();
			png.setName(name);
			png.setSex(sex);
			png.setHealth(health);
			//Penguin png=new Penguin(name, health, sex);  //����ʹ���вι��췽����������
			// ��������Ϣ
			png.print();
			break;
		}
	}
}
