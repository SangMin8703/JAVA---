// 인터페이스 사이에서의 상속은 다중 상속이 가능합니다.
interface Inter_05_SuperA {}
interface Inter_05_SuperB {}
interface Inter_05_SuperC {}
// 3 개의 부모인터페이스를 상속받는 자식 인터페이스의 정의
// interface 자식인터페이스명 extends 부모인터페이스1, 부모인터페이스2, ... {}
interface Inter_05_Sub 
		extends Inter_05_SuperA, Inter_05_SuperB, Inter_05_SuperC {}

public class Class_Interface_05 {
	public static void main(String[] args) {
	}
}
