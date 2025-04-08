package database;

public class Database_00_DriverLoad {
	public static void main(String[] args) {		
		
		try {
			
			//Class.forName("com.mysql.jdbc.Driver");
			//System.out.println("MySQL JDBC 드라이버 클래스를 로딩했습니다.");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Oracle JDBC 드라이버 클래스를 로딩했습니다.");			
			
		} catch( ClassNotFoundException e ) {
			System.out.println("JDBC 드라이버 클래스를 찾을 수 없습니다.");
		}
		
	}
}
