package StackFix;

import java.util.Scanner;

interface Stack {
	boolean isEmpty();
	void push(int item);
	int pop();
	void delete();
	int peek();
}

class StackNode {
	int data;
	StackNode link;
}

class LinkedStack implements Stack {
	private StackNode top;
		
	public LinkedStack () {
	}
	
	public boolean isEmpty() { //빈 스택인지 확인
		return (top == null);
	}
	public void push(int item) {
		StackNode newNode = new StackNode();
		newNode.data = item;
		newNode.link = top;
		top = newNode;
//		System.out.println("Inserted Item : " + item);
	}
	public int pop() { //데이터 반환 후 삭제
		if(isEmpty()) {
			System.out.println("Deleting fail! Array Stack is empty!!");
			return 0;
		}
		else {
			int item = top.data;
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
	public int peek() { //스택 포인터(top)위치 데이터 값만 반환
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
class OptExp { 
	private String exp;
	private int expSize;
	private char testCh, openPair;
	
	public boolean testPair(String exp) { //괄호가 서로 맞는지 검사
		this.exp = exp;
		LinkedStack S = new LinkedStack();	
		expSize = this.exp.length();
		for(int i=0; i<expSize; i++) {
			testCh = this.exp.charAt(i);
			switch(testCh) {
			case '(' :
			case '{' :
			case '[' :
				S.push(testCh);
				break;
			case ')' :
			case '}' :
			case ']' :
				if(S.isEmpty())
					return false;
				else {
					openPair = (char)S.pop();
					if((openPair == '(' && testCh != ')') ||
					  (openPair == '{' && testCh != '}') ||
					  (openPair == '[' && testCh != ']'))
						return false;
					else
						break;
				}
			}
		}
		if (S.isEmpty())
			return true;
		else
			return false;
	}
	public String infixTopostfix(String infix) {
		char testCh;
		StringBuilder postfix = new StringBuilder(); //문자열
		LinkedStack S = new LinkedStack();
		for(int i=0; i<infix.length(); i++) { //길이값만큼 돌림
			testCh = infix.charAt(i);
			switch(testCh) { //숫자인지 확인
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				postfix.append(testCh); //숫자끼리 합쳐서 하나의 문자열로(ex.100)
				break;
			case '+':
			case '-':
			case '*':
			case '/':
				postfix.append(' '); //각 오퍼랜드의 값을 구분하기 위한 구분자로 사용
				S.push(testCh);
				break;
			case ')':
				postfix.append(' '); //각 오퍼랜드의 값을 구분하기 위한 구분자로 사용
				postfix.append((char)S.pop()); //pop한 결과물을 postfix에 연결
				break;
			default: //여는 괄호 만나면 아무것도 안함
			}
		}
		return postfix.toString();
	}
	public int evalPostfix(String postfix) {
		LinkedStack S = new LinkedStack();
		StringBuilder val = new StringBuilder();
		exp = postfix;
		int opr1, opr2, value;
		char testCh;
		for(int i=0; i<postfix.length(); i++) {
			testCh = exp.charAt(i);
			if(testCh != '+' && testCh != '-' && testCh != '*' && testCh != '/') {
				if(testCh >= '0' && testCh <= '9') { //testCh의 값이 정수 범위일 때 48('0'), 57('9')
					val.append(testCh); //수치문자를 val에 추가 저장
					continue; //두 자리 이상의 숫자 가능하도록 구현하기 위함, for문이랑 세트
				}
				if(val.length() != 0) { //testCh값이 +-*/와 0~9가 아닌 경우)공백문자)
					value = Integer.parseInt(val.toString()); //수치문자열을 숫자로 반환
					S.push(value); //수치문자열을 숫자로 변환한 값 스택에 저장
					val.delete(0, val.length()); //val문자열 객체를 초기화
				}
			}
			else {
				opr2 = S.pop();
				opr1 = S.pop();
				switch(testCh) {
				case '+' : S.push(opr1 + opr2); break;
				case '-' : S.push(opr1 - opr2); break;
				case '*' : S.push(opr1 * opr2); break;
				case '/' : S.push(opr1 / opr2); break;
				}
			}
		}
		return S.pop();	
	}
}
	
	

public class StackFixEx {
	static Scanner in = new Scanner(System.in);
	public static void main(String args[]) {
		OptExp opt = new OptExp();
		String exp = null;
		String postfix = null;
		//((100*2)+(100-99)-200), ((100*1)-90)		
		System.out.print("수식입력[ex:((3*5)-(6/2))] => ");
		exp = in.next();
		if(opt.testPair(exp))
			System.out.println("\n괄호 맞음!");
		else {
			System.out.println("괄호 틀림!!!");
			return;
		}	
		
		System.out.printf("\n후위표기식 : ");
		postfix = opt.infixTopostfix(exp);
		System.out.println(postfix);
		System.out.println("\n연산결과 = " + opt.evalPostfix(postfix));
	}
}

