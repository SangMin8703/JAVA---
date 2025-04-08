package jdbc.dao;

import java.sql.*;
import java.util.*;

import jdbc.*;
import jdbc.model.*;

// DAO 패턴
// 데이터베이스에 접근하여 특정 테이블에 수행하는
// 쿼리들을 하나의 클래스에 정의하는 패턴 
// 모든 SQL 수행은 DAO 클래스에서만 실행됩니다.
public class MemberDAO {
	// 일반적으로 DAO 클래스의 객체는 싱글턴 패턴을 사용하여 구현합니다. 
	private static MemberDAO instance;	
	public static MemberDAO getInstance() {
		if( instance == null )
			instance = new MemberDAO();
		return instance;
	}	
	private MemberDAO(){}
	
	private Member convert(ResultSet rs) throws SQLException {		
		Member member = new Member();
		member.setMember_id(rs.getString("member_id"));
		member.setPassword(rs.getString("password"));
		member.setName(rs.getString("name"));
		member.setTel(rs.getString("tel"));
		member.setLogin_status(rs.getBoolean("login_status"));
		return member;
	}	
	
	public boolean isExist(Connection conn, String member_id) {
		/*
		boolean r = false;		
		// Statement 클래스 타입을 사용한 SQL 수행 시
		// 조건절에 대입되는 값을 처리하기 위해
		// 문자열 결합 연산을 사용합니다.
		// 문자열 결합을 사용한 where 절 정의 시 주의사항 !!!
		// - '' 를 생략하여 SQL을 작성 시 런타임 에러가 발생됩니다.
		String query = "select member_id from member where member_id = '" + member_id + "'";
		// Statement 클래스의 쿼리 수행 과정에는 매번 SQL을 컴파일 하는 과정이 실행됩니다.
		// 동일한 SQL 문을 수행하더라도, Statement 클래스의 객체를 사용하는 경우
		// 컴파일 과정이 매번 수행되기 때문에 성능 저하를 가져올 수 있습니다.		
		// 하지만, 특정 SQL을 한번만 수행하는 로직의 경우 성능에 큰 영향을 미치지 않기 때문에
		// 간단한 SQL 구문을 수행하는 경우 일반적으로 많이 사용됩니다.
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();			
			rs = stmt.executeQuery(query);
			
			if( rs.next() )
				r = true;
			else
				r = false;			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			JDBC_Util_Close.close(stmt);
			JDBC_Util_Close.close(rs);
		}
		return r;
		*/
		
		boolean r = false;		
		// 아래의 SQL 구문에 포함된 ? 기호의 자리는 
		// PreparedStatement 클래스의 메소드를 사용하여 값을 대입할 수 있습니다.
		String query = "select member_id from member where member_id = ?";
		// PreparedStatement 클래스는 Statement 클래스의 단점을 보완하기 위해 
		// 사용되는 클래스입니다.
		// PreparedStatement 클래스는 특정 SQL 구문이 반복되어 수행되는 경우
		// 최초에 한번만 SQL 구문이 컴파일 되고, 이후에는 컴파일 과정이 생략되어
		// Statement 클래스를 사용하는 경우보다 성능을 올릴수 있습니다.
		// 또한 SQL 구문에 많은 매개변수가 사용되는 경우 
		// 문자열 결합 연산이 아닌 메소드를 사용하여 간단하게 매개변수를 셋팅할 수 있습니다.
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			// 아래의 코드는 where member_id = ? 에 있는 ? 자리에
			// member_id 변수의 값을 문자열의 형태로 대입하는 코드입니다.
			// PreparedStatement 를 사용한 값의 대입은 '' 없이도 사용이 가능합니다.
			// 주의사항
			// PreparedStatement 를 사용하는 경우 문자열 기호를 정의하면 안됩니다.
			// '' 는 사용하면 안됨..
			pstmt.setString(1, member_id);
			rs = pstmt.executeQuery();
			
			if( rs.next() )
				r = true;
			else
				r = false;			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			JDBC_Util_Close.close(pstmt);
			JDBC_Util_Close.close(rs);
		}
		return r;		
	}	
	
	public Member select(Connection conn, String member_id) {
		Member member = null;		
		String query = "select * from member where member_id = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member_id);
			rs = pstmt.executeQuery();
			
			if( rs.next() )
				member = convert(rs);			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			JDBC_Util_Close.close(pstmt);
			JDBC_Util_Close.close(rs);
		}
		return member;
	}	
	
	public ArrayList<Member> select(Connection conn) {
		ArrayList<Member> list = new ArrayList<>();		
		String query = "select * from member";	
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			
			Member member;
			while( rs.next() ) {
				member = convert(rs);
				list.add(member);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			JDBC_Util_Close.close(stmt);
			JDBC_Util_Close.close(rs);
		}
		return list;
	}
	
	public int insert(Connection conn, Member member) {
		int rowCount = 0;		
		String query = "insert into member values (?, ?, ?, ?, ?)";	
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMember_id());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getTel());
			pstmt.setBoolean(5, member.getLogin_status());
			rowCount = pstmt.executeUpdate();	
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			JDBC_Util_Close.close(pstmt);			
		}
		return rowCount;
	}	
	
	public int update(Connection conn) {
		int rowCount = 0;		
		String query = "update member set login_status = false";
		Statement stmt = null;
		try {
			stmt = conn.createStatement();			
			rowCount = stmt.executeUpdate(query);	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC_Util_Close.close(stmt);			
		}
		return rowCount;
	}	
	
	public int update(Connection conn, Member member) {
		int rowCount = 0;		
		String query = "update member set login_status = ? where member_id = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setBoolean(1, member.getLogin_status());
			pstmt.setString(2, member.getMember_id());
			rowCount = pstmt.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC_Util_Close.close(pstmt);			
		}
		return rowCount;
	}	
	
	public int delete(Connection conn, Member member) {
		int rowCount = 0;		
		String query = "delete from member where member_id = ?";	
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMember_id());			
			rowCount = pstmt.executeUpdate();	
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			JDBC_Util_Close.close(pstmt);			
		}
		return rowCount;
	}	
}
