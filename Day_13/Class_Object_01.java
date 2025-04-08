// Object 클래스
// Object 클래스는 Java에서 사용되는 모든 클래스드의 최상위 부모클래스
// 모든 Java API 클래스들은 Object 클래스를 상속받고 있으며,
// Java 개발자가 선언하는 모든 클래스들은 자동으로 Object 클래스를 상속받게 됩니다.

// Object 클래스는 모든 클래스들의 객체가 공통적으로 가져야만 하는 기능을 정의하고 있습니다.
// 모든 객체들은 다른 객체와의 비교를 할 수 있어야하기 때문에 equals 메소드를 사용할 수 있고,
// 모든 객체들은 자신을 문자열로 표현할 수 있도록 toString 메소드를 사용할 수 있습니다.
// clone, wait, notify 등등을 사용할 수 있습니다.

// 멤버필드, 멤버메소드를 포함하고 있지않은 클래스의 선언
// 만약, 클래스의 선언 시, 상속을 구현하지 않는다면
// 컴파일러는 자동으로 extends Object 를 추가합니다.
// class Object_01 extends Object {}
class Object_01 {}

public class Class_Object_01 {
	public static void main(String[] args) {		
		Object_01 obj = new Object_01();
		
		// 어떠한 멤버도 선언하지 않은 클래스 Object_01 이지만
		// Object 클래스로부터 상속받은 몇몇 메소드들을 사용할 수 있습니다.
		System.out.println( obj.getClass() );
		System.out.println( obj.hashCode() );
		System.out.println( obj.toString() );
	}
}













