import java.io.File;

public class ObjectExample1 {
	public static void main(String args[]) {
		 File file = new File("C:\\뻐꾸기"); //file객체 생성
		 String str = file.toString(); //file 객체에 대해 toString 메소드 호출
		 System.out.println(str);
	}
}
