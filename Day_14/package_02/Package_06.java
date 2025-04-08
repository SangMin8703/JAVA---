package package_02;

// 다른 패키지에 존재하는 public class는 
// import 를 하여 사용할 수 있는 클래스 입니다.
import package_01.Package_06_Model_A;
// 다른 패키지에 존재하는 일반 class(public class가 아닌 클래스)는 
// import를 할 수 없는 클래스 입니다.
// import package_01.Package_06_Model_B;
// import package_01.Package_06_Model_C;

public class Package_06 {
	public static void main(String[] args) {
		
		Package_06_Model_A modelA = new Package_06_Model_A();
		
		// public class 가 아닌 클래스들은 
		// import 가 제약되기 때문에 객체를 생성하여 사용할 수 없습니다.
		// Package_06_Model_B modelB = new Package_06_Model_B();
		// Package_06_Model_C modelC = new Package_06_Model_C();
	}
}
