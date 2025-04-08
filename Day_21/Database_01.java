package database;
//데이터 베이스를 제어하는 쿼리문을 지원할 수 있는 API 패키지
import java.sql.*;
public class Database_01 {

	public static void main(String[] args) {
		// Connection 클래스
		// 데이터 베이스의 연결을 위해 사용하는 클래스
		Connection conn = null;
		// 쿼리 문자열을 보관하고, 데이터베이스에 전달하는 클래스
		Statement stmt = null;
		// 쿼리의 결과(Select 문)를 받아오는 클래스
		ResultSet rs = null;
		// 쿼리의 결과에 대한 컬럼 데이터를 받아올 수 있는 클래스
		ResultSetMetaData rsmd = null;
		// JDBC : Java DataBase Connector
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		// "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		// String url = "jdbc:mysql://localhost:3306/sakila";
		String id = "scott";
		String pw = "tiger";

		try {
			// 동적 클래스 로딩 메소드
			// 자바의 기본 패키지외에 외부 패키지내부에 포함된
			// 클래스를 사용하기 위해 사용하는 방법
			// Class.forName("클래스의이름(패키지명포함)");
			// forName이 실행되면 해당 클래스 내부의 STATIC
			// 멤버/메소드/블럭이 자동 로딩/실행됩니다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// DriverManager
			// 접속하고자 하는 데이터베이스의 URL, ID, PASSWORD
			// 정보를 사용해 커넥션을 얻어오는 클래스
			conn = DriverManager.getConnection(url, id, pw);

			System.out.println("DB connection complete");

			// 쿼리를 실행할 수 있는 객체 생성
			stmt = conn.createStatement();
			// Statement.executeQuery 메소드
			// Select 문을 처리하기 위한 메소드
			// 정상적으로 실행된다면, 처리된 결과를 테이블의 형태의
			// ResultSet 객체로 생성하여 반환합니다.
			rs = stmt.executeQuery(
					"select * from EMP Order by EMPNO");

			rsmd = rs.getMetaData();
			// 컬럼의 수
			int columnCnt = rsmd.getColumnCount();
			for (int i = 1; i <= columnCnt; i++) {
				// 컬럼명 출력
				System.out.printf("%8s ", rsmd.getColumnName(i));
			}
			System.out.println();
			
			// ResultSet 객체의 내용을 순회하는 방법
			while (rs.next()) {
				int empno = rs.getInt(1);
				String ename = rs.getString(2);
				String job = rs.getString(3);
				String mgr = rs.getString(4);
				String hiredate = rs.getString(5);
				int sal = rs.getInt(6);
				double domm = rs.getDouble(7);
				int deptno = rs.getInt(8);
				System.out.printf("%8d %8s %8s %8s %8s %8d, %.2f, %8d\n", 
						empno, ename, job, mgr, 
						hiredate, sal, domm, deptno);
			}
			// 객체의 연결 종료
			rs.close();
			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
