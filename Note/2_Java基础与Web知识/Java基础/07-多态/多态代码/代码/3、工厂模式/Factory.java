package cn.pb.argsandreturn;

/**
 * 商品工厂类
 */
public class Factory {
	public Goods getGoods(String str){
		if(str.equals("food"))
			return new Foods();
		else
			return new TVs();
	}
}
