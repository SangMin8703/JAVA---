package exception;

public class Exception_05 {

	public static void main(String[] args) {
		// 예외가 발생하는 프로그램 2
		System.out.println("프로그램 시작");
		
		String message = null;		
		//message = "예외처리 수업 중 입니다.\n집중하세요";
		
		System.out.println(message);
		try {
			System.out.printf("message 문자열의 길이 : %d\n", message.length());
		} catch( NullPointerException e ) {
			System.out.println("message 레퍼런스 변수에 문자열을 할당한 후 실행하세요");
		}
		
		System.out.println("프로그램 종료");

	}

}
