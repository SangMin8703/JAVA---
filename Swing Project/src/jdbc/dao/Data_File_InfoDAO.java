package jdbc.dao;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import jdbc.*;
import jdbc.model.*;

public class Data_File_InfoDAO {
	private static Data_File_InfoDAO instance;
	public static Data_File_InfoDAO getInstance() {
		if( instance == null )
			instance = new Data_File_InfoDAO();
		return instance;
	}
	private Data_File_InfoDAO(){}
	
	private Data_File_Info convert(ResultSet rs) throws SQLException {		
		Data_File_Info info = new Data_File_Info();
		info.setData_file_id(rs.getInt("data_file_id"));
		info.setMember_id(rs.getString("member_id"));
		info.setMember_name(rs.getString("member_name"));
		info.setFile_name(rs.getString("file_name"));
		info.setFile_path(rs.getString("file_path"));
		
		SimpleDateFormat transFormat = 
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date upload_date = null;
		try {
			upload_date = transFormat.parse(rs.getString("upload_date"));
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		info.setUpload_date(upload_date);		
		info.setDownload_count(rs.getInt("download_count"));
		
		return info;
	}	
	
	public Data_File_Info select(Connection conn, int data_file_id) {
		Data_File_Info info = null;		
		String query = "select * from data_file_info where data_file_id = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, data_file_id);
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
	
	public ArrayList<Data_File_Info> select(Connection conn, String member_id) {
		ArrayList<Data_File_Info> list = new ArrayList<>();		
		String query = "select * from data_file_info where member_id = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member_id);
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
	
	public int insert(Connection conn, Data_File_Info info) {
		int rowCount = 0;		
		String query = 
			"insert into Data_File (member_id, file_name, file_path, upload_date) values (?, ?, ?, now())";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, info.getMember_id());
			pstmt.setString(2, info.getFile_name());
			pstmt.setString(3, info.getFile_path());
			rowCount = pstmt.executeUpdate();	
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			JDBC_Util_Close.close(pstmt);			
		}
		return rowCount;
	}	
	
	public int update(Connection conn, Data_File_Info info) {
		int rowCount = 0;		
		String query = "update Data_File set download_count = download_count + 1 where data_file_id = ?";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, info.getData_file_id());
			rowCount = pstmt.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBC_Util_Close.close(pstmt);			
		}
		return rowCount;
	}	
	
	public int delete(Connection conn, Data_File_Info info) {
		int rowCount = 0;		
		String query = "delete from Data_File where data_file_id = ?";	
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, info.getData_file_id());
			rowCount = pstmt.executeUpdate();
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			JDBC_Util_Close.close(pstmt);			
		}
		return rowCount;
	}	
}
