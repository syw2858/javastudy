import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HashMapSawon {
	public static void main(String args[]) {
		HashMap<String, Sawon> hashmap = new HashMap<String, Sawon>();
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
				input_sawon(hashmap);
				break;
			case 2:
				output_sawon(hashmap);
				break;
			case 3:
				search_sawon(hashmap);
				break;
			case 4:
				update_sawon(hashmap);
				break;
			case 5:
				delete_sawon(hashmap);
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
	static void input_sawon(HashMap<String, Sawon> hashmap) {
		Sawon obj = new Sawon();
		obj.inputData();
		
		//if (hashmap.get(obj.sabun) != null) {
		if (hashmap.containsKey(obj.sabun)) {
			System.out.println("\n사원번호 입력 오류(중복)!!\n");
			return;
		}
		hashmap.put(obj.sabun, obj);
		System.out.println("\n사원정보 입력 성공!!\n");
	}
	static void output_sawon(HashMap<String, Sawon> hashmap) {
		//(1) keyset() 이용
//		Set<String> keyset = hashmap.keySet(); //hashmap에 존재하는 키 집합을 구함
//		if (keyset.size() == 0) {//if(hashmap.isEmpty())
//			System.out.println("출력할 사원정보가 없습니다!!\n");
//			return;
//		}
//		System.out.println("\t		*** 사원정보 ***");
//		System.out.println("===============================");
//		System.out.println("사원번호	부서명		이름		성별		이메일");
//		System.out.println("================================");
//		for (String sabun : keyset) {
//			Sawon obj = hashmap.get(sabun);
//			obj.outputData();
//		}
//		System.out.println("================================");
//		System.out.printf("\t\t 총사원수 : %d\n\n", hashmap.size());
		
		//(2)
//		Set<E> entryset = hashmap.entrySet(); //hashmap에 존재하는 키 집합을 구함
//		if (entryset.size() == 0) {//if(hashmap.isEmpty())
//			System.out.println("출력할 사원정보가 없습니다!!\n");
//			return;
//		}
//		System.out.println("\t		*** 사원정보 ***");
//		System.out.println("===============================");
//		System.out.println("사원번호	부서명		이름		성별		이메일");
//		System.out.println("================================");
//		Iterator it_entry = entryset.iterator();
//		while(it_entry.hasNext()) { //키와 값을 읽기 위해 Map.Entry로 캐스트 연산
//			Map.entry e = (Map.Entry) it_entry.next();
//			//e.getValue() : 데이터 값을 읽어옴, e.getKey() : 키 값을 읽어옴
//			//e.getValue()의 리턴 타입이 Object이므로 Sawon으로 캐스트 연산
//			Sawon obj = (Sawon)e.getValue();
//			obj.outputData();
//		}
//		System.out.println("================================");
//		System.out.printf("\t\t 총사원수 : %d\n\n", hashmap.size());
//		
		//(3)
		if (hashmap.size() == 0) {
			System.out.println("출력할 사원정보가 없습니다!!\n");
			return;
		}
		System.out.println("\t		*** 사원정보 ***");
		System.out.println("===============================");
		System.out.println("사원번호	부서명		이름		성별		이메일");
		System.out.println("================================");
		for (Sawon obj : hashmap.values()) { //value값만 가져오는 것
			obj.outputData();
		}
		System.out.println("================================");
		System.out.printf("\t\t 총사원수 : %d\n\n", hashmap.size());
	}	
		
	static void search_sawon(HashMap<String, Sawon> hashmap) {
		Scanner scan = new Scanner(System.in);
		System.out.print("조회할 사원번호 입력 => ");
		String sabun = scan.next();
		
		Sawon obj = hashmap.get(sabun);
		if (obj != null) {
			System.out.println("\n사원번호	부서명		이름		성별		이메일");
			System.out.println("================================");
			obj.outputData();
			System.out.println("================================");
			return;
		}
		System.out.println("\n조회할 사원번호 입력 오류!!!\n");
	}
	static void update_sawon(HashMap<String, Sawon> hashmap) {
		Scanner scan = new Scanner(System.in);
		System.out.print("수정할 사원번호 입력 => ");
		String sabun = scan.next();
		
		Sawon obj = hashmap.get(sabun);
		if (obj != null) {
			System.out.print("부서명 입력 => ");
			obj.deptname = scan.next();
			System.out.print("이름 입력 => ");
			obj.irum = scan.next();
			System.out.print("성별 입력 => ");
			obj.gender = scan.next();
			System.out.print("이메일 입력 => ");
			obj.email = scan.next();
			System.out.println("\n사원정보 수정 성공!!!\n");
			return;
		}
		System.out.println("\n수정할 이름 입력 오류!!!\n");
	}
	static void delete_sawon(HashMap<String, Sawon> hashmap) {
		Scanner scan = new Scanner(System.in);
		System.out.print("삭제할 사원번호 입력 => ");
		String sabun = scan.next();
		
		Sawon obj = hashmap.get(sabun);
		if(obj != null) {
			hashmap.remove(sabun);
			System.out.println("\n사원정보 삭제 성공!!\n");
			return;
		}
		System.out.println("\n삭제할 사원번호 입력 오류!!\n");
	}
}

