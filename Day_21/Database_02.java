package database;

import java.sql.*;

public class Database_02 {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;		
	
		String url = "jdbc:mysql://localhost:3306/sampledb";
		String id = "root";
		String pw = "SystemManager";
		
		try {		
			Class.forName("org.gjt.mm.mysql.Driver");
			conn = DriverManager.getConnection(url, id, pw);
			
			System.out.println("DB connection complete");
			
			stmt = conn.createStatement();
			
			String query = 
					"insert into student values ('1111111', '아무개1', '501호')";
			// Statement 클래스의 executeUpdate 메소드
			// SQL 쿼리 중 insert, update, delete 쿼리를 수행하기 위해
			// 사용되는 메소드
			// 해당 쿼리를 수행한 후, 적용된 레코드의 개수를 반환하는 메소드
			// executeUpdate 메소드의 리턴 값이 0 인경우
			// 해당 쿼리가 데이터베이스에 영향을 미치지 않았음을 확인할 수 있습니다.
			// (insert 의 경우 0의 값이 반환되면 입력이 되지 않음을 확인할 수 있습니다.)
			int r = stmt.executeUpdate(query);
			
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}






