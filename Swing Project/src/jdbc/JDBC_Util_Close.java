package jdbc;

import java.sql.*;

// JDBC API에서 제공되는 클래스의 객체들을 종료하기 위한 클래스 선언
// JDBC API 객체들은 종료시 예외를 발생시키기 때문에
// 코드의 중복이 빈번하게 발생됩니다.
// 객체의 close 메소드 호출 시, 코드의 중복을 제거하기 위한 클래스
public class JDBC_Util_Close {
	public static void close(Connection resource) {
		if( resource != null )
			try {
				resource.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
	}
	public static void close(Statement resource) {
		if( resource != null )
			try {
				resource.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
	}
	public static void close(ResultSet resource) {
		if( resource != null )
			try {
				resource.close();
			} catch (SQLException e) {				
				e.printStackTrace();
			}
	}
}
 






