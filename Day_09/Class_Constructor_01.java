// 클래스의 객체 생성 과정
// 1. 해당 클래스의 멤버 필드가 메모리(HEAP)에 로딩
// 2. 객체를 생성할 때 사용한 생성자가 호출
// 3. 객체가 생성된 메모리의 참조값이 반환

// 생성자
// 클래스의 객체를 생성할 때, 초기화를 목적으로 작성되는 메소드
// 클래스의 생성자의 정의
// 사용방법
// 접근지정자 클래스명() {}

class Constructor_A {
	int num;
	
	// 클래스의 생성자 작성 규칙
	// 1. 클래스의 이름과 동일한 이름으로 메소드의 이름을 작성합니다.
	// 2. 리턴값의 타입을 작성하지 않습니다.
	// 3. 만약, 클래스의 생성자를 작성하지 않으면,
	//    자바 컴파일러는 디폴트 생성자를 자동으로 생성합니다.
	//    (디폴트 생성자 : 매개변수가 존재하지 않는 생성자, 메소드의 실행코드가 없습니다.)
	// EX) public Constructor_A(){}
	// 4. 클래스의 생성자를 통해서만 해당 클래스의 객체를 생성할 수 있습니다.
	//    (만약, 존재하지 않는 타입의 생성자를 사용하여 객체를 생성하려 할 경우 에러가 발생)
	public Constructor_A() {
		System.out.println("Constructor_A() 생성자 호출");
	}
}

public class Class_Constructor_01 {
	public static void main(String[] args) {		
		
		Constructor_A c = new Constructor_A();
		c.num = 10;
		System.out.printf("c.num = %d\n", c.num);
	}
}







