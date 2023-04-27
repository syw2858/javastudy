import java.util.LinkedList;

public class StackExample1 {
	public static void main(String args[]) {
		LinkedList<Integer> stack = new LinkedList<Integer>(); 
		stack.addLast(12); //push()
		stack.addLast(59);
		stack.addLast(7);
		System.out.println("stack.getLast() : " + stack.getLast()); //peek()
		while(!stack.isEmpty()) {
			Integer num = stack.removeLast(); //pop()
			System.out.println(num);
		}
	}
}
