package jdbc;

// JDBC 드라이버 클래스를 로드하기 위한 클래스의 선언
// 서버와 클라이언트의 실행 시 최초에 단 한번만 실행됩니다.
public class JDBC_Util_LoadJDBCDriver {
	public static void loadJDBCDriver() {	
		JDBC_Util_Connection_Info info = 
				new JDBC_Util_Connection_Info("DataBaseInfo.properties");
		String strJDBCDriverClassName = 
				info.readProperties("DATABASE_DRIVER");
		try {
			Class.forName(strJDBCDriverClassName);
		} catch (ClassNotFoundException e) {			
			System.out.println("JDBC 클래스 로딩 실패");
		}
	}
}
