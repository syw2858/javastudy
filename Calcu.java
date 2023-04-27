import java.util.Scanner;
import java.util.StringTokenizer;

public class Calcu {
	static String token;
	
	public static void main(String[] args) {
		String str2 = null;
		int amount = 0;
		
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.print("수식 입력 => ");
			str2 = scan.next();
			StringTokenizer str = new StringTokenizer(str2, "+_*/", true);
			try {
				while(str.hasMoreTokens()) {
					token = str.nextToken();
					if(token.equals("+")) {
						token = str.nextToken();
						amount += Integer.parseInt(token);
					}
					else if(token.equals("-")) {
						token = str.nextToken();
						amount -= Integer.parseInt(token);
					}
					else if(token.equals("*")) {
						token = str.nextToken();
						amount *= Integer.parseInt(token);
					}
					else if(token.equals("/")) {
						token = str.nextToken();
						amount /= Integer.parseInt(token);
					}
					else
						amount = Integer.parseInt(token);
				}
					System.out.printf("%s = %d", str2, amount);
					break;
			}
			catch (Exception e) {
				System.out.println("수식 입력 오류!!!");
				System.out.println();
			}
		}	
	}		
}		
			
