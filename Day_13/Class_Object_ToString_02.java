// Object 클래스의 toString 메소드는
// 객체에 대한 문자열 연산이 실행될 때
// 자동으로 호출되는 메소드입니다.

class ToString_02 {}

public class Class_Object_ToString_02 {
	public static void main(String[] args) {		
		ToString_02 obj = new ToString_02();
		
		// 특정 객체에 대한 문자열 연산이 수행되면
		// 해당 객체의 toString 메소드가 자동으로 실행됩니다.
		// 아래의 코드는 실제로 실행이 될 때
		// String message = "Hello " + obj.toString();
		// 의 코드로 변환되어 실행됩니다.
		String message = "Hello " + obj;
		System.out.println(message);
	}
}
