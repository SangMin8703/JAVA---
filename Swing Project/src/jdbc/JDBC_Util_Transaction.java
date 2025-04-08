package jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBC_Util_Transaction {	
	public static boolean commit(Connection conn) {
		if( conn == null )
			return false;
		
		boolean r = true;		
		try {
			conn.commit();
		} catch (SQLException e) {
			r = false;
			e.printStackTrace();
		}		
		return r;
	}	
	public static boolean rollback(Connection conn) {
		if( conn == null )
			return false;
		
		boolean r = true;		
		try {
			conn.rollback();
		} catch (SQLException e) {
			r = false;
			e.printStackTrace();
		}		
		return r;
	}
}

