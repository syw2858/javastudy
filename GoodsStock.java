
public class GoodsStock { //Object 클래스 상속받아서 만들어짐
	String goodsCode;
	 int stockNum; 
	 GoodsStock() { //생성자1 2만 있으면 example의 new goodsstock 에러
		 
	 } //이렇게 동일한 이름의 생성자를 여러개 만드는 경우를 오버로딩(overloading)
	 GoodsStock(String code, int num) { //생성자 2 이 경우에는 생성자오버로딩
	 this.goodsCode = goodsCode; 
	 this.stockNum = stockNum; 
	 } 
	 public String toString() { 
		 String str = "상품코드:" + goodsCode + " 재고수량:" + stockNum; 
		 return str; 
	} 
	 
	 void addStock(int amount) {
	 stockNum += amount; 
	 }
	 
	 int subtractStock(int amount) {
		 if (stockNum < amount)
			 	return 0;
		 stockNum -= amount; 
		 return amount;
	 }

}
