// 상속
// 클래스의 재활용을 위해 사용되는 문법
// 기존의 클래스의 내용을 다른 클래스에서 사용할 수 있도록 도와주는 문법

// 클래스의 재활용이 활용되는 경우
// 1. 포함 관계( has a )
//  - 특정 클래스가 다른 클래스를 사용하는 경우
//  EX) 유저와 아이템의 관계 (유저는 아이템을 사용하여 플레이를 진행기 때문에)
// 2. 상속 관계( is a )
//  - 특정 클래스가 다른 클래스의 속성을 물려받아 사용하는 경우
//  EX) 그랜저는 자동차다 (is a)

// 상속 관계의 구현( is a )
// extends 키워드를 사용하여 상속 관계를 구현
class 자동차 {
	String 차명;
	double 배기량;
	double 연비;
	// ...
}
// 상속의 구현
// class 자식클래스명 extends 부모클래스명
class 그랜져 extends 자동차 {	
	// 상속을 구현한 자식클래스(SubClass)는 
	// 부모클래스(SuperClass)의 모든 멤버에 접근할 수 있습니다.
	public 그랜져(String 차명, double 배기량, double 연비) {
		// 부모클래스인 자동차 클래스가 가지고 있는 멤버에 접근하여
		// 사용하는 예제
		this.차명 = 차명;
		this.배기량 = 배기량;
		this.연비 = 연비;
	}	
	public void printInfo() {
		System.out.printf("차명은 %s 입니다.\n", this.차명);
		System.out.printf("배기량은 %.2f 입니다.\n", this.배기량);
		System.out.printf("연비는 %.2f 입니다.\n", this.연비);
	}	
}
public class Class_Extends_02 {
	public static void main(String[] args) {
		그랜져 car = new 그랜져("그랜져", 3000.0, 7.0);
		car.printInfo();
	}
}








