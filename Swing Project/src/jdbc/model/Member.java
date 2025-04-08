package jdbc.model;

import java.io.Serializable;

public class Member  implements Serializable {
	private String member_id;
	private String password;
	private String name;
	private String tel;
	private boolean login_status;
	
	public Member(){}
	public Member(String member_id, String password, String name, String tel, boolean login_status) {		
		this.member_id = member_id;
		this.password = password;
		this.name = name;
		this.tel = tel;
		this.login_status = login_status;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public boolean getLogin_status() {
		return login_status;
	}
	public void setLogin_status(boolean login_status) {
		this.login_status = login_status;
	}
		
	public boolean equals(Object obj) {
		if( !(obj instanceof Member) )
			return false;
		
		Member target = (Member)obj;
		return this.member_id.equals(target.member_id);
	}		
}
