package package_02;

import package_01.Package_05_Model;

public class Package_05_Normal {
	public static void main(String[] args) {
		Package_05_Model model = new Package_05_Model();
		
		// 서로 다른 패키지의 클래스인 경우 다른 패키지에 존재하는 클래스의
		// public 멤버에만 접근할 수 있습니다.
		model.num1 = 10;
		// model.num2 = 10;
		// model.num3 = 10;
		// model.num4 = 10;
	}
}
