
// 클래스에는 표현하고자 하는 대상의 속성 값을 저장할 수 있습니다.
// 클래스의 속성들을 멤버 필드로 선언합니다.

// 클래스의 멤버 필드는 변수의 선언으로 표현합니다.
// i1, d1 멤버필드를 포함하는 Attribute_A 클래스의 선언
class Attribute_A {
	int i1;
	double d1;	
}
public class Class_Attribute_01 {
	public static void main(String[] args) {
		// 멤버필드를 포함하는 클래스는 
		// 멤버필드에 값을 저장할 수 있고, 외부로 값을 돌려줄 수 있습니다.		
		Attribute_A attr = new Attribute_A();
		
		// 클래스의 멤버필드는 접근연산자를 사용해 접근할 수 있습니다.
		
		// Attribute_A 클래스의 멤버필드 i1에 값을 대입
		attr.i1 = 100;
		// Attribute_A 클래스의 멤버필드 d1에 값을 대입
		attr.d1 = 713.75;
		
		// 클래스의 멤버 필드의 값 출력
		System.out.printf("attr.i1 = %d\n", attr.i1);
		System.out.printf("attr.d1 = %.2f\n", attr.d1);

	}
}







