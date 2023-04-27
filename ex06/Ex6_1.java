package ex06;

public class Ex6_1 {

	public static void main(String[] args) {
		LinkedList L = new LinkedList(); //head node는 null상태
		System.out.println("(1)공백 리스트에 노드 3개 삽입하기");
		L.insertLastNode("월");
		L.insertLastNode("수");
		L.insertLastNode("일");
		L.printList(); //출력
		
		System.out.println("(2)수 노드 뒤에 금 노드 삽입하기");
		ListNode pre = L.searchNode("수");
		if(pre == null)
			System.out.println("검색실패>>찾는 데이터가 없습니다.");
		else {
			L.insertMiddleNode(pre,"금");
			L.printList();
		}
		System.out.println("(3)리스트의 노드를 역순으로 바꾸기");
		L.reverseList();
		L.printList();
		
		System.out.println("(4)리스트의 마지막 노드 삭제하기");
		L.deleteLastNode();
		L.printList();
		
		System.out.println("(5)리스트의 중간 노드 삭제하기");
		L.deleteMiddleNode("금");
		L.printList();
	}
}

class LinkedList { 
	private ListNode head; //헤드 노드, 첫번째 노드의 주소 저장
	public LinkedList() { // head에 null값을 주기 위함
		head = null;
	}
	public void insertMiddleNode(ListNode pre, String data) { //중간 삽입
		ListNode newNode = new ListNode(data);
		newNode.link = pre.link;
		pre.link = newNode;
	}
	public void insertLastNode(String data) { //마지막 노드 추가
		ListNode newNode = new ListNode(data);
		if (head == null) {
			this.head = newNode;
		}
		else { //마지막 노드를 찾는 작업
			ListNode temp = head;
			while(temp.link != null) temp = temp.link;
			temp.link = newNode;
		}
	}
	public void deleteLastNode() { //마지막 노드 삭제, 연결을 끊어서 자바에서 삭제하게 만듦
		ListNode pre, temp;
		if(head == null) return;
		if(head.link == null) {
			head = null;
		}
		else {
			pre = head;
			temp = head.link;
			while(temp.link != null) {
				pre = temp;
				temp = temp.link;
			}
			pre.link = null;
		}
	}
	public void deleteMiddleNode(String data) { //중간 노드 삭제, 노드가 2개일 때 맨 앞의 노드를 삭제하는 것도 포함
		ListNode pre, temp; //pre는 선행노드, temp는 삭제할 노드
		if (head == null) return;
		if (head.link == null) {
			if (head.getData() != data)
				return;
			else
				head = null;
		}
		else {
			temp = head;
			if (temp.getData() != data) {
				do {
					pre = temp;
					temp = temp.link;
					if (temp == null)
						break;
				}while(temp.getData() != data);
				if (temp != null)
					pre.link = temp.link;
			}
			else {
				head = temp.link;
			}	
		}	
	}
	public ListNode searchNode(String data) { //node 찾아서 삽입하기 위한 과정
		ListNode temp = this.head;
		while(temp != null) { 
			if(data == temp.getData())  
				return temp; 
			else temp = temp.link;
		}
		return temp;
	}
	public void reverseList() { //역순으로 바꿔주기 위한 과정
		ListNode next = head;
		ListNode current = null;
		ListNode pre = null;
		while(next != null) {
			pre = current;
			current = next;
			next = next.link;
			current.link = pre;
		}
		head = current;
	}
	
	public void printList() { //head node부터 link가 null인 노드까지 출력
		ListNode temp = this.head; //head node
		System.out.printf("L = (");
		while(temp != null) {
			System.out.printf(temp.getData()); //temp가 null이 아니면 데이터 출력
			temp = temp.link;
			if(temp != null) { //링크가 null이 아니면 출력
				System.out.printf(",");
			}
		}
		System.out.println(")");
	}
}

class ListNode { //노드(Node) 구조
	private String data; //데이터는 직접 저장할 수 없게 하겠다
	public ListNode link; //ListNode의 주소
	
	public ListNode() { // 빈 노드
		this.data = null;
		this.link = null;
	}
	public ListNode(String data) { //노드에 데이터 추가
		this.data = data;
		this.link = null;
	}
	public ListNode(String data, ListNode link) { //링크와 노드를 전달받아 처리
		this.data = data;
		this.link = link;
	}
	public String getData() { //데이터를 직접 접근할 수 없기 때문에 getData를 이용해서 읽겠다
		return this.data;
	}
}
