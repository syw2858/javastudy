import java.io.FileWriter;
import java.io.IOException;

public class WriterExample {
	public static void main(String args[]) {
		 FileWriter writer = null;
		 try {
	 		writer = new FileWriter("output.txt"); // 자동으로 파일을 만들어 준다.
	 		char arr[] = { '뇌', '를', ' ', '자', '극', '하', '는', ' ', 'J', 'a', 'v', 'a' };
			for (int cnt = 0; cnt < arr.length; cnt++)
				writer.write(arr[cnt]); 
		 }
		 catch (IOException ioe) {
			 System.out.println("파일로 출력할 수 없습니다.");
		 }
		 finally {
			 try {
				 writer.close(); 
			 } 
			 catch (Exception e) {
			 }
		 }
	}
}
