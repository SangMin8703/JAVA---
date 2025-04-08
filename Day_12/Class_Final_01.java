// final 키워드
// final 은 마지막의 의지를 가집니다.
// (불변의 의미)
// 기존의 C언어와 같은 경우 const 키워드를 사용하여 구현...

// 1. class 의 선언에 사용되는 경우
// 2. 메소드의 선언에 사용되는 경우
// 3. 멤버필드의 선언에 사용되는 경우

// final 키워드가 class 의 선언에 사용되는 경우
//  - final class 는 상속이 불가능할 클래스입니다.
//  - 특정 클래스를 다른 클래스가 상속하여 구현하지 못하도록 강제하는 경우 사용

// final 클래스의 선언
final class Final_01_Super {}
// final 클래스를 상속받는 자식클래스를 선언할 수 없습니다.
// class Final_01_Sub extends Final_01_Super {}

public class Class_Final_01 {
	public static void main(String[] args) {		

	}
}







