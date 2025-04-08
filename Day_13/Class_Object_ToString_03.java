// Object 클래스의 toString 메소드는
// 출력에 관련된 클래스의 매개변수로 객체에 전달될 경우
// 자동으로 호출되는 메소드입니다.

class ToString_03 {}

public class Class_Object_ToString_03 {
	public static void main(String[] args) {		
		ToString_03 obj = new ToString_03();
		
		// 1. 특정 메소드의 매개변수에 Object 타입이 선언되는 경우
		//    어떠한 클래스의 타입이라도 전달할 수 있습니다.
		//   (Object 클래스는 모든 클래스의 부모클래스이기때문에
		//    자식클래스의 객체를 참조할 수 있습니다.)
		// 2. 출력 기능을 수행하는 메소드의 매개변수에 Object 타입이 선언되면
		//    해당 레퍼런스에 대해서 toString 메소드를 자동으로 호출하게 됩니다.
		
		// 기본 출력을 제공하는 out 객체의 println(Object) 메소드르 사용하는 예제
		// 출력 기능을 제공하는 메소드에 Object 타입을 전달하면
		// 해당 레퍼런스를 사용하여 obj.toString() 의 결과를 출력합니다.
		System.out.println(obj);
	}
}









