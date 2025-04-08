class Constructor_C {
	int num;	
	// 만약, 클래스에 생성자를 하나라도 정의하면
	// 컴파일러는 디폴트 생성자를 생성하지 않습니다.
	public Constructor_C( int n ) {
		num = n;
		System.out.printf("Constructor_C(int) 생성자 호출, %d\n", n);
	}
}
public class Class_Constructor_03 {

	public static void main(String[] args) {
		// 디폴트 생성자가 존재하지 않기 때문에
		// 해당 생성자를 통해 객체를 생성할 수 없습니다.
		Constructor_C c = new Constructor_C();
		System.out.printf("c.num = %d\n", c.num);

	}

}
