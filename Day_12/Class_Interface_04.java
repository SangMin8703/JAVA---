// 인터페이스 사이에서의 상속
// 인터페이스는 일반적으로 클래스의 부모 역할을 담당하지만
// 인터페이스 사이에서도 상속관계를 구현할 수 있습니다.

// 부모 인터페이스 정의
interface Inter_04_Super {
	public abstract void printSuper();
}
// 자식 인터페이스의 정의
// 인터페이스 사이의 상속을 extends 키원드를 사용하여 정의
// interface 자식인터페이스명 extends 부모인페이스명
interface Inter_04_Sub extends Inter_04_Super {
	public abstract void printSub();
}
// 자식 인터페이스를 상속받는 클래스의 정의
class Inter_04_SubClass implements Inter_04_Sub {
	// 상속관계를 구현한 인터페이스를 클래스에서 상속하면
	// 최상위 인터페이스의 추상메소드를 포함하여
	// 오버라이딩해야만 일반 클래스로 사용될 수 있습니다.
	public void printSuper() {
		System.out.println("Inter_04_SubClass.printSuper 메소드 실행");
	}
	public void printSub() {	
		System.out.println("Inter_04_SubClass.printSub 메소드 실행");
	}	
}
public class Class_Interface_04 {
	public static void main(String[] args) {		
		Inter_04_SubClass subClass = new Inter_04_SubClass();
		subClass.printSuper();
		subClass.printSub();
		
		Inter_04_Sub sub = subClass;
		sub.printSuper();
		sub.printSub();
		
		Inter_04_Super sup = subClass;
		sup.printSuper();
		// 최상위 인터페이스인 Inter_04_Super 인터페이스는
		// printSuper 메소드만을 가지기 때문에
		// 자식인터페이스 선언한 printSub 메소드를 사용할 수 없습니다.
		//sup.printSub();
	}
}






