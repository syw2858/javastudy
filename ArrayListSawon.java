import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListSawon {	
	public static void main(String args[]) {
		ArrayList<Sawon> list = new ArrayList<Sawon>();
		int menu;
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			print_menu();
			System.out.printf("\n메뉴 선택 => ");
			menu = scan.nextInt();
			System.out.println();
			
			if(menu == 6) {
				System.out.printf("\n프로그램 종료\n");
				break;
			}
			switch (menu){
			case 1:
				input_sawon(list);
				break;
			case 2:
				output_sawon(list);
				break;
			case 3:
				search_sawon(list);
				break;
			case 4:
				update_sawon(list);
				break;
			case 5:
				delete_sawon(list);
				break;
			default:
			}
		}
	}
	static void print_menu() {
		System.out.printf("\n***사원관리***\n");
		System.out.printf("1.사원정보 입력\n");
		System.out.printf("2.사원정보 출력\n");
		System.out.printf("3.사원정보 조회\n");
		System.out.printf("4.사원정보 수정\n");
		System.out.printf("5.사원정보 삭제\n");
		System.out.printf("6.프로그램 종료\n");
		System.out.println();
	}
	
	static void input_sawon(ArrayList<Sawon> list) {
		Sawon obj = new Sawon();
		obj.inputData();
		for (Sawon dat : list) {
			if (obj.irum.equals(dat.irum)) {
				System.out.println("\n사원번호 입력 오류(중복)!!!\n");
				return;
			}
		}
		list.add(obj);
		System.out.println("\n사원정보 입력 성공!!!\n");
	}
	static void output_sawon(ArrayList<Sawon> list) {
		if (list.size() == 0) {
			System.out.println("출력할 사원정보가 없습니다!!\n");
			return;
		}
		System.out.println("\t		*** 사원정보 ***");
		System.out.println("===============================");
		System.out.println("사원번호	부서명		이름		성별		이메일");
		System.out.println("================================");
		for (Sawon dat : list) {
			dat.outputData();
		}
		System.out.println("================================");
		System.out.printf("\t\t 총사원수 : %d\n\n", list.size());
		
		for (int i=0; i<list.size()-1; i++) { //이름 순으로 나열하기
			for(int j=i+1; j<list.size(); j++) {
				if (list.get(i).irum.compareTo(list.get(j).irum)>0) {
					Sawon obj = list.get(i);
					list.set(i, list.get(j));
					list.set(j, obj);
				}
			}
		}
	}
	static void search_sawon(ArrayList<Sawon> list) {
		Scanner scan = new Scanner(System.in);
		System.out.print("조회할 사원번호 입력 => ");
		String sabun = scan.next();
		
		for(Sawon dat : list) {
			if (sabun.equals(dat.sabun)) {
				System.out.println("\n사원번호	부서명		이름		성별		이메일");
				System.out.println("================================");
				dat.outputData();
				System.out.println("================================");
				return;
			}
		}
		System.out.println("\n조회할 사원번호 입력 오류!!!\n");
	}
	static void update_sawon(ArrayList<Sawon> list) {
		Scanner scan = new Scanner(System.in);
		System.out.print("수정할 사원번호 입력 => ");
		String sabun = scan.next();
		
		for(Sawon dat : list) {
			if (sabun.equals(dat.sabun)) {
				System.out.print("부서명 입력 => ");
				dat.deptname = scan.next();
				System.out.print("이름 입력 => ");
				dat.irum = scan.next();
				System.out.print("성별 입력 => ");
				dat.gender = scan.next();
				System.out.print("이메일 입력 => ");
				dat.email = scan.next();
				System.out.println("\n사원정보 수정 성공!!!\n");
				return;
			}
		}
		System.out.println("\n수정할 이름 입력 오류!!!\n");
	}
	static void delete_sawon(ArrayList<Sawon> list) {
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 사원번호 입력 => ");
		String sabun = scan.next();
		
		for(Sawon dat : list) {
			if (sabun.equals(dat.sabun)) {
				list.remove(dat);
				System.out.println("\n사원정보 삭제 성공!!\n");
				return;
			}
		}
		System.out.println("\n삭제할 사원번호 입력 오류!!\n");
	}
}

