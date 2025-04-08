// 인터페이스의 다중 상속
// 인터페이스는 다중 상속을 위해서 사용되는 특별한 클래스입니다.
// 인터페이스를 사용하면 다수개의 부모를 갖는 클래스를 선언할 수 있습니다.
interface Inter_03_SuperA {
	public abstract void printA();
}
interface Inter_03_SuperB {
	public abstract void printB();
}
// 다중 상속을 위한 인터페이스 구현
// class 자식클래스명 implements 부모인터페이스1, 부모인터페이스2 ... {}
class Inter_03_Sub implements Inter_03_SuperA, Inter_03_SuperB {	
	// 다수개의 부모 인터페이스를 상속하는 자식클래스는
	// 모든 부모 인터페이스의 추상 메소드를 오버라이딩해야만
	// 일반 클래스로 사용될 수 있습니다.
	public void printA() {
		System.out.println("Inter_03_Sub.printA 메소드 실행");
	}	
	public void printB() {	
		System.out.println("Inter_03_Sub.printB 메소드 실행");
	}	
}
public class Class_Interface_03 {
	public static void main(String[] args) {		
		// 다중 상속을 구현한 클래스와 인터페이스의 활용
		Inter_03_Sub sub = new Inter_03_Sub();
		
		System.out.println("자식클래스의 객체를 활용한 메소드 호출");
		sub.printA();
		sub.printB();
		
		// 부모 인터페이스는 자식클래스의 객체를 참조할 수 있습니다.		
		Inter_03_SuperA superA = sub;
		System.out.println("Inter_03_SuperA 부모 레퍼런스를 활용한 메소드 호출");
		superA.printA();
		// 부모 인터페이스는 자식클래스의 객체를 참조할 수 있지만
		// 해당 인터페이스가 제공하는 멤버에만 접근할 수 있습니다.
		// (public static final 멤버필드, 
		// public abstract 추상메소드만을 접근할 수 있습니다.)
		//superA.printB();
		
		// 부모 인터페이스는 자식클래스의 객체를 참조할 수 있습니다.
		Inter_03_SuperB superB = sub;	
		System.out.println("Inter_03_SuperB 부모 레퍼런스를 활용한 메소드 호출");
		superB.printB();
		// 부모 인터페이스는 자식클래스의 객체를 참조할 수 있지만
		// 해당 인터페이스가 제공하는 멤버에만 접근할 수 있습니다.
		// (public static final 멤버필드, 
		// public abstract 추상메소드만을 접근할 수 있습니다.)
		//superB.printA();
	}
}



















