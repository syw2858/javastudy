public class StringExample3 {
	public static void main(String args[]) {
		String str1 = new String("자바"); //객체의 주소를 비교
		String str2 = new String("자바");
		//if (str1.equals(str2))
		if (str1 == str2)
			System.out.println("같음");
		else
			System.out.println("다름");
	}
}
