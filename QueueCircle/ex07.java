package QueueCircle;

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
		front = rear = 0;
		this.queueSize = queueSize;
		itemArray = new char[this.queueSize];
	}
	public boolean isFull() {
		return (rear+1) % this.queueSize == front;
	}
	public boolean isEmpty() {
		return front == rear;
	}
	public void enQueue(char item) {
		if(isFull()) {
			System.out.println("Inserting fail! Array Queue is full!!");
		}
		else {
			rear = (rear+1) % this.queueSize;
			itemArray[rear] = item; 
			System.out.println("Insert Item : " + item);
		}
	}
	public char deQueue() {
		if(isEmpty()) {
			System.out.println("Deleting fail! Array Queue is empty!!");
			return 0;
		}
		else {
			front = (front+1) % this.queueSize;
			return itemArray[front];
		}
	}
	public void delete() {
		if(isEmpty()) {
			System.out.println("Deleting fail! Array Queue is empty!!");
		}
		else {
			front = (front+1) % this.queueSize; 
		}
	}
	public char peek() {
		if(isEmpty()) {
			System.out.println("Peeking fail! Array Queue is empty!!");
			return 0;
		}
		else 
			return itemArray[(front+1) % this.queueSize]; 
	}
	public void printQueue() { //큐 내용 순서대로 출력(배열의 내용을 순서대로 출력)
		int num;
		num = rear - front;
		if(num < 0)
			num += this.queueSize;
		if(isEmpty())
			System.out.println("Array Circular Queue is empty!!");
		else {
			System.out.printf("Array Circular Queue>> ");
			for(int i=(front+1) % this.queueSize; i!=((rear+1) % this.queueSize); i=++i % this.queueSize)
				System.out.printf("\n데이터 수 = " + num);
			System.out.println();
			System.out.println();
		}
	}
}


public class ex07 {
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
