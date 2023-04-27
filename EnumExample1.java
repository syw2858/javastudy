
public class EnumExample1 {

	public static void main(String[] args) {
		Day days[] = Day.values();//Day 열거 타입이 가지고 있는 변수를 호출 
		for (Day day : days)
		System.out.println(day);
	 }
}

