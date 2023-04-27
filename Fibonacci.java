import java.util.Scanner;

public class Fibonacci {
	
	public static void main(String args[]) {
		int n; 
		Scanner scan = new Scanner(System.in);
		System.out.print("정수 값 입력 => ");
		n = scan.nextInt();
		
		int num1, num2, res;
		num1 = 0;
		num2 = 1;
		res = 1;
		
		for(int i=0; i<n; i++) {
			System.out.print(res + " ");
			res = num1 + num2;
			num1=num2;
			num2=res;
		}
	}
}
