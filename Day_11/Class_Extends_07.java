// 명시적으로 super 키워드를 반드시 사용해야 되는 경우
// 1. 부모클래스에 디폴트 생성자가 존재하지 않는 경우
class Super_07 {
	public Super_07(int i) {
		System.out.println("부모 클래스의 Super_07(int i) 생성자 실행");
	}
}
class Sub_07 extends Super_07 {
	public Sub_07() {
		// 부모클래스의 생성자를 호출하는 super 키워드는 
		// 자식클래스 생성자 내부의 첫 번째 실행 코드로만 가능합니다.
		// this 키워드와 충돌을 피하기 위해서 정의된 문법
		super(10);
		System.out.println("자식 클래스의 Sub_07() 생성자 실행");
		
		// 첫번째 실행 코드가 아니기 때문에 컴파일 에러가 발생
		//super(10);
	}
	public Sub_07(int i) {	
		// 자식 클래스의 생성자에서 this 키워드를 활용한 생성자 호출을 실행하면
		// super 키워드를 사용한 부모클래스의 생성자 호출은 해당 생성자에서는
		// 실행되지 않습니다.
		// (this 키워드에 의해서 호출된 생성자에서 부모클래스의 생성자를 호출)
		this();
		System.out.println("자식 클래스의 Sub_07() 생성자 실행");
	}
}
public class Class_Extends_07 {
	public static void main(String[] args) {
	}
}




