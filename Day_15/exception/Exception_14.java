package exception;

// throws 키워드를 활용한 예외처리 방법
// 메소드를 구현하는 경우 해당 메소드에서 예외가 발생할 가능성이 있는 경우가 많습니다.
// 이런 경우, 해당 메소드 내부에서 try ~ catch 를 사용하여 예외를 처리할 수 있습니다.
// 하지만 각각의 메소드에서 예외 처리를 하는 경우, 예외처리 코드의 중복이 발생되거나
// 또는 사용자에게 예외가 발생했음을 알려야하는 경우도 발생됩니다.

// 메소드에서 발생되는 예외를 직접 처리하지 않고,
// 메소드를 호출한 지점에서 예외를 처리할 수 있도록 throws 키워드를 사용합니다.
// throws 키워드의 사용법
/*
	public 리턴값타입 메소드명(매개변수) throws 해당 메소드에서발생할 수 있는 예외처리 클래스명 {
		메소드의 실행코드...
	}
*/

public class Exception_14 {	
	public static void exception_throws_a() {		
		String message = null;		
		try {
			int size = message.length();
			System.out.printf("size = %d\n", size);
		} catch(NullPointerException e) {
			System.out.println("문자열이 초기화되지 않았습니다.");
		}
		
	}
	// exception_throws_b 메소드는 내부의 실행 코드에서
	// NullPointerException 예외가 발생하고 있습니다.
	// exception_throws_b 메소드는 발생한 예외를 직접 처리하지 않고
	// exception_throws_b 메소드를 호출한 지점으로 예외를 전달하기 위해
	// throws 키워드를 사용하여 메소드를 정의하고 있습니다.
	public static void exception_throws_b() throws NullPointerException {		
		String message = null;			
		int size = message.length();
		System.out.printf("size = %d\n", size);		
	}
	// 만약 특정 메소드에서 발생할 수 있는 예외의 종류가 다수개라면
	// throws 이후에 발생할 가능성이 예외처리 클래스를 나열하여 정의할 수 있습니다.
	// (예외처리 클래스의 이름사이에 쉼표(,)를 사용하여 정의) 
	public static void exception_throws_c() 
			throws NullPointerException, Exception {		
		String message = null;			
		int size = message.length();
		System.out.printf("size = %d\n", size);		
	}
	// exception_throws_d 메소드의 호출 시,
	// 예외가 발생하여 프로그램이 종료됩니다.
	// 그 이유는 throws 에 정의된 예외 클래스가
	// 메소드에서 발생된 ArrayIndexOutOfBoundException 타입이 아니기 때문에
	// 해당 예외 객체를 메소들 호출한 지점으로 전달할 수 없기 때문입니다.
	public static void exception_throws_d() throws NullPointerException {		
		int [] arr = new int[2];
		arr[5] = 100;
	}	
	public static void main(String[] args) {		
		exception_throws_a();
		try {
			// exception_throws_b 메소드에서 발생한
			// 예외 객체를 main 메소드에서 전달받아 
			// 예외를 처리할 수 있습니다.
			exception_throws_b();
		} catch( NullPointerException e ) {
			System.out.println("exception_throws_b 메소드 호출에서 예외 발생");
		}
		
		try {	
			exception_throws_d();
		} catch( NullPointerException e ) {
			System.out.println("exception_throws_d 메소드 호출에서 예외 발생");
		}
	}
}
















