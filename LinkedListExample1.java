import java.util.LinkedList;

public class LinkedListExample1 {
	public static void main(String args[]) {
		LinkedList<String> list = new LinkedList<String>(); 
		list.add("포도"); 
		list.add("딸기"); 
		list.add("복숭아"); 
		int num = list.size();
//		for (int cnt = 0; cnt < num; cnt++) {
//			String str = list.get(cnt); //단점:하나를 찾기 위해 처음부터 탐색해야 함
//			System.out.println(str);
//		}
		for (String str : list)
			System.out.println(str); //순차리스트처럼 바로 찾을 수 있게 해줌
	}
}
