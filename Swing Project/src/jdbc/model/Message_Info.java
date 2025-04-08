package jdbc.model;

import java.io.Serializable;
import java.util.Date;

public class Message_Info  implements Serializable {
	private int message_id;
	private String s_member_id;
	private String s_member_name;
	private String r_member_id;
	private String r_member_name;
	private String content;
	private Date create_date;
	private Date read_date;
	
	public Message_Info(){}

	public Message_Info(int message_id, String s_member_id, String s_member_name, String r_member_id,
			String r_member_name, String content, Date create_date, Date read_date) {		
		this.message_id = message_id;
		this.s_member_id = s_member_id;
		this.s_member_name = s_member_name;
		this.r_member_id = r_member_id;
		this.r_member_name = r_member_name;
		this.content = content;
		this.create_date = create_date;
		this.read_date = read_date;
	}

	public int getMessage_id() {
		return message_id;
	}

	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}

	public String getS_member_id() {
		return s_member_id;
	}

	public void setS_member_id(String s_member_id) {
		this.s_member_id = s_member_id;
	}

	public String getS_member_name() {
		return s_member_name;
	}

	public void setS_member_name(String s_member_name) {
		this.s_member_name = s_member_name;
	}

	public String getR_member_id() {
		return r_member_id;
	}

	public void setR_member_id(String r_member_id) {
		this.r_member_id = r_member_id;
	}

	public String getR_member_name() {
		return r_member_name;
	}

	public void setR_member_name(String r_member_name) {
		this.r_member_name = r_member_name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public Date getRead_date() {
		return read_date;
	}

	public void setRead_date(Date read_date) {
		this.read_date = read_date;
	}
	
	public boolean equals(Object obj) {
		if( !(obj instanceof Message_Info) )
			return false;
		
		Message_Info target = (Message_Info)obj;
		return this.message_id == target.message_id;
	}
}
