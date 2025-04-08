package jdbc.model;

import java.io.Serializable;
import java.util.Date;

public class Data_File_Info implements Serializable {
	private int data_file_id;
	private String member_id;
	private String member_name;
	private String file_name;
	private String file_path;
	private Date upload_date;
	private int download_count;
	
	public Data_File_Info(){}

	public Data_File_Info(int data_file_id, String member_id, String member_name, String file_name, String file_path,
			Date upload_date, int download_count) {		
		this.data_file_id = data_file_id;
		this.member_id = member_id;
		this.member_name = member_name;
		this.file_name = file_name;
		this.file_path = file_path;
		this.upload_date = upload_date;
		this.download_count = download_count;
	}

	public int getData_file_id() {
		return data_file_id;
	}

	public void setData_file_id(int data_file_id) {
		this.data_file_id = data_file_id;
	}

	public String getMember_id() {
		return member_id;
	}

	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}

	public String getMember_name() {
		return member_name;
	}

	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	public Date getUpload_date() {
		return upload_date;
	}

	public void setUpload_date(Date upload_date) {
		this.upload_date = upload_date;
	}

	public int getDownload_count() {
		return download_count;
	}

	public void setDownload_count(int download_count) {
		this.download_count = download_count;
	}
	
	public boolean equals(Object obj) {
		if( !(obj instanceof Data_File_Info) )
			return false;
		
		Data_File_Info target = (Data_File_Info)obj;
		return this.data_file_id == target.data_file_id;
	}
}
