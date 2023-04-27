import java.util.ArrayList;

public class ArrayListExample1 {
	public static void main(String args[]) {
		ArrayList<String> list = new ArrayList<String>(); 
		list.add("포도"); 
		list.add("딸기"); 
		list.add("복숭아"); 
		int num = list.size(); 
//		for (int cnt = 0; cnt < num; cnt++) {
//		String str = list.get(cnt); 
//		System.out.println(str);
//		}
		for (String str : list) { //향상된 for문, Collection 타입 객체
			System.out.println(str);
		}
	}
}
