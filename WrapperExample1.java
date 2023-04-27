
public class WrapperExample1 {
	public static void main(String args[]) { 
//		Integer obj1 = new Integer(12); 더 이상 지원되지 않음
//		Integer obj2 = new Integer(7); 
		Integer obj1 = 12;
//		Integer obj1 = Integer.parseInt("12");이렇게 사용하면 됨
		Integer obj2 = 7;
		int sum = obj1.intValue() + obj2.intValue();
		System.out.println(sum); 
		} 
}
