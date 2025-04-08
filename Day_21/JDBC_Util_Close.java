package database;

import java.sql.*;

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
 






