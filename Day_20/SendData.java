package network;
import java.io.Serializable;
import java.util.ArrayList;
public class SendData implements Serializable {
	// dataType 이 1인 경우 문자열 데이터 전송
	// dataType 이 2인 접속자의 리스트를 수정
	private int dataType;
	private String msg;
	private ArrayList<String> list;	
	public SendData(String msg) {
		dataType = 1;
		this.msg = msg;
	}
	public SendData(ArrayList<String> list) {
		dataType = 2;
		this.list = list;
	}	
	public int getDataType() {
		return this.dataType;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getMsg() {
		return this.msg;
	}
	public ArrayList<String> getList() {
		return this.list;
	}
}










