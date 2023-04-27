package ex05;

import java.util.Scanner;

public class Ex5_2 {
	static Scanner in = new Scanner(System.in);
	public static void main(String args[]) {
		ArrayList arr = new ArrayList(); //성적 클래스의 배열을 다루기 위한 객체
		Sungjuk data;
		int menu;
		
		do {
			print_menu();
			System.out.printf("\n메뉴 선택 => ");
			menu = in.nextInt();
			
			if (menu == 5)
			{
				System.out.printf("\n프로그램 종료...\n");
				break;
			}
			switch (menu)
			{
			case 1:
				System.out.println();
				data = new Sungjuk();
				System.out.print("번호 입력 => ");
				data.setBunho(in.nextInt());
				System.out.print("이름 입력 => ");
				data.setIrum(in.next());
				System.out.print("점수 입력 => ");
				data.setJumsu(in.nextInt());
				arr.insertLastNode(data); 
				break;
			case 2:
				arr.printList();
				break;
			case 3:
				System.out.println();
				data = new Sungjuk();
				System.out.print("검색할 번호 입력 => ");
				data.setBunho(in.nextInt());
				arr.searchNode(data);
				break;
			case 4:
				System.out.println();
				data = new Sungjuk();
				System.out.print("삭제할 번호 입력 => ");
				data.setBunho(in.nextInt());
				arr.deleteNode(data);
				break;
			default:
				System.out.printf("\n메뉴를 다시 입력하세요!!!\n");
				break;
			}
			
		}while(true);
	}
	
	static void print_menu()
	{
		System.out.printf("\n*** 메뉴 ***\n");
		System.out.printf("1. 데이터 입력\n");
		System.out.printf("2. 데이터 출력\n");
		System.out.printf("3. 데이터 검색\n");
		System.out.printf("4. 데이터 삭제\n");
		System.out.printf("5. 프로그램 종료\n");
	}
	
}
class ArrayList {
	static int MAX = 10; //max는 배열크기
	static int cnt = 0; //성적 개수가 추가될 때 마다 카운트
	Sungjuk arr[];
	
	ArrayList () {
		this.arr = new Sungjuk[MAX];
	}
	public void insertLastNode(Sungjuk data) {
		if(this.cnt == MAX) {
			System.out.println("\n메모리 풀(full)!!!\n");
			return;
		}
		this.arr[this.cnt++] = data;
		System.out.println("\n삽입 성공!!!\n");
	}
	public void printList() { 
		if(this.arr.length == 0) {
			System.out.println("\n출력할 데이터가 없음!!!\n");
			return;
		}
		System.out.println();
		System.out.println("번호	이름	점수");
		System.out.println("=========================");
		for(int i=0; i<this.cnt; i++) {
			System.out.printf("%3d %3s %4d %n", 
					this.arr[i].getBunho(), this.arr[i].getIrum(), this.arr[i].getJumsu());
			}
	}
	public void searchNode(Sungjuk data) {
		for(int i=0; i<this.cnt; i++) {
			if(data.getBunho() == this.arr[i].getBunho()) {
				System.out.println();
				System.out.println("번호	이름	점수");
				System.out.println("============================");
				System.out.printf("%3d %3s %4d %n", 
						this.arr[i].getBunho(), this.arr[i].getIrum(), this.arr[i].getJumsu());
				return;
			}
		}
		System.out.println("\n검색할 데이터가 없음!!!\n");
	}
	public void deleteNode(Sungjuk data) {
		for (int i=0; i<this.cnt; i++) {
			if (data.getBunho() == this.arr[i].getBunho()) {
				for (int k=i; k<this.cnt-1; k++) {
					this.arr[k] = this.arr[k+1];
				}
				this.cnt--;
				System.out.printf("\n삭제 성공!!!\n");
				return;
			}
		}
		System.out.printf("\n삭제할 데이터가 없음!!!\n");
	}
}

class Sungjuk {
	private int bunho;
	private String irum;
	private int jumsu;
	//private값을 읽고 쓸 수 있는 메소드가 필요한데 이를 get method, set method라고 한다
	//우클릭 source generate getters and setters
	//하단의 메소드들을 접근자라고 부름 - 메소드인데 필드에 접근하기 위한 용도
	public int getBunho() { //get은 값을 가져오는 기능
		return bunho;
	}
	public void setBunho(int bunho) { //set은 저장
		this.bunho = bunho;
	}
	public String getIrum() {
		return irum;
	}
	public void setIrum(String irum) {
		this.irum = irum;
	}
	public int getJumsu() {
		return jumsu;
	}
	public void setJumsu(int jumsu) {
		this.jumsu = jumsu;
	}
	
	
	
}