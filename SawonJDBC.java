import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SawonJDBC {
	public static void main(String args[]) {
	Scanner scan = new Scanner(System.in);
	int menu;
	
	while(true) {
		print_menu();
		System.out.printf("\n메뉴 선택 => ");
		menu = scan.nextInt();
		System.out.println();
		
		if(menu == 6) {
			System.out.printf("\n프로그램 종료\n");
			break;
		}
		switch (menu){
		case 1:
			input_sawon();
			break;
		case 2:
			output_sawon();
			break;
		case 3:
			search_sawon();
			break;
		case 4:
			update_sawon();
			break;
		case 5:
			delete_sawon();
			break;
		default:
		}
	}
	}
	static void print_menu() {
	System.out.printf("\n***사원관리***\n");
	System.out.printf("1.사원정보 입력\n");
	System.out.printf("2.사원정보 출력\n");
	System.out.printf("3.사원정보 조회\n");
	System.out.printf("4.사원정보 수정\n");
	System.out.printf("5.사원정보 삭제\n");
	System.out.printf("6.프로그램 종료\n");
	System.out.println();
	}
	static Connection connectDB() {
		Connection con = null;
		try { 
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/tabledb";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, "root", "123456");
		}
		catch (Exception e) {
			System.out.println("데이터베이스 연결 실패!");
			e.printStackTrace();
		}
		return con;
	}
	static void input_sawon() {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		Sawon obj = new Sawon();
		
		obj.inputData();
		String sql = "Insert into Sawon values(?,?,?,?,?)";
		
		try {
			con = connectDB();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, obj.sabun);
			pstmt.setString(2, obj.deptname);
			pstmt.setString(3, obj.irum);
			pstmt.setString(4, obj.gender);
			pstmt.setString(5, obj.email);
			int res = pstmt.executeUpdate();
			if (res == 1)
				System.out.println("\n사원정보 입력 성공!!!\n");
			}
		catch(Exception e) {
			System.out.println("\n이미 입력된 사원입니다!!! = "+e.getMessage());
		}
		finally {
			try {
				if (pstmt != null) pstmt.close( );
				if (con != null) con.close( );
			}
			catch(Exception e) {
				System.out.println(e.getMessage( ));
			}
		}
	}
	static void output_sawon() {
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		String sql1 = "select count(*) from sawon";
		String sql2 = "select * from sawon order by sabun";
		
		try {
			Sawon obj = new Sawon();
			
			con = connectDB();
			pstmt1 = con.prepareStatement(sql1);
			rs1 = pstmt1.executeQuery();
			if (rs1.getInt(1) == 0)
				System.out.println("\n출력할 데이터가 없습니다!!!\n");
			else {
				pstmt2 = con.prepareStatement(sql2);
				rs2 = pstmt2.executeQuery();
				
				System.out.println();
				System.out.println("\t		*** 사원정보 ***");
				System.out.println("==========================================");
				System.out.println("사원번호	부서명		이름		성별		이메일	");
				System.out.println("==========================================");
				while(rs2.next()) {
					obj.sabun = rs2.getString("sabun");
					obj.deptname = rs2.getString("deptname");
					obj.irum = rs2.getString("irum");
					obj.gender = rs2.getString("gender");
					obj.email = rs2.getString("email");
					obj.outputData();
				}
				System.out.println("==========================================");
			}
		}
		catch(Exception e) {
			System.out.println("데이터베이스 연결 실패! = " + e.getMessage());
		}
		finally {
			try {
				if(rs1 != null) rs1.close();
				if(rs2 != null) rs2.close();
				if(pstmt1 != null) pstmt1.close();
				if(pstmt2 != null) pstmt2.close();
				if(con != null) con.close();
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	static void search_sawon() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from sawon where sabun = ?";
		
		try {
			Scanner scan = new Scanner(System.in);
			System.out.print("조회할 사원번호 입력 => ");
			String sabun = scan.next();
			
			con = connectDB();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sabun);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				System.out.println();
				System.out.println("사원번호 : " + rs.getString("sabun"));
				System.out.println("부서명 : " + rs.getString("deptname"));
				System.out.println("이름 : " + rs.getString("name"));
				System.out.println("성별 : " + rs.getString("gender"));
				System.out.println("이메일 : " + rs.getString("email") + "\n");
			}
			else {
				System.out.println("\n존재하지 않는 사원번호입니다!!!\n");
			}
		}	
		catch(Exception e) {
			System.out.println("데이터베이스 연결 실패! = "+e.getMessage());
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	static void update_sawon() {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "update sawon set deptname=?, email=? where sabun = ?";
		try {
			Scanner scan = new Scanner(System.in);
			Sawon obj = new Sawon();
			
			System.out.print("수정할 사원번호 입력 => ");
			obj.sabun = scan.next();
			System.out.print("부서명 입력 => ");
			obj.deptname = scan.next();
			System.out.print("이메일 입력 => ");
			obj.email = scan.next();
			
			con = connectDB();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, obj.deptname);
			pstmt.setString(2, obj.email);
			pstmt.setString(3, obj.sabun);
			int res = pstmt.executeUpdate();
			if (res == 1) {
				System.out.println("\n" + obj.sabun + "사원정보 수정 완료!!!\n");
			}
			else {
				System.out.println("\n존재하지 않는 사원번호 입니다!!!\n");
			}
		}
		catch (Exception e) {
			System.out.println("데이터베이스 연결 실패! = " +e.getMessage());
		}
		finally {
			try {
				if (pstmt != null) pstmt.close();
				if (con != null) con.close();
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	static void delete_sawon() {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = "delete from sawon where sabun=?";
		
		try {
			Scanner scan = new Scanner(System.in);
			System.out.print("삭제할 사원번호 입력 => ");
			String sabun = scan.next();
			
			con = connectDB();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,sabun);
			int res = pstmt.executeUpdate();
			if (res == 1) {
				System.out.println("\n" + sabun + "사원정보 삭제 완료!!!\n");
			}
			else {
				System.out.println("\n존재하지 않는 사원번호입니다!!!\n");
			}
		}
		catch(Exception e) {
			System.out.println("데이터베이스 연결 실패! = " +e.getMessage());
		}
		finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}	