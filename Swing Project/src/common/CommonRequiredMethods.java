package common;

import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JFrame;

import jdbc.JDBC_Util_Close;
import jdbc.JDBC_Util_Connection;
import jdbc.dao.Data_File_InfoDAO;
import jdbc.dao.MemberDAO;
import jdbc.dao.Message_InfoDAO;
import jdbc.model.Data_File_Info;
import jdbc.model.Member;
import jdbc.model.Message_Info;

public interface CommonRequiredMethods {	
	public abstract JFrame getInstance();
	public abstract String getServerIP();
	public abstract String getLoginID();	
	public abstract String getSaveDirPath();
	public abstract String getDownloadDirPath();
	
	public abstract void setMemberListTable();	
	public abstract void setMemberFileDataTable(String member_id);	
	public abstract void setSharedFileDataTable(String member_id);	
	public abstract void setMessageListTable(String r_member_id);
}
