import java.util.Scanner;

public class GoodsClass {
	String code, name;
	int num, price, total;
		
	public GoodsClass() {
			}
	
	boolean input()
	{
		Scanner scan = new Scanner(System.in);
		System.out.print("상품코드 입력 => ");
		code = scan.next();
		if (code.equals("exit"))
			return true;
		System.out.print("상품명 입력 => ");
		name = scan.next();
		System.out.print("수량 입력 => ");
		num = scan.nextInt();
		System.out.print("단가 입력 => ");
		price = scan.nextInt();
		return false;
		
	}
	
	void process()
	{
		total = num * price;
	}
	
	void output()
	{
		System.out.printf("%4s  %6s  %4d    %7d  %8d\n", 
				code, name, num, price, total);
	}
}


