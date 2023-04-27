import java.sql.*;

public class JDBCConnect {
	public static void main(String args[]) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //드라이브 로드
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tabledb",
					"root", "123456"); //데이터베이스 연결
			System.out.println("데이터베이스에 접속했습니다.");
			conn.close(); //데이터베이스 연결 끊기
		}
		catch (ClassNotFoundException cnfe) {
			System.out.println("해당 클래스를 찾을 수 없습니다." + cnfe.getMessage());
		}
		catch (SQLException se) {
			System.out.println(se.getMessage());
		}
	}	
}
