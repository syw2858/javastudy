import java.util.StringTokenizer;

public class StringTokenizerExample3 {
	public static void main(String args[]) {
		StringTokenizer stok = new StringTokenizer("사과=10|초콜렛=3|샴페인=1", "=|", true); 
		while (stok.hasMoreTokens()) {
			String token = stok.nextToken();
			if (token.equals("="))
				System.out.print("\t"); //수평 탭 간격 이동
			else if (token.equals("|")) 
				System.out.print("\n"); //줄바꿈
			else
				System.out.print(token);
		}
	}
}
