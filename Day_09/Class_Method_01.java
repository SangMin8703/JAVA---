// 클래스는 멤버 필드 외에도
// 기능을 제공할 수 있는 메소드를 포함할 수 있습니다.
// 클래스 내부의 메소드들을 멤버 메소드로 호칭합니다.
class Method_A {
	// Method_A 클래스의 멤버 메소드 
	// method_1, method_2 의 선언
	public void method_1() {
		System.out.println("Method_A.method_1 호출");
	}
	public void method_2() {
		System.out.println("Method_A.method_2 호출");
	}
}
public class Class_Method_01 {
	public static void main(String[] args) {
		// 클래스의 멤버 메소드를 활용하기 위해서
		// 클래스의 객체를 생성해야 합니다.
		Method_A m = new Method_A();
		
		// 클래스의 멤버 메소드를 호출하기 위해서
		// 클래스의 변수명에 대해 접근연산자를 사용합니다.
		m.method_1();
		m.method_2();
	}
}











