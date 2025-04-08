// 추상클래스는 추상메소드를 포함할 수 있는 클래스
// 추상클래스는 추상메소드를 포함하는 점 외에는 기존의 
// 클래스의 특징을 그대로 물려받습니다.
abstract class Abstract_04 {
	// 추상클래스는 일반 멤버필드를 사용할 수 있습니다.
	public int n1;
	private int n2;
	// 추상클래스는 static 멤버필드를 사용할 수 있습니다.
	public static int n3;	
	// 추상클래스는 생성자를 선언할 수 있습니다.
	public Abstract_04() {
		System.out.println("추상클래스 Abstract_04 의 디폴트 생성자 실행");
	}
	// 추상클래스는 생성자 오버로딩을 사용할 수 있습니다.
	public Abstract_04(int i) {
		System.out.println("추상클래스 Abstract_04 의 오버로딩된 생성자 실행");
	}	
	// 추상클래스는 일반 메소드를 선언할 수 있습니다.
	public void print() {
		System.out.println("추상클래스 Abstract_04 의 print 메소드 실행");
	}	
	// 추상클래스는 static 메소드를 선언할 수 있습니다.
	public static void setN3(int n3) {
		Abstract_04.n3 = n3;
		System.out.println("추상클래스 Abstract_04 의 setN3 메소드 실행");
	}	
	
	// 추상클래스는 추상메소드를 포함할 수 있는 클래스지만,
	// 반드시 추상메소드를 선언할 필요는 없습니다.
}

public class Class_Abstract_04 {
	public static void main(String[] args) {
		// 추상클래스는 추상메소드의 존재유무와 관계없이
		// 객체의 생성이 불가합니다.
		// Abstract_04 a = new Abstract_04();
	}
}





