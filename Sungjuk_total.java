import java.util.Scanner; //패키지가 다른 곳에 있는 클래스를 사용하고 싶을 때

public class Sungjuk_total {
	static int MAX = 100; //필드생성, 클래스 내부를 다 이걸로 해야해!라는 전역변수 이러면 나중에 수정 용이
	public static void main(String[] args) {
			String hakbun[] = new String[MAX];
			String irum[] = new String[MAX];
			int kor[] = new int[MAX];
			int eng[] = new int[MAX];
			int math[] = new int[MAX];
			int tot[] = new int[MAX];
			double avg[] = new double[MAX];
			String grade[] = new String[MAX];
			int cnt = 0; //max최대치보다 입력이 종료되면 실제 입력 수를 카운트 하는 용도
			double avg_hap = 0; //전체 평균을 구하기 위한 용도
			
			cnt = input_sungjuk(hakbun,irum,kor, eng, math, tot,avg,grade);
			output_sungjuk(hakbun,irum,kor, eng, math, tot,avg,grade,cnt);
	}
			
	static int input_sungjuk(String hakbun[],String irum[],int kor[],int eng[],int math[],
			int tot[],double avg[],String grade[]) {
		int cnt=0;
		int i;
	
	Scanner scan = new Scanner(System.in); //입력개체 정의
	
	for (i=0; i<MAX; i++) {
		System.out.print("학번 입력 => ");
		hakbun[i] = scan.next();
		if (hakbun[i].equals("exit")) //string타입은 equals라는 메서드로 비교해야함
			break; //exit를 입력하기 전까지는 계속 입력 학번에 exit 입력되면 그만!
		System.out.print("이름 입력 => ");
		irum[i] = scan.next();
		//while(true) {  국어점수 입력할 때 문자가 섞여 들어가면 처리하는 방법
		// try {
		System.out.print("국어점수 입력 => ");
		kor[i] = scan.nextInt();
		// } catch(Exception e) {
		// System.out.println("국어점수 입력 오류!! => " +e.getMessage());
		//if(scan.hasNext()) hasNext는 다른 읽을 데이터가 남아있으면 다음꺼 읽어봐!
		//	scan.next(); 보통 버퍼에 데이터가 저장되는데 여기에 읽을게 있으면
		// continue; } hasNext가 읽어올 수 있다. 얘가 가지고 있을 수 있는 값은 true false
		// break; } scan이 1차로 읽고, 그 다음걸 hasNext가 읽어옴
		// hasNext에서 내용 확인 -> scan.next로 버퍼 내용 삭제 -> continue로 가서 다시 try 이동
		System.out.print("영어점수 입력 => ");
		eng[i] = scan.nextInt();
		System.out.print("수학점수 입력 => ");
		math[i] = scan.nextInt();
		
		tot[i] = kor[i] + eng[i] + math[i];
		avg[i] = tot[i] / 3.;
	
		switch ((int)avg[i] / 10) { //int형으로 바꿔서 평균점수의 앞자리 수를 구함
			case 10: //올백일때를 위해서 만들어 놨지만 표기값은 똑같이 수, 안쓰면 디폴트값
			case 9:
				grade[i] = "수";
				break;
			case 8:
				grade[i] = "우";
				break;
			case 7:
				grade[i] = "미";
				break;
			case 6:
				grade[i] = "양";
				break;
			default:
				grade[i] = "가";
				break;
		}
		cnt++; //정상적으로 입력이 다 끝나면 입력받은 게 몇 명인지 카운트
		System.out.println();
	}
	return cnt;
	}

	static void output_sungjuk(String hakbun[],String irum[],int kor[],int eng[],int math[],
			int tot[],double avg[],String grade[], int cnt) {
		int i;
		double avg_hap = 0;
	
		System.out.println("\n\t\t *** 성적표 ***");
		System.out.println("=====================================");
		System.out.println("학번  이름  국어  영어  수학  총점  평균  등급");
		System.out.println("=====================================");
		for (i=0; i<cnt; i++) {
			avg_hap += avg[i];
			System.out.printf("%4s %3s %3d %3d %3d %3d %5.2f %2s\n",
					hakbun[i], irum[i], kor[i], eng[i], math[i], tot[i], avg[i], grade[i]);
		}
		System.out.println("=====================================");
		System.out.printf("\t 학생수 = %d, 전체평균 = %5.2f\n", cnt, avg_hap / cnt);
	}
}
	
