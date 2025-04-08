// 부모 인터페이스와 부모 클래스를 상속받는 자식클래스의 선언
interface Inter_08_Super {
	public abstract void printInterSuper();
}
class Inter_08_SuperClass {
	public void printSuperClass() {}
}
// 인터페이스와 클래스를 동시에 상속받는 자식클래스의 선언
// class 자식클래스명 extends 부모클래스명 implements 부모인터페이스명1, ... {}
class Inter_08_SubClass extends Inter_08_SuperClass implements Inter_08_Super {	
	public void printInterSuper() {
		System.out.println("Inter_08_SubClass.printInterSuper 메소드 실행");
	}	
	public void printSuperClass() {
		System.out.println("Inter_08_SubClass.printSuperClass 메소드 실행");
	}	
}
public class Class_Interface_08 {
	public static void main(String[] args) {		
		Inter_08_SubClass sub = new Inter_08_SubClass();
		sub.printSuperClass();
		sub.printInterSuper();
		
		// 부모 인터페이스를 사용한 형변환과 다형성
		Inter_08_Super interSuper = sub;
		interSuper.printInterSuper();
		
		// 부모 클래스를 사용한 형변환과 다형성
		Inter_08_SuperClass classSuper = sub;
		classSuper.printSuperClass();
	}
}




