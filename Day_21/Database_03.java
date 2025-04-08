package database;

import java.sql.*;

public class Database_03 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		DataBaseInfo info = 
			new DataBaseInfo("DataBaseInfo.properties");

		String url = info.readProperties(
				"DATABASE_URL");
		String id = info.readProperties(
				"DATABASE_ID");
		String pw = info.readProperties(
				"DATABASE_PASSWORD");
		
		String driver = info.readProperties("DATABASE_DRIVER");
		String query = info.readProperties("DATABASE_SELECT_QUERY");

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(
					url, id, pw);

			System.out.println("DB connection complete");

			stmt = conn.createStatement();		
			
			rs = stmt.executeQuery(query);
			
			// ResultSet 객체의 정보 추출
			ResultSetMetaData rsmd = rs.getMetaData();
			// getColumnCount 메소드 : ResultSet 객체가
			// 현재 보관하고 있는 컬럼의 개수를 리턴
			int nColumns = rsmd.getColumnCount();
			
			for( int i = 1 ; i <= nColumns ; i++ )
				// getColumnLabel 메소드 
				// ResultSet 객체가 보관하는 컬럼의 이름을 리턴
				// 인덱스는 1부터 시작
				System.out.printf(
					"%s\t", rsmd.getColumnLabel(i));
			
			System.out.println();			
			
			while (rs.next()) {	
				for( int i = 1 ; i <= nColumns ; i++ )
					System.out.printf("%s\t", 
							rs.getObject(i));
				
				System.out.println();
			}			
			
			// JDBC API 의 클래스들은 사용 후 반드시 close 메소드를 호출하여
			// 리소스를 해제해야만 합니다.
			// 하지만 try 블럭 내부에서 close 를 호출할 경우
			// 위의 라인에서 예외가 발생하면 실행되지 않기 때문에
			// finally 블럭에서 close 를 호출해야만 합니다.
			/*
			rs.close();
			stmt.close();
			conn.close();
			*/

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 각각의 JDBC API 클래스 객체의 리소스를 해제하기 위한 
			// close 메소드 호출
			// close 메소드의 호출 시 예외가 발생할 수 있기 때문에
			// try ~ catch 로 처리해야만 합니다.
			// 하지만, close 메소드의 호출 처리가 너무 복잡하기 때문에
			// 일반적으로 close 를 처리할 수 있는 공통 클래스를 선언하여 사용합니다.
			/*
			if( rs != null )
				try {
					rs.close();
				} catch (SQLException e) {					
					e.printStackTrace();
				}
			if( stmt != null )
				try {
					stmt.close();
				} catch (SQLException e) {					
					e.printStackTrace();
				}
			if( conn != null )
				try {
					conn.close();
				} catch (SQLException e) {					
					e.printStackTrace();
				}
			*/
			
			// close 처리를 위한 공통 클래스를 사용하여
			// JDBC 리소스의 close를 호출하는 코드
			JDBC_Util_Close.close(rs);
			JDBC_Util_Close.close(stmt);
			JDBC_Util_Close.close(conn);
		}
	}
}










