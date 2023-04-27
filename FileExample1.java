import java.io.File;
import java.util.GregorianCalendar;

public class FileExample1 {
	public static void main(String args[]) {
		 File file = new File("."); //여기의 .은 현재 폴더 
		 File arr[] = file.listFiles(); //listfiles는 파일을 읽어와서 배열 객체로
		 for (int cnt = 0; cnt < arr.length; cnt++) {
			 String name = arr[cnt].getName(); 
			 if (arr[cnt].isFile())//파일이냐
				 System.out.printf("%-25s %7d ", name, arr[cnt].length());
			 else
				 System.out.printf("%-25s <DIR> ", name);
			 long time = arr[cnt].lastModified(); 
			 GregorianCalendar calendar = new GregorianCalendar();
			 calendar.setTimeInMillis(time);
			 System.out.printf("%1$tF %1$tT %n", calendar);
		 }
	}
}
