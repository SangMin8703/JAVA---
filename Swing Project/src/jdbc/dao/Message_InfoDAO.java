package jdbc.dao;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import jdbc.*;
import jdbc.model.*;

public class Message_InfoDAO {
	private static Message_InfoDAO instance;
	public static Message_InfoDAO getInstance() {
		if( instance == null )
			instance = new Message_InfoDAO();
		return instance;
	}
	private Message_InfoDAO(){}
	
	private Message_Info convert(ResultSet rs) throws SQLException {		
		Message_Info info = new Message_Info();
		info.setMessage_id(rs.getInt("message_id"));
		info.setS_member_id(rs.getString("s_member_id"));
		info.setS_member_name(rs.getString("s_member_name"));		
		info.setR_member_id(rs.getString("r_member_id"));
		info.setR_member_name(rs.getString("r_member_name"));
		info.setContent(rs.getString("content"));	
		
		SimpleDateFormat transFormat = 
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strCreate_date = rs.getString("create_date");
		String strRead_date = rs.getString("read_date");
		Date create_date = null;
		Date read_date = null;
		try {
			create_date = transFormat.parse(strCreate_date);
			if( strRead_date != null )
				read_date = transFormat.parse(strRead_date);
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		info.setCreate_date(create_date);
		info.setRead_date(read_date);
		
		return info;
	}	
	
	public Message_Info select(Connection conn, int message_id) {
		Message_Info info = null;		
		String query = "select * from message_info where message_id = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, message_id);
			rs = pstmt.executeQuery();
			
			if( rs.next() )
				info = convert(rs);			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			JDBC_Util_Close.close(pstmt);
			JDBC_Util_Close.close(rs);
		}
		return info;
	}
	
	public ArrayList<Message_Info> select(Connection conn, String r_member_id) {
		ArrayList<Message_Info> list = new ArrayList<>();		
		String query = "select * from message_info where r_member_id = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, r_member_id);
			rs = pstmt.executeQuery();
						
			while( rs.next() )
				list.add(convert(rs));			
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			JDBC_Util_Close.close(pstmt);
			JDBC_Util_Close.close(rs);
		}
		return list;
	}
	
	public int insert(Connection conn, Message_Info info) {
		int rowCount = 0;		
		String query = 
			"insert into message (s_member_id, r_member_id, content, create_date) values (?, ?, ?, now())";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, info.getS_member_id());
			pstmt.setString(2, info.getR_member_id());
			pstmt.setString(3, info.getContent());
			rowCount = pstmt.executeUpdate();	
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			JDBC_Util_Close.close(pstmt);			
		}
		return rowCount;
	}	
	
	public int update(Connection conn, Message_Info info) {
		int rowCount = 0;		
		String query = "update message set read_date = now() where message_id = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, info.getMessage_id());
			rowCount = pstmt.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC_Util_Close.close(pstmt);			
		}
		return rowCount;
	}	
	
	public int delete(Connection conn, Message_Info info) {
		int rowCount = 0;		
		String query = "delete from Message where message_id = ?";	
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, info.getMessage_id());			
			rowCount = pstmt.executeUpdate();
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			JDBC_Util_Close.close(pstmt);			
		}
		return rowCount;
	}	
}
