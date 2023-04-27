import java.io.*;

public class ReaderExample {
	public static void main(String args[]) {
		 FileReader reader = null; 
		 try {
			 reader = new FileReader("poem.txt");
			 while (true) {
				 int data = reader.read();
				 if (data == -1)
					 break;
				 char ch = (char) data; //문자 형태로 다루기 위해서
				 System.out.print(ch);
			 }
		 }
		 catch (FileNotFoundException fnfe) {
			 System.out.println("파일이 존재하지 않습니다.");
		 }
		 catch (IOException ioe) {
			 System.out.println("파일을 읽을 수 없습니다.");
		 }
		 finally {
			 try { 
				 reader.close(); 
			 } 
			 catch (Exception e) { 
			 } 
		 }
	 }

}
