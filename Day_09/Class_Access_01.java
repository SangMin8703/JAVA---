// 접근지정자
// 클래스, 멤버 필드, 멤버 메소드에 사용할 수 있는 키워드
// 접근지정자는 해당 클래스, 멤버들의 접근 범위을 지정하는 역할을 합니다.
// public / private

// public 접근지정자 : 클래스 또는 멤버 필드, 멤버 메소드를 어디어서나 접근할 수 있도록
//                  지정하는 키워드
// private 접근지정자 : 멤버 필드, 멤버 메소드를 해당 클래스 내부에서만 사용할 수 있도록
//                   지정하는 키워드

class Access_A {
	// public 접근지정자의 사용
	
	// public 접근 지정자가 사용된 멤버는 
	// 클래스 내부 그리고 외부에서 사용이 가능한 멤버입니다.
	public int num;
	
	public void setNum(int n) {
		num = n;
	}
	public void printNum() {
		System.out.printf("num = %d\n", num);
	}
}

public class Class_Access_01 {
	public static void main(String[] args) {
		Access_A access = new Access_A();		
		// public 접근지정자가 사용된 멤버는 클래스의 외부에서
		// 자유롭게 접근할 수 있습	니다.
		
		// 클래스의 외부에서 접근한다는 의미
		// -> 클래스의 레퍼런스 변수를 사용하여 접근하는 코드
		access.num = 10;
		access.printNum();
		
		access.setNum(20);
		access.printNum();
	}
}








