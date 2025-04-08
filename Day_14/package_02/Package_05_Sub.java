package package_02;

import package_01.Package_05_Model;

public class Package_05_Sub extends Package_05_Model {
	// 부모클래스에 정의된 멤버필드
	/*
	public int num1;
	private int num2;
	// 디폴트 접근지정자를 사용한 멤버
	int num3;
	protected int num4;
	*/
	public Package_05_Sub() {
		// 서로 다른 패키지에 존재하는 클래스 사이에서
		// 상속 관계를 구현하는 경우
		// 부모 클래스의 public, protected 멤버에 접근할 수 있습니다.
		num1 = 10;
		// num2 = 10;
		// num3 = 10;
		num4 = 10;
	}
}








