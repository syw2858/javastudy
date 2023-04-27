import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCExample1 { //이 프로젝트 내에서 작업할 때는 라이브러리 내용 연결 더 안해도 됨
	public static void main(String args[]) {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //드라이브 로드
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees",
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
