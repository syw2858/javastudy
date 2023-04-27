import java.util.LinkedList;

public class QueueExample1 {
	public static void main(String args[]) {
		LinkedList<String> queue = new LinkedList<String>(); 
		queue.offer("토끼"); //데이터 삽입
		queue.offer("사슴"); 
		queue.offer("호랑이"); 
		System.out.println("queue.peek() : " + queue.peek()); //데이터 값 리턴
		while(!queue.isEmpty()) {
			String str = queue.poll(); //데이터 삭제
			System.out.println(str);
		}
	}
}
