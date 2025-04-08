
class Attribute_B {
	// 클래스의 멤버필드는 선언과 동시에 초기화가 가능합니다.
	// 아래의 i1 멤버필드는 Attribute_B 클래스의 객체가 생성되면
	// 초기값으로 55의 값을 할당받습니다.
	int i1 = 55;
	// d1은 멤버필드의 선언부만 존재하기 때문에
	// Attribute_B 클래스의 객체가 생성되면
	// 0으로 초기화가 됩니다.(HEAP 메모리에 생성되기 때문에...)
	double d1;	
}

public class Class_Attribute_02 {
	public static void main(String[] args) {
		Attribute_B attr = new Attribute_B();

		// 클래스의 멤버 필드의 값 출력
		System.out.println("Attribute_B 클래스의 생성 직후 멤버 필드의 값 출력");
		System.out.printf("attr.i1 = %d\n", attr.i1);
		System.out.printf("attr.d1 = %.2f\n", attr.d1);
		
		attr.i1 = 10;
		attr.d1 = 50.71;
		
		System.out.println("Attribute_B 클래스의 멤버 필드의 값을 수정 후 출력");
		System.out.printf("attr.i1 = %d\n", attr.i1);
		System.out.printf("attr.d1 = %.2f\n", attr.d1);
	}
}










