package wrapper;

// Wrapper 클래스의 활용
// Wrapper 들은 java.lang 패키지에 위치하고 있습니다.
// java.lang 패키지는 모든 java 파일에 자동으로 import 되는 패키지므로
// import 하지 않고 제약없이 사용할 수 있습니다.

// Wrapper 클래스들은 일부 클래스를 제외하고
// 모두 기본자료형의 이름에서 앞글자만 대문자로 바뀐 형태를 취합니다.
// byte -> Byte, short -> Short ... 
// 예외적인 경우 (2가지)
// int -> Integer, char -> Character

// Wrapper 클래스들을 활용하여, 
// 기본자료형의 값을 보관할 수 있는 객체를 생성할 수 있습니다.
// 또한 부가적으로 Wrapper 클래스들이 제공하는 다양한 메소드를 
// 사용하여 손쉽게 로직을 구현할 수 있습니다.
public class Wrapper_02 {
	public static void main(String[] args) {	
		// Integer 클래스의 객체 생성
		Integer i1 = new Integer(10);
		Integer i2 = new Integer("10");
		
		// Integer 클래스가 저장하고 있는 값 확인
		
		// 래퍼클래스들은 해당 타입의 값 뿐만 아니라 
		// 다양한 타입으로 값을 반환할 수 있습니다.
		System.out.printf("i1 => %d\n", i1.intValue());
		System.out.printf("i2 => %d\n", i2.intValue());
		
		System.out.printf("i1 => %.2f\n", i1.floatValue());
		System.out.printf("i2 => %.2f\n", i2.floatValue());
		
		System.out.printf("i1 => %.2f\n", i1.doubleValue());
		System.out.printf("i2 => %.2f\n", i2.doubleValue());
	}
}















