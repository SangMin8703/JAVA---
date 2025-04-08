// Java 의 상속은 단일 상속만 가능합니다.
// 자식클래스는 하나의 부모클래스만 가질 수 있습니다.
class Super_03_A {}
class Super_03_B {}

// 아래와 같이 다수개의 부모클래스를 상속받을 수 없습니다.
//class Sub_03 extends Super_03_A, Super_03_B {}

// 아래와 같이 하나의 부모클래스를 상속받는 경우에는
// 문제가 발생하지 않습니다.
class Sub_03_A extends Super_03_A {}
class Sub_03_B extends Super_03_B {}

public class Class_Extends_03 {
	public static void main(String[] args) {
	}
}
