package StackEx;

interface Stack {
	boolean isEmpty();
	void push(char item);
	char pop();
	void delete();
	char peek();
}
class ArrayStack implements Stack { //순차리스트 구조로 스택을 구현하는 예시
	private int top; //스택에서 데이터가 들어가고 나가는 위치(스택 포인터)
	private int stackSize; //스택의 크기
	private char itemArray[]; //스택으로 사용될 배열
	
	public ArrayStack(int stackSize) {
		top = -1; //초기값
		this.stackSize = stackSize;
		itemArray = new char[this.stackSize]; //문자데이터를 저장하는 스택
	}
	public boolean isEmpty() { //빈 스택인지 체크
		return (top == -1); //top이 -1(초기값)이면 스택이 비어있는 상태
	}
	public boolean isFull() { //가득찬 스택인지 체크
		return (top == this.stackSize-1);
	}
	public void push(char item) { //데이터 삽입
		if(isFull()) { //isFull을 검사해서 삽입할 수 있는 상태인지 먼저 검사
			System.out.println("Inserting fail! Array Stack is full!!");
		}
		else {
			itemArray[++top] = item;
			System.out.println("Insert Item : " + item);
		}
	}
	public char pop() { //데이터 삭제(데이터 반환 후)
		if(isEmpty()) {
			System.out.println("Deleting faiil! Array Stack is empty!!");
			return 0;
		}
		else {
			return itemArray[top--]; //삭제하고 난 다음에 탑이 하나 감소
		}
	}
	public void delete() { //데이터만 삭제(반환값X)
		if(isEmpty()) {
			System.out.println("Deleting faiil! Array Stack is empty!!");
		}
		else {
			top--; //반환값이 없으므로 탑만 감소
		}
	}
	public char peek() { //스택 포인터(top)위치 데이터 값만 반환
		if(isEmpty()) {
			System.out.println("Peeking fail! Array Stack is empty!!");
			return 0;
		}
		else
			return itemArray[top];
	}
	public void printStack() { //스택 내용을 배열에 저장된 순서대로 출력
		if(isEmpty())
			System.out.printf("Array Stack is empty!! %n %n");
		else {
			System.out.printf("Array Stack>> ");
			for(int i=0; i<=top; i++)
				System.out.printf("%c ", itemArray[i]);
			System.out.println();
			System.out.println();
		}
	}
}

public class ex7 {
	public static void main(String args[]) {
		int stackSize =5; 
		char deletedItem;
		ArrayStack S = new ArrayStack(stackSize); //스택 생성
		
		S.push('A');
		S.printStack();
		
		S.push('B');
		S.printStack();
		
		S.push('C');
		S.printStack();
		
		deletedItem = S.pop();
		if(deletedItem != 0)
			System.out.println("deleted Item : " + deletedItem);
		S.printStack();
		System.out.println("peek : " + S.peek());
	}
}
