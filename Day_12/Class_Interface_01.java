// Java 의 상속은 단일 상속을 기본으로 합니다.
// (하나의 클래스의 하나의 부모클래스만을 가집니다.)
// 하지만 프로그램의 구현 시, 
// 다수 개의 부모클래스가 필요하게되는 케이스가 발생합니다.
// EX) GUI 프로그램에서 마우스의 입력과, 키보드의 입력을 처리하기 위해서는
//     두개 이상의 부모클래스가 필요합니다.

// 이러한 점을 해결하기 위해서 Java 에서는 인터페이스라는 
// 새로운 형태의 클래스를 제공합니다.
// 인터페이스를 사용하면 다중상속의 구현이 가능하게 됩니다. 

// 인터페이스의 선언
/* 
 interface 인터페이스명 {
	인터페이스의 멤버필드들...
	인터페이스의 멤버메소드...
 }
*/

// 인터페이스는 
// public static final 멤버필드와
// public abstract 메소드만을 포함할 수 있습니다.
// 그 외의 다른 것은 포함할 수 없습니다.
interface Inter_01 {
	public static final int num = 10;
	public abstract void print();
}
// 인터페이스를 상속받는 클래스의 선언
// 인터페이스를 상속받는 방법
// class 자식클래스명 implements 인터페이스명

// 인터페이스를 상속받는 클래스는 부모인터페이스의 
// 추상메소드를 오버라이딩해야만
// 일반 클래스로 사용될 수 있습니다.
// 만약 추상메소드를 오버라이딩하지 않으면
// 추상클래스로 선언되야만 합니다.
abstract class Inter_01_Sub_01 implements Inter_01 {	
}

class Inter_01_Sub_02 implements Inter_01 {
	public void print() {
		System.out.println("Inter_01_Sub_02.print 메소드 실행");
	}	
}

public class Class_Interface_01 {
	public static void main(String[] args) {
		// 인터페이스는 추상메소드를 포함할 수 있기때문에
		// 자신의 객체를 생성할 수 없습니다.		
		// Inter_01 i = new Inter_01();
		
		// 인터페이스는 추상클래스와 마찬가지로
		// 상속을 통한 다형성 구현을 위해 사용되는 클래스입니다.
		
		// 부모 인터페이스의 레퍼런스는 자식클래스의 객체를 참조할 수 있습니다.
		Inter_01 i = new Inter_01_Sub_02();
		// 부모 인터페이스의 레퍼런스를 사용하여
		// 자식클래스에서 오버라이딩한 메소드를 호출할 수 있습니다.
		i.print();
	}
}










