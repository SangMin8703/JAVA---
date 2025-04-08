class Access_B {
	// private 접근지정자가 사용된 멤버는
	// 해당 클래스의 내부에서만 사용이 가능한 멤버입니다.
	// 외부 접근을 허용하지 않음(클래스의 레퍼런스 변수를 사용한 접근을 차단)
	private int num;
	// public 접근지정자가 사용된 멤버는
	// 클래스의 내부, 외부에서 자유롭게 접근할 수 있습니다.
	// (클래스의 레퍼런스 변수를 사용하여 접근이 가능)
	public void setNum(int n) {
		// private 멤버는 동일한 클래스의 내부에서는 사용이 가능합니다.
		num = n;
	}
	public void printNum() {
		// private 멤버는 동일한 클래스의 내부에서는 사용이 가능합니다.
		System.out.printf("num = %d\n", num);
	}
}
public class Class_Access_02 {
	public static void main(String[] args) {
		Access_B access = new Access_B();		
		
		// private 접근지정자가 사용된 멤버필드 num은
		// 외부에서 접근할 수 없습니다.
		//access.num = 10;
		access.printNum();
		
		access.setNum(20);
		access.printNum();
	}
}


