import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertExam {

	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/tabledb?serverTimezone=UTC";
		String id = "root";
		String pw = "123456";
		Connection con = null;
		Statement stmt = null;
				
		String sql = "Insert Into usertbl(userID, name, birthYear, addr, mobile1, mobile2, height, mDate) Values";
		String user_id, user_name, user_birthYear, user_addr, user_mobile1, user_mobile2, user_height, user_mDate;
	// String sql 과정이 너무 복잡, InsertExam01 참고
	try {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("usertbl 테이블에 값 추가하기 .....");
		System.out.print("아이디 입력 : ");
		user_id = br.readLine();
		System.out.print("이름 입력 : ");
		user_name = br.readLine();
		System.out.print("생일 입력 : ");
		user_birthYear = br.readLine();
		System.out.print("주소 입력 : ");
		user_addr = br.readLine();
		System.out.print("모바일1 입력 : ");
		user_mobile1 = br.readLine();
		System.out.print("모바일2 입력 : ");
		user_mobile2 = br.readLine();
		System.out.print("키 입력 : ");
		user_height = br.readLine();
		System.out.print("날짜 입력 : ");
		user_mDate = br.readLine();
		
		sql += "('" + user_id + "', '" + user_name + "', '" + user_birthYear + "', '" + user_addr
				+ "', '" + user_mobile1 + "', '" + user_mobile2 + "', '" + user_height + "', '" + user_mDate + "')";
		System.out.println(sql);
		//sql += 과정이 너무 복잡한 것이 단점, preparedstatement로 해주는 게 더 직관적, InsertExam01 참고
		Class.forName(driver);
		con = DriverManager.getConnection(url, id, pw);
		stmt = con.createStatement();
		stmt.executeUpdate(sql);
		System.out.println("데이터 삽입 성공!!!");
	}
	catch(Exception e) {
		System.out.println("데이터베이스 연결 실패! = "+e.getMessage());
	}
	finally {
		try {
			if(con != null) con.close();
			if(stmt != null) stmt.close();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	} 
}