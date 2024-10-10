public class Test {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("欢迎您来到宠物店！");
		// 1、 输入宠物名称
		System.out.print("请输入要领养宠物的名字：");
		String name = input.next();
		// 2、 选择宠物类型
		System.out.print("请选择要领养的宠物类型：（1、狗狗 2、企鹅）");
		switch (input.nextInt()) {
		case 1:
			// 省略选择狗狗
			
			break;
		case 2:
			// 如果是企鹅,选择企鹅性别
			System.out.print("请选择企鹅的性别：（1、Q仔 2、Q妹）");
			int sexId=input.nextInt();	
			String sex="Q妹";
			if(sexId==1)
				sex="Q仔";
			System.out.print("请输入企鹅的健康值（1~100之间）：");
			int health=input.nextInt();
			// 创建企鹅对象并赋值
			Penguin png=new Penguin();
			png.setName(name);
			png.setSex(sex);
			png.setHealth(health);
			//Penguin png=new Penguin(name, health, sex);  //可以使用有参构造方法创建对象
			// 输出企鹅信息
			png.print();
			break;
		}
	}
}
