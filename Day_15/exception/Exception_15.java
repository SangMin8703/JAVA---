package exception;

// 메소드 오버라이딩의 제약 조건
// 1. 부모클래스의 메소드의 원형과 일치해야 합니다.
//    (리턴값의 타입, 메소드 이름, 매개변수)
// 2. 부모클래스의 메소드 접근지정자는 축소될 수 없습니다.
//    (부모클래스의 메소드 접근지정자가 public 이라면
//     자식클래스의 메소드 접근지정자는 반드시 public 만 가능합니다.)
//    부모 메소드 private -> 자식 메소드 public
//    부모 메소드 protected -> 자식 메소드 public
// 3. 부모클래스의 메소드에서 throws 하고 있는 예외 클래스보다
//    상위 클래스를 throws 할 수 없습니다.

class Exception_15_Super {
	public void print_a() {}
	
	public void print_b() throws NullPointerException {}
}
class Exception_15_Sub extends Exception_15_Super {
	/*
	private void print_a() {}	
	public void print_b() throws Exception {}
	*/
}

public class Exception_15 {
	public static void main(String[] args) {
		// 부모 자식관계를 형성하는 클래스 사이에서는
		// 일반적으로 메소드 오버라이딩을 활용한 다형성 구현을 사용합니다. 
		Exception_15_Super obj = new Exception_15_Sub();
		// 부모 클래스의 print_a 메소드는 public 접근지정자를 사용하기 때문에
		// 외부에서 호출 할 수 있어야만 합니다.
		// 하지만 자식클래스에서 메소드 오버라이딩을 구현하면서
		// 접근지정자를 축소하는 경우 부모의 레퍼런스를 사용하여
		// 해당 메소드를 호출할 수 없게 되기때문에
		// 부모 클래스의 메소드를 오버라이딩 할 경우
		// 접근지정자를 축소할 수 없습니다.
		obj.print_a();
		// 부모클래스의 print_b 메소드는 NullPorinterException 타입의
		// 예외 객체를 던질 수 있습니다.
		// 아래의 코드는 obj 레퍼런스를 사용하여 print_b 메소드를 호출할 경우
		// NullPorinterException 타입을 전달받을 수 있습니다.
		// 하지만 자식클래스에서 부모에서 throws 하는 예외 클래스보다
		// 상위 클래스를 전달하면, 형변환 에러가 발생되기 때문에
		// 자식클래스는 부모클래스의 메소드에서 throws 하면 예외 클래스 보다
		// 상위 클래스를 throws 할 수 없습니다.
		obj.print_b();
		
	}
}








