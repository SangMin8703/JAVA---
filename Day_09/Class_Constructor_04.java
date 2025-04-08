// 클래스의 생성자는 클래스 객체가 생성될 때마다
// 한번씩 호출되는 메소드입니다.
// 각 객체가 생성될 때, 한번 호출되고
// 그 이후로는 생성자를 호출할 수 없습니다.
class Constructor_D {
	public Constructor_D() {		
		System.out.println("Constructor_D() 생성자 호출");
	}
	public void display() {
		// 클래스의 내부에서도
		// 해당 클래스의 생성자는 호출할 수 없습니다.
		//Constructor_D();
	}
}
public class Class_Constructor_04 {
	public static void main(String[] args) {
		Constructor_D c1 = new Constructor_D();
		Constructor_D c2 = new Constructor_D();
		
		// 생성자는 객체가 생성될 때 자동으로 호출되는 메소드로
		// 클래스의 레퍼런스를 활용한 명시적인 호출은 허용되지 않습니다.
		//c1.Constructor_D();
		//c2.Constructor_D();
	}
}
