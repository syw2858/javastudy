import java.util.Scanner;

public class SungjukClass implements Cloneable{
	String hakbun, name;
	int kor, eng, math, total;
	double avg;
	String grade;
	
	static int cnt =0;
	static double tot_avg = 0.0;
	
	SungjukClass() {
	}
	public String toString() {
		String str = "학번: " + this.hakbun + "\n";
		str += "이름: " + this.name + "\n";
		str += "국어: " + this.kor +  "\n";
		str += "영어: " + this.eng + "\n";
		str += "수학: " + this.math + "\n";
		str += "총점: " + this.total + "\n";
		str += "평균: " + this.avg + "\n";
		str += "등급: " + this.grade + "\n";
  		return str;
	}
	public boolean equals(Object obj) {
		if (!(obj instanceof SungjukClass))
			return false;
		SungjukClass SungjukClass = (SungjukClass) obj;
		if(this.hakbun.equals(SungjukClass.hakbun) &&
		   this.name.equals(SungjukClass.name) &&
		   this.kor == SungjukClass.kor &&
		   this.eng == SungjukClass.eng &&
		   this.math == SungjukClass.math)
			return true;
		else
			return false;
	}
	public Object clone() {
		try {
			return super.clone();
		}
		catch (CloneNotSupportedException e) {
			return null;
		}
	}
	
	boolean input() {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("학번 입력 => ");
		hakbun = scan.next();
		if (hakbun.equals("exit"))
			return true;
		System.out.print("이름 입력 => ");
		name = scan.next();
		System.out.print("국어 입력 => ");
		kor = scan.nextInt();
		System.out.print("영어 입력 => ");
		eng = scan.nextInt();
		System.out.print("수학 입력 => ");
		math = scan.nextInt();
		return false;
		}
	
	void process() {
		
		total = kor + eng + math;
		avg = total / 3.;
		switch ((int)avg / 10) { //int형으로 바꿔서 평균점수의 앞자리 수를 구함
		case 10: //올백일때를 위해서 만들어 놨지만 표기값은 똑같이 수, 안쓰면 디폴트값
		case 9:
			grade = "수";
			break;
		case 8:
			grade = "우";
			break;
		case 7:
			grade = "미";
			break;
		case 6:
			grade = "양";
			break;
		default:
			grade = "가";
			break;
		}
	}
	
	void output() {
		System.out.printf("%4s %3s %3d %3d %3d %3d %5.2f %2s\n", 
				hakbun, name, kor, eng, math, total, avg, grade);
	}
	
	static double getTotalAvg() {
		return tot_avg / cnt;
	}
}

