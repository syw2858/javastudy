import java.util.Scanner;

public class Gugudan {

		
	public static void main(String[] args) { 
		
		int res[];

		res = input_num();
		dan_title(res);
		dan_print(res);
	}

		static int[] input_num() {
			Scanner in = new Scanner(System.in);
			int num1, num2;
			int val[] = new int[2];

			System.out.print("첫번째 숫자 입력 => ");
			num1 = in.nextInt();
			System.out.print("두번째 숫자 입력 => ");
			num2 = in.nextInt();
		if(num1 < num2)
			{
				val[0] = num1;
				val[1] = num2;
			}
			else
			{
				val[0] = num2;
				val[1] = num1;
			}
			return val;}

		static void dan_title(int val[]) {
			for (int i=val[0]; i<=val[1]; i++)
		{
			System.out.print("***" + i + "단 ***    ");
		}
		System.out.println();
		}

		static void dan_print(int val[]) {
		for (int j=1; j<=9; j++)
		{
			for (int i=val[0]; i<=val[1]; i++)
			{
				System.out.printf("%d * %d = %2d   ", i, j, i*j);
			}

			System.out.println();
		}

	}
}