package generic;

// 제네릭타입을 다수개 사용하는 경우
// , 를 사용하여 제네릭 타입을 나열합니다.
class Generic_02_Model<T1, T2> {
	private T1 data01;
	private T2 data02;
	
	public Generic_02_Model(T1 data01, T2 data02) {
		this.data01 = data01;
		this.data02 = data02;
	}
}
public class Generic_02 {
	public static void main(String[] args) {		
		Generic_02_Model<String, Integer> model;
		model = new Generic_02_Model<>("Generic", 1);
	}
}










