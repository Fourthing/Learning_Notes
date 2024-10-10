

/**
 * 测试静态常量的使用。

 */
public class Test {
	public static void main(String[] args) {
		Penguin pgn = null;
		pgn = new Penguin();
		System.out.println("第一个企鹅的性别是" + pgn.sex + "。");

		pgn = new Penguin();
		pgn.sex = Penguin.SEX_FEMALE;
		System.out.println("第二个企鹅的性别是" + pgn.sex + "。");

		pgn = new Penguin();
		pgn.sex = Penguin.SEX_MALE;
		System.out.println("第三个企鹅的性别是" + pgn.sex + "。");
	}
}
