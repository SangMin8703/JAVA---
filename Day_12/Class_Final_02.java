// final 키워드
// final 은 마지막의 의지를 가집니다.
// (불변의 의미)
// 기존의 C언어와 같은 경우 const 키워드를 사용하여 구현...

// 1. class 의 선언에 사용되는 경우
// 2. 메소드의 선언에 사용되는 경우
// 3. 멤버필드의 선언에 사용되는 경우

// final 키워드가 메소드의 선언에 사용되는 경우
//  - final 메소드는 자식클래스에서 메소드 오버라이딩을 구현할 수 없습니다.
//  - 부모클래스를 final 클래스로 선언하면 자식 클래스를 생성할 수 없도록 하는반면,
//    final 메소드를 사용하면 클래스 자체는 상송할 수 있도록 하면서,
//    특정 기능들만 수정할 수 없도록 강제할 수 있습니다.
class Final_02_Super {
	public void normalMethod(){}
	// final 메소드의 선언 
	// 메소드의 원형 앞에 final 키워드를 사용하여 선언
	public final void finalMethod(){}
}

class Final_02_Sub extends Final_02_Super {
	// 부모클래스의 일반 메소드는 정상적으로 오버라이딩을 할 수 있습니다.
	public void normalMethod(){
		System.out.println("일반메소드 오버라이딩 구현");
	}
	// 부모클래스의 final 메소드는 자식클래스에서 오버라이딩 할 수 없습니다.
	// public void finalMethod(){}
}

public class Class_Final_02 {
	public static void main(String[] args) {		

	}
}







