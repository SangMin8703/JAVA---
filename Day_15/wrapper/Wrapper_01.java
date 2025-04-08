package wrapper;
// Wrapper 클래스
// Java 프로그램을 구성하는 요소 중, 유일하게 객체지향적이기 않은 요소는
// 기본자료형들 입니다.
// Java 언어 사용하는 객체는 주요한 특징중 하나로 접근연산자(.)을 사용할 수 있습니다.
// 하지만 기본 자료형은 메모리 공간을 할당받기 위하여 사용되는 타입일 뿐으로
// 객체를 생성할 수 없는 타입입니다.

// 기본 자료형에 1대1로 매핑될 수 있는 클래스들을 Wrapper 클래스라고 합니다.
// Wrapper 클래스를 사용하면, 기본자료형의 값도 객체로서 활용될 수 있습니다.

// EX) 기본자료형의 값을 Object 타입으로 저장하는 경우
class Wrapper_01_A {}
class Wrapper_01_B {}
public class Wrapper_01 {
	public static void main(String[] args) {		
		// Java 에서 생성되는 모든 객체들은 타입에 상관없이
		// 최상위 부모클래스인 Object 타입으로 형변환될 수 있습니다.
		Object obj;
		
		String strMsg = "Hello";
		// String 클래스의 레퍼런스 값을 Object 타입으로 형변환
		obj = strMsg;
		
		Wrapper_01_A w1 = new Wrapper_01_A();
		// 사용자 정의 클래스인 Wrapper_01_A 클래스의 레퍼런스 값을 
		// Object 타입으로 형변환
		obj = w1;
		
		Wrapper_01_B w2 = new Wrapper_01_B();
		// 사용자 정의 클래스인 Wrapper_01_B 클래스의 레퍼런스 값을 
		// Object 타입으로 형변환
		obj = w2;
		
		// Object 클래스 타입은 기본자료형인 int, double 타입 등을
		// 직접 저장할 수 없습니다.
		// 그 이유는 기본 자료형의 변수들은 실제 값(10, 10.1, 'A')을
		// 저장하는 변수이기 때문에 객체로서 사용될 수 없기 때문입니다.
		// 기본 자료형의 값을 Object 클래스 타입으로 저장하기 위해서는
		// 기본 자료형과 1대1로 매핑되는 래퍼클래스들을 활용해야 합니다.
		
		// 아래의 예는 묵시형 형변환이 실행되어
		// int 타입의 변수가 Integer 클래스의 타입으로 형변환된 후,
		// Object 타입으로 형변돤 된 모습을 확인할 수 있습니다.
		int intValue = 10;
		obj = intValue;
		System.out.println(obj.getClass());
		
	}
}















