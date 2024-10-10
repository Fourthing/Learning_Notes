package cn.pb.argsandreturn;

public class Test {

	public static void main(String[] args) {
	/*	Goods good=new Goods();
		Foods food=new Foods();
		TVs tvs=new TVs();
		showPrice(good);
		showPrice(food);
		showPrice(tvs);*/
		Factory factory=new Factory();
		Goods good1=factory.getGoods("food");
		good1.price();
		
		Goods good2=factory.getGoods("tvs");
		good2.price();
	}
	
/*	static void showPrice(Goods good){
		good.price();
	}*/

}
