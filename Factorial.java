import java.util.Scanner;

public class Factorial {
	
	public static void main(String args[]) {
		int num;
		int result;
		Scanner scan = new Scanner(System.in);
		System.out.print("숫자 입력 => ");
		num = scan.nextInt();
		result = 1;
		
		for (int i=num; i>0; i--) {
			result = result * i;
		}
		System.out.println(num + "! = " + result);
		
	}
}
