package exception;

public class Exception_10 {
	public static void main(String[] args) {	
		System.out.println("프로그램 시작");
		
		String message = null;
		
		int size;
		
		try {
			size = message.length();		
			System.out.printf("size = %d\n", size);
		} catch( Exception e ) {
			// catch 문에 선언된 예외처리 클래스의 레퍼런스 변수는
			// (위의 catch 문의 경우 Exception 클래스 타입의 e 변수)
			// try 문 내부에서 발생된 예외의 정보를 담고있는 객체를 
			// 참조합니다.
			// 해당 레퍼런스를 변수를 사용하여 다양한 메소드를 호출할 수 있습니다.
			
			// Exception 클래스의 printStackTrace 메소드
			// printStackTrace 메소드는 try 구문에서 발생된 예외의
			// 전체 정보를 출력할 수 있는 메소드
			// 예외 처리 클래스의 이름, 예외가 발생된 코드의 위치,
			// 예외가 발생되기 까지의 메소드 호출 내역등을 포함하여
			// 출력합니다.
			// printStackTrace 는 예외가 발생할 경우 출력되는 메세지와
			// 동일하게 출력합니다.
			e.printStackTrace();
		}
		
		System.out.println("프로그램 종료");
		
	}
}











