package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database_00_Connection {
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
			*/
			
			// Oracle DB 접속
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Oracle JDBC 드라이버 클래스를 로딩했습니다.");
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "scott";
			String password = "tiger";
			Connection conn = DriverManager.getConnection(url, id, password);
			System.out.println("Oracle JDBC 커넥션 객체를 생성했습니다.");
			
		} catch( ClassNotFoundException e ) {
			System.out.println("JDBC 드라이버 클래스를 찾을 수 없습니다.");
		} catch( SQLException e ) {
			System.out.println("JDBC 드라이버 커넥션 객체 생성에 실패했습니다.");
		}
		
	}
}







