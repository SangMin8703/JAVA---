package package_01;

// 패키지와 public 클래스의 관계
//  - public 클래스를 제외한 모든 클래스는
//    다른 패키지에서 import 할 수 없습니다.
public class Package_06 {
	public static void main(String[] args) {		
		// 동일한 패키지에 존재하는 public class, 일반 클래스는
		// 제약없이 객체를 생성하여 사용할 수 있습니다.
		Package_06_Model_A modelA = new Package_06_Model_A();
		Package_06_Model_B modelB = new Package_06_Model_B();
		Package_06_Model_C modelC = new Package_06_Model_C();
	}
}
