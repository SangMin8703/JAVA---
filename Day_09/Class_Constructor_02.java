class Constructor_B {
	int num;
	
	// 매개변수를 사용하는 생성자의 정의
	// 생성자에서 int 타입의 값을 받아, 멤버필드인 num 에 대입하여 객체를 생성
	public Constructor_B( int n ) {
		num = n;
		System.out.printf("Constructor_B(int) 생성자 호출, %d\n", n);
	}
}
	
public class Class_Constructor_02 {

	public static void main(String[] args) {
		
		// 매개 변수가 정의된 생성자를 사용하는 클래스의 객체 생성
		// 객체를 생성할 때, 생성자에 매개변수를 전달하여 실행합니다.
		Constructor_B c = new Constructor_B(77);
		System.out.printf("c.num = %d\n", c.num);
	}

}











