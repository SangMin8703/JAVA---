package exception;

// 사용자 정의 예외처리 클래스
// 프로그램 코드를 작성하면서, 코드의 실행자체에는 문제가 없지만
// 논리적인 오류를 예외로 정의하여 처리하고 자하는 경우가 발생합니다.
// (성적점수가 0 보다 작거나, 100 보다 큰 경우 등)
// throw 를 활용하여 위의 방법을 해결할 수 있지만, 적절한 예외처리 클래스는 제공되지 않습니다.
// 그렇기 때문에 발생시키고자 하는 예외의 이름을 명확히 하기 위해서
// 개발자는 자신의 예외처리 클래스를 직접 작성할 필요가 있습니다.

// 사용자 정의 예외처리 클래스의 선언
// 예외처리 클래스를 작성할 떄는 일반 클래스와 동일한 방법을 사용합니다.
// (주의사항 - 반드시 Exception 클래스를 상속받아야만 합니다)

// 예외처리 클래스의 선언
// 작명 규칙
// - 예외처리 클래스의 이름은 마지막에 Exception 을 사용합니다.
class InvalidNumberException extends Exception {
	// 예외처리 클래스의 작성 방법
	// 일반적으로 생성자는 두개를 작성합니다.
	// 1. 디폴트 생성자
	//  - 해당 예외를 발생시키면서 메세지를 추가할 필요가 없는 경우
	// 2. String 타입을 매개변수로 하는 생성자
	//  - 해당 예외를 발생시키면서 메세지를 추가하고자 하는 경우
	//  - 부모클래스의 생성자를 사용하여 초기화해야 합니다.
	public InvalidNumberException(){}
	public InvalidNumberException(String s){
		// 부모 클래스인 Exception 클래스가 제공하는 
		// 생성자를 호출
		super(s);
	}
}
public class Exception_19 {
	public static void main(String[] args) {	
		// 디폴트 생성자를 사용해 예외처리 객체를 생성하면
		// getMessage 메소드는 null 값을 반환합니다.
		// InvalidNumberException invalid = new InvalidNumberException();
		
		InvalidNumberException invalid = 
				new InvalidNumberException("잘못된 숫자가 입력되었습니다.");
		
		// 사용자 정의 예외처리 클래스를 사용하여 
		// 예외처리를 하는 코드
		try {
			
			throw invalid;
			
		} catch( InvalidNumberException e ) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}















