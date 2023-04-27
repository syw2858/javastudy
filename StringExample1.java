public class StringExample1 {
	public static void main(String args[]) {
		String str = "자바 커피";
		int len = str.length(); // length 메소드 호출 문자열의 길이를 구함
		for (int cnt = 0; cnt < len; cnt++) {
			char ch = str.charAt(cnt); // charAt 메소드 호출 인덱스 위치에 있는 문자값 반환
			System.out.println(ch);
		}
	}
}
