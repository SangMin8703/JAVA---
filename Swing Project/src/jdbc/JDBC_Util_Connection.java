package jdbc;

import java.sql.*;

public class JDBC_Util_Connection {
	// 데이터 베이스 접속을 위한 정보를 추출하기 위해 사용되는 클래스
	// 프로퍼티 객체를 사용하여 정보를 제공합니다.
	private static JDBC_Util_Connection_Info info = null;	
	
	public static Connection getConnection() {
		// getConnection 메소드가 처음 실행되는 경우
		// 프로퍼티 파일로부터 정보를 추출하기 위한 객체를 생성
		if( info == null )
			info = new JDBC_Util_Connection_Info("DataBaseInfo.properties");
		
		// 데이터 베이스 커넥션 생성을 위한 정보를 추출
		String url = info.readProperties(
				"DATABASE_URL");
		String id = info.readProperties(
				"DATABASE_ID");
		String pw = info.readProperties(
				"DATABASE_PASSWORD");
		
		// JDBC 커넥션 객체 생성 및 반환
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, id, pw);
		} catch (SQLException e) {
			System.out.println("JDBC 커넥션 생성 실패");
		}		
		return conn;
	}	
}
 






