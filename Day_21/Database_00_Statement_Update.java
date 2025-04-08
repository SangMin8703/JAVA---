package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database_00_Statement_Update {
	public static void main(String[] args) {		
		
		try {			
			
			/*
			// MySQL DB 접속
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("MySQL JDBC 드라이버 클래스를 로딩했습니다.");		
			
			String url = "jdbc:mysql://localhost:3306/sampledb";
			String id = "root";
			String password = "SystemManager";
			Connection conn = DriverManager.getConnection(url, id, password);
			System.out.println("MySQL JDBC 커넥션 객체를 생성했습니다.");
			
			Statement stmt = conn.createStatement();
			String query = 
			"insert into student values ('1111111', '아무개1', '501호')";
			int nResultCount = stmt.executeUpdate(query);
			System.out.printf("%d 개의 레코드가 적용되었습니다.\n", nResultCount);
			*/
			
			// Oracle DB 접속
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Oracle JDBC 드라이버 클래스를 로딩했습니다.");
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String password = "tiger";
			Connection conn = DriverManager.getConnection(url, id, password);
			System.out.println("Oracle JDBC 커넥션 객체를 생성했습니다.");
			
			Statement stmt = conn.createStatement();
			String query =
			//"insert into emp01 values (1111, '사원1', 3000.12)";
			//"insert into emp01 values (2222, '사원2', 3120.12)";
			//"update emp01 set sal = 3000 where empno = 2222";
			"delete from emp01";
			int nResultCount = stmt.executeUpdate(query);
			System.out.printf("%d 개의 레코드가 적용되었습니다.\n", nResultCount);
			
		} catch( ClassNotFoundException e ) {
			System.out.println("JDBC 드라이버 클래스를 찾을 수 없습니다.");
		} catch( SQLException e ) {
			System.out.println("JDBC 드라이버 커넥션 객체 생성에 실패했습니다.");
		}
		
	}
}







