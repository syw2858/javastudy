
public class SungjukClass01 {
	final static int MAX = 100;
	public static void main(String[] args) {
		SungjukClass obj[] = new SungjukClass[MAX];
		
		input_Sungjuk(obj);
		output_Sungjuk(obj);
	}
		
	static void input_Sungjuk(SungjukClass obj[]) {
		for(int i=0; i<MAX; i++)
		{
			obj[i] = new SungjukClass();
			if (obj[i].input())
				break;
			obj[i].process();
			SungjukClass.cnt++;
			System.out.println();
		}
	}
	
	static void output_Sungjuk(SungjukClass obj[]) {
		System.out.println("\n\t\t *** 성적표 ***");
		System.out.println("=================================");
		System.out.println("학번  이름  국어  영어  수학  총점  평균  등급");
		System.out.println("=================================");
		for (int i=0; i<SungjukClass.cnt; i++) {
			obj[i].output();
			SungjukClass.tot_avg += obj[i].avg;
		}
		System.out.println("=================================");
		System.out.printf("\t 학생수 = %d, 전체평균 = %5.2f\n",
				SungjukClass.cnt, SungjukClass.getTotalAvg());
	}
}


