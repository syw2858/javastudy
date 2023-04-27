package QueueEx;

interface Queue {
	boolean isEmpty();
	void enQueue(char item);
	char deQueue();
	void delete();
	char peek();
}

class ArrayQueue implements Queue { 
	private int front;
	private int rear;
	private int queueSize;
	private char itemArray[];
	
	public ArrayQueue(int queueSize) {
		front = rear = -1;
		this.queueSize = queueSize;
		itemArray = new char[this.queueSize];
	}
	public boolean isFull() {
		return rear == this.queueSize-1;
	}
	public boolean isEmpty() {
		return front == rear;
	}
	public void enQueue(char item) {
		if(isFull()) {
			System.out.println("Inserting fail! Array Queue is full!!");
		}
		else {
			itemArray[++rear] = item; //rear 1증가시키고 빈 자리에 item
			System.out.println("Insert Item : " + item);
		}
	}
	public char deQueue() {
		if(isEmpty()) {
			System.out.println("Deleting fail! Array Queue is empty!!");
			return 0;
		}
		else {
			return itemArray[++front];
		}
	}
	public void delete() {
		if(isEmpty()) {
			System.out.println("Deleting fail! Array Queue is empty!!");
		}
		else {
			++front; //front++; 같음 
		}
	}
	public char peek() {
		if(isEmpty()) {
			System.out.println("Peeking fail! Array Queue is empty!!");
			return 0;
		}
		else 
			return itemArray[front+1]; //값만 반환하니까 위치는 그대로 있어야 함
	}
	public void printQueue() { //큐 내용 순서대로 출력(배열의 내용을 순서대로 출력)
		if(isEmpty())
			System.out.printf("Array Queue is empty!! %n %n");
		else {
			System.out.printf("Array Queue>> ");
			for(int i=front+1; i<=rear; i++)
				System.out.printf("%c ", itemArray[i]);
			System.out.println();
			System.out.println();
		}
	}
}

public class ex_7 {
	public static void main(String args[]) {
		int queueSize = 3;
		char deletedItem;
		ArrayQueue Q = new ArrayQueue(queueSize);
		
		Q.enQueue('A');
		Q.printQueue();
		
		Q.enQueue('B');
		Q.printQueue();
		
		deletedItem = Q.deQueue();
		if(deletedItem != 0)
			System.out.println("deleted Item : " + deletedItem);
		Q.printQueue();
		
		Q.enQueue('C');
		Q.printQueue();
		
		deletedItem = Q.deQueue();
		if(deletedItem != 0)
			System.out.println("deleted Item : " + deletedItem);
		Q.printQueue();
		
		deletedItem = Q.deQueue();
		if(deletedItem != 0)
			System.out.println("deleted Item : " + deletedItem);
		Q.printQueue();
		
		deletedItem = Q.deQueue();
		if(deletedItem != 0)
			System.out.println("deleted Item : " + deletedItem);
		Q.printQueue();
	}
}
