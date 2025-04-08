class T_2 {
	private int num;
	
	// 멤버 메소드의 지역변수 이름으로
	// 클래스의 멤버필드명과 동일한 이름을 사용할 수 있습니다.
	public void setNum(int num) {
		// 만약, 메소드의 지역변수 이름이
		// 멤버필드와 동일하다면
		// 컴파일러는 해당 이름의 앞에
		// this 키워드를 삽입하지 않습니다.
		
		// 아래의 코드는 지역변수 num 에
		// 지역변수 num 의 값을 대입하는 코드입니다.
		// (멤버필드 num 의 값은 변화가 없음)
		//num = num;
		
		// 멤버필드 num 변수에 지역변수 num의 값을 대입하기 위해서는
		// this 키워드를 사용하여, 명시적으로 멤버필드를 참조하도록 지정해야합니다.
		this.num = num;
	}
	
	public void printNum() {		
		System.out.printf("num = %d\n", num);
	}	
}
public class Class_This_02 {
	public static void main(String[] args) {
		T_2 t = new T_2();
		t.setNum(100);
		t.printNum();
	}
}
