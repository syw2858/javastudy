
public class ObjectExample6 {
	public static void main(String args[]) {
		 Circle obj1 = new Circle(5); //object는 생성된 객체의 값이 아니라 주소로 비교하게 된다.
		 Circle obj2 = new Circle(5); //Circle에서 오버라이딩을 한 경우가 없기 때문에 값이 다름으로 출력됨.
		 if (obj1.equals(obj2))
			 System.out.println("같음");
		 else
			 System.out.println("다름");
	}
}
