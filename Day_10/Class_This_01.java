// this 키워드
// Java에서 생성되는 모든 객체들은
// 클래스의 멤버 필드만 개별적으로 생성되고,
// 멤버 메소드는 공유하는 형태를 취합니다.
// 이때, 멤버 메소드에서 각각의 객체가 가지고 있는
// 멤버 필드의 값을 제어하거나, 값을 추출하고 하는경우
// 참조값을 필요로 하게됩니다.
// 이런 이유로, 모든 멤버 메소드들은 숨겨진 매개변수를 사용하게 됩니다.
// 이 숨겨진 매개변수는 this 라는 이름으로 선언되게 됩니다.

// this 키워드가 사용되는 경우
// 1. 멤버 메소드에서 멤버 필드의 이름을 사용하는 경우
//  - 컴파일러에 의해서 자동으로 this.멤버필드 로 변환됩니다.
//  - 컴파일러에 의해서 자동으로 처리되는 경우
// 2. 멤버 메소드의 지역변수명과 멤버필드의 이름이 동일한 경우
//  - 개발자가 스스로 처리해야 되는 부분
// 3. 생성자 간의 호출이 필요한 경우
//  - 개발자가 스스로 처리해야 되는 부분

class T_1 {
	private int num;
	
	// setNum 메소드가 컴파일러에 의해서 변경된 모습
	// 현재 어떠한 객체가 setNum 메소드를 실행하고 있는지
	// 확인할 수 있는 this 매개변수가 선언됨
	// public void setNum(T_1 this, int n)
	public void setNum(int n) {
		
		// 멤버필드의 이름이 멤버 메소드에서 사용된 경우
		// this 키워드가 자동으로 앞에 위치하게 됩니다.
		//  - 컴파일러에 의해서 자동으로 처리됨
		
		// 현재 setNum 메소드를 실행하고 있는 객체의 참조값을
		// 사용하여 실제 객체의 num 변수에 n 의 값을 대입함 
		// this.num = n;
		num = n;
	}
	
	// printNum 메소드가 컴파일러에 의해서 변경된 모습
	// 현재 어떠한 객체가 printNum 메소드를 실행하고 있는지
	// 확인할 수 있는 this 매개변수가 선언됨
	// public void printNum(T_1 this)
	public void printNum() {
		
		// 멤버필드의 이름이 멤버 메소드에서 사용된 경우
		// this 키워드가 자동으로 앞에 위치하게 됩니다.
		//  - 컴파일러에 의해서 자동으로 처리됨
		
		// 현재 printNum 메소드를 실행하고 있는 객체의 참조값을
		// 사용하여 실제 객체의 num 변수의 값을 출력함 
		// System.out.printf("num = %d\n", this.num);
		System.out.printf("num = %d\n", num);
	}
}
public class Class_This_01 {
	public static void main(String[] args) {
		T_1 t1 = new T_1();
		T_1 t2 = new T_1();
		T_1 t3 = new T_1();
		
		t1.setNum(10);
		t2.setNum(20);
		t3.setNum(30);
		
		t1.printNum();
		t2.printNum();
		t3.printNum();
	}
}
