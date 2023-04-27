import java.util.Scanner;

public class Primenumber {

	public static void main(String[] args) {
		int res[];  //메소드 내부는 다 지역변수, 전역변수는 class(필드) 밑에 작성
		
		res = input_num();
		int cnt_hap[] = process_primenumber(res);
		print_cnt(cnt_hap);
	}
		
	static int[] input_num() {
		int num1, num2;
		int val[] = new int[2];
		
		Scanner in = new Scanner(System.in);
				
		System.out.print("첫번째 숫자 => ");
		num1 = in.nextInt();
		System.out.print("두번째 숫자 => ");
		num2 = in.nextInt();
		System.out.println();
		
		if (num1 < num2)
		{
			val[0] = num1;
			val[1] = num2;
		}
		else
		{
			val[0] = num2;
			val[1] = num1;
		}
		return val;
	}
	
	static int[] process_primenumber(int val[]) {
		int i, j;
		int cnt_hap[] = new int[2];
		
		for (i=val[0]; i<=val[1]; i++)  // 소수를 계산하는 부분 시작
		{
			for (j=2; j<i; j++)
			{
				if (i%j == 0)
					break;  //i변수의 값은 더 이상 소수가 아님 
			}
			if (i == j)  //i변수의 값이 소수인 경우
			{
				System.out.printf("%5d", i);  //소수 출력
				cnt_hap[0]++;  //소수의 갯수 카운트
				if (cnt_hap[0] % 10 == 0)  //한 줄에 10개씩 출력
					System.out.println();
				cnt_hap[1] += i; //소수(i)의 합을 구함
			
			}
		}  //소수 계산 끝
		
		return cnt_hap;
	}
	static void print_cnt(int[] cnt_hap) {  //void는 리턴값이 없을 때
		if (cnt_hap[0] % 10 != 0)
			System.out.println();

		System.out.println("총소수의 갯수 = " + cnt_hap[0]);
		System.out.println("총소수 합 = " + cnt_hap[1]);
	}
		
}
	

