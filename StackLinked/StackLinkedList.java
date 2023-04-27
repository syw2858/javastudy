package StackLinked;

interface Stack {
	boolean isEmpty();
	void push(char item);
	char pop();
	void delete();
	char peek();
}

class StackNode {
	char data;
	StackNode link;
}

class LinkedStack implements Stack {
	private StackNode top;
		
	public LinkedStack () {
	}
	
	public boolean isEmpty() { //빈 스택인지 확인
		return (top == null);
	}
	public void push(char item) {
		StackNode newNode = new StackNode();
		newNode.data = item;
		newNode.link = top;
		top = newNode;
		System.out.println("Inserted Item : " + item);
	}
	public char pop() { //데이터 반환 후 삭제
		if(isEmpty()) {
			System.out.println("Deleting faiil! Array Stack is empty!!");
			return 0;
		}
		else {
			char item = top.data;
			top = top.link;
			return item;
		}
	}
	public void delete() { //값 반환 없이 삭제
		if(isEmpty()) {
			System.out.println("Deleting fail! Linked Stack is empty!!");
		}
		else {
			top = top.link;
		}
	}	
	public char peek() { //스택 포인터(top)위치 데이터 값만 반환
		if(isEmpty()) {
			System.out.println("Peeking fail! Linked Stack is empty!!");
			return 0;
		}
		else 
			return top.data;
	}
	public void printStack() {
		if(isEmpty())
			System.out.println("Linked Stack is empty!! %n %n");
		else {
			StackNode temp = top;
			System.out.println("Linked Stack>> ");
			while(temp != null) {
				System.out.printf("%c ", temp.data);
				temp = temp.link;
			}
			System.out.println();
		}
	}
}

public class StackLinkedList {
	public static void main(String args[]) {
		char deletedItem;
		LinkedStack LS = new LinkedStack();
		
		LS.push('A');
		LS.printStack();
		
		LS.push('B');
		LS.printStack();
		
		LS.push('C');
		LS.printStack();
		
		deletedItem = LS.pop();
		if(deletedItem != 0)
			System.out.println("deleted Item : " + deletedItem);
		LS.printStack();
		System.out.println("peek : " + LS.peek());
	}
}
