// 명시적으로 super 키워드를 반드시 사용해야 되는 경우
// 1. 부모클래스에 디폴트 생성자가 존재하지 않는 경우
class Super_06 {
	// 부모클래스에서 매개변수를 사용하는 생성자를 선언했기 때문에
	// 컴파일러는 부모클래스의 디폴트 생성자를 추가하지 않습니다.
	// 현재 부모클래스에는 디폴트 생성자가 존재하지 않음
	public Super_06(int i) {
		System.out.println("부모 클래스의 Super_06(int i) 생성자 실행");
	}
}
class Sub_06 extends Super_06 {
	public Sub_06() {
		// 상속 관계를 구현한 자식클래스의 생성자는
		// 첫번째 실행코드로 super(); 를 자동 삽입됩니다.
		// 이 코드는 부모클래스의 디폴트 생성자를 호출하는 코드로
		// 만약, 부모클래스에 디폴트 생성자가 존재하지 않으면
		// 컴파일 에러를 발생시킵니다.
		
		// 부모클래스의 디폴트 생성자가 존재하지 않는다면
		// super 키워드를 사용하여 명시적으로 부모클래스의 매개변슬 사용하는
		// 생성자를 호출해야만 합니다.
		// super(매개변수);
		super(10);
		System.out.println("자식 클래스의 Sub_06() 생성자 실행");
	}
}
public class Class_Extends_06 {
	public static void main(String[] args) {
		// 
	}
}









