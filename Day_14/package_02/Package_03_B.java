package package_02;

// 다른 패키지에 존재하는 클래스를 사용하기 위해서는
// import 구문을 사용해야 합니다.
// import 구문의 사용법
// 1. import 패키지명이 포함된 클래스의 이름;
//   - 디렉토리의 구조를 정의하기 위해서 접근연산자(.)을 사용합니다.
//   - 사용하고자 하는 각각의 클래스를 따로 정의하는 방법 
import package_01.Package_03_Model;
// 2. import 패키지명.*;
//   - 특정 패키지에 있는 모든 클래스를 import 하는 경우에 사용
import package_01.*;

public class Package_03_B {
	public static void main(String[] args) {
		// 다른 패키지에 존재하는 클래스라도 import 를 사용하여 정의하면
		// 현재 패키지에서 해당 클래스의 객체를 생성할 수 있습니다.
		Package_03_Model model = new Package_03_Model();
		model.print();
	}
}





