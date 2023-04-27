package QueueDouble;

class DQNode {
	char data;
	DQNode rlink;
	DQNode llink;
}

class QueueNode {
	DQNode front;
	DQNode rear;
	public QueueNode() {
		front = null;
		rear = null;
	}
	public boolean isEmpty() {
		return (front == null);
	}
	public void insertFront(char item) { 
		DQNode newNode = new DQNode();
		newNode.data = item;
		if(isEmpty()) {
			front = newNode;
			rear = newNode;
			newNode.rlink = null;
			newNode.llink = null;
		}
		else {
			front.llink = newNode;
			newNode.rlink = front;
			front = newNode;
		}
		System.out.println("Front Inserted Item : " + item);
	}
	public void insertRear(char item) {
		DQNode newNode = new DQNode();
		newNode.data = item;
		if(isEmpty()) {
			front = newNode;
			rear = newNode;
			newNode.rlink = null;
			newNode.llink = null;
		}
		else { 
			rear.rlink = newNode;
			newNode.rlink = null;
			newNode.llink = rear;
			rear = newNode;
		}
		System.out.println("Rear Inserted Item : " + item);
	}
	public char deleteFront() { //반환값 존재
		if(isEmpty()) {
			System.out.println("Front Deleting fail! DQueue is empty!!");
			return 0;
		}
		else {
			char item = front.data;
			if (front.rlink == null) { //데이터가 하나
				front = null;
				rear = null;
			}
			else {
				front = front.rlink;
				front.llink = null;
			}
			return item;
		}
	}
	public char deleteRear() {
		if(isEmpty()) {
			System.out.println("Rear Deleting fail! DQueue is empty!!");
			return 0;
		}
		else {
			char item = rear.data;
			if(rear.llink == null) {
				rear = null;
				front = null;
			}
			else {
				rear = rear.llink;
				rear.rlink = null;
			}
			return item;
		}
	}
	public void removeFront() { //반환값없음
		if(isEmpty()) {
			System.out.println("Front Removing fail! DQueue is empty!!");
		}
		else {
			if(front.rlink == null) {
				front = null;
				rear = null;
			}
			else {
				front = front.rlink;
				front.llink = null;
			}
		}
	}
	public void removeRear() {
		if(isEmpty()) {
			System.out.println("Rear Removing fail! DQueue is empty!!");
		}
		else {
			if(front.llink == null) {
				rear = null;
				front = null;
			}
			else {
				rear = rear.llink;
				rear.rlink = null;
			}
		}
	}
	public char peekFront() {
		if(isEmpty()) {
			System.out.println("Front Peeking fail! DQueue is empty!!");
			return 0;
		}
		else 
			return front.data;
	}
	public char peekRear() {
		if(isEmpty()) {
			System.out.println("Rear Peeking fail! DQueue is empty!!");
			return 0;
		}
		else 
			return rear.data;
	}
	public void printQueue() {
		if(isEmpty())
			System.out.printf("DQueue is empty!! %n %n");
		else {
			DQNode temp = front;
			System.out.printf("DQueue>> ");
			while(temp != null) {
				System.out.printf("%c ", temp.data);
				temp = temp.rlink;
			}
			System.out.println();
			System.out.println();
		}
	}
}

public class ex08 {
	public static void main(String args[]) {
		char deletedItem;
		QueueNode DQ = new QueueNode();
		
		DQ.insertFront('A');
		DQ.printQueue();
		
		DQ.insertFront('B');
		DQ.printQueue();
		
		DQ.insertRear('C');
		DQ.printQueue();
		
		deletedItem = DQ.deleteRear();
		if(deletedItem != 0)
			System.out.println("Rear deleted Item : " + deletedItem);
		DQ.printQueue();
		
		DQ.insertRear('D');
		DQ.printQueue();
		
		DQ.insertFront('E');
		DQ.printQueue();
		
		DQ.insertFront('F');
		DQ.printQueue();
	}
}
