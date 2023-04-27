import java.io.*;

public class SystemExample1 {
	public static void main(String args[]) {
		BufferedReader reader = new BufferedReader( 
				new InputStreamReader(System.in)); 
		try {
			String str = reader.readLine(); 
			System.out.println("입력된 문자열: " + str);
		}
		catch (IOException e) {
			System.out.println("키보드 입력 에러");
		}
	}
}
