package cn.pb.argsandreturn;

/**
 * ��Ʒ������
 */
public class Factory {
	public Goods getGoods(String str){
		if(str.equals("food"))
			return new Foods();
		else
			return new TVs();
	}
}
