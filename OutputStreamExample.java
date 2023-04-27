import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreamExample {
	public static void main(String args[]) {
		 FileOutputStream out = null;
		 try {
			 out = new FileOutputStream("output.dat"); 
			 byte arr[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
					 		10, 11, 12, 13, 14, 15, 16, 17, 18, 19 };
			 for (int cnt = 0; cnt < arr.length; cnt++)
				 out.write(arr[cnt]); 
		 }
		 catch (IOException ioe) {
			 System.out.println("파일로 출력할 수 없습니다.");
		 }
		 finally {
			 try {
				 out.close(); 
			 } 
			 catch (Exception e) {
			 }
		 }
	}
}
