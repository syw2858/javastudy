import java.util.GregorianCalendar;

public class ObjectExample5 {
	public static void main(String args[]) {
		 GregorianCalendar obj1 = new GregorianCalendar(2007, 0, 1); //똑같은 값을 갖는 두 객체 생성
		 GregorianCalendar obj2 = new GregorianCalendar(2007, 0, 1); //gregoriancalendar에 맞게 오버라이딩 한 경우
		 if (obj1.equals(obj2)) //두 객체의 값을 equals로 비교하여 출력
			 System.out.println("같음");
		 else
			 System.out.println("다름");
	}
}
