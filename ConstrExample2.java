
public class ConstrExample2 {

	public static void main(String[] args) {
		SubscriberInfo obj1, obj2; //subscriberInfo 참조해서 가져옴
		obj1 = new SubscriberInfo("연흥부", "poorman", "zebi");
		obj2 = new SubscriberInfo("연놀부", "richman", "money", "02-000-0000", "타워팰리스");
		printSubscriberInfo(obj1);
		printSubscriberInfo(obj2);
		SubscriberInfo obj3 = new SubscriberInfo();
		}
		static void printSubscriberInfo(SubscriberInfo obj) {
			System.out.println("이름:" + obj.name); 
			System.out.println("아이디:" + obj.id); 
			System.out.println("패스워드:" + obj.password); 
			System.out.println("전화번호:" + obj.phoneNo); 
			System.out.println("주소:" + obj.address); 
			System.out.println();
	}//객제는 new연산자와 함께 생성 다 끝나면 jvm에서 소멸
//지역변수는 메소드가 종료되면 소멸
}
