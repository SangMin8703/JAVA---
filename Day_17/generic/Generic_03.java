package generic;

// 클래스의 선언 시 제네릭타입을 지정하면
// 해당 클래스의 내부에서 적용되는 제네릭 문법을 구현할 수 있습니다.
// 만약, 특정 메소드에서만 제네릭이 필요한 경우
// 메소드의 선언부에 제네릭문법을 적용할 수 있습니다.

// 버전 확인 후, 다시 테스트...
class Generic_03_Model_A<T> {	
	public T getData(T source) {
		return source;
	}
}
class Generic_03_Model_B {	
	// 특정 메소드에서만 사용 가능한 제네릭타입 선언
	// 접근지정자 <제네릭타입> 리턴값의타입 메소드이름(매개변수)
	public <T> T getData(T source) {
		return source;
	}
}
public class Generic_03 {
	public static void main(String[] args) {		

	}
}







