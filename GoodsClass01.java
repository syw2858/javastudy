
public class GoodsClass01 {
	static int MAX = 100; //100만큼의 공간을 내줘야 한다는 단점, 나중에 arraylist 
	
	public static void main(String[] args) {
		GoodsClass obj[] = new GoodsClass[MAX];
		int cnt = 0;
		
		cnt = input_goods(obj);
		output_goods(obj, cnt);
		
	}
	
	static int input_goods(GoodsClass obj[])
	{ 	int i, cnt=0;
		for(i=0; i<MAX; i++) {
			obj[i] = new GoodsClass();
			if (obj[i].input())
				break;
			obj[i].process();
			cnt++;
			System.out.println();
		}
		return cnt;
	}
				
	static void output_goods(GoodsClass obj[], int cnt) {
		System.out.println("\n *** 상품정보 *** ");
		System.out.println("==============================");
		System.out.println("상품코드    상품명    수량    단가   금액");
		for (int i=0; i<cnt; i++) 
			obj[i].output();;
		System.out.println("==============================");
	}
}


