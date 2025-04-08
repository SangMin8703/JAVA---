
public class Method_03 {
	
	// 리턴하는 값이 없고, 실행 시 필요한 매개변수가 없는 메소드의 선언
	// 1. 메소드의 실행이 종료된 후, 반환하는 값이 없는 경우
	// 리턴값의 타입은 void 로 작성합니다.	
	// 2. 메소드의 실행 시 필요한 매개변수가 존재하지 않으면
	// 매개변수를 정의 한 소괄효 내부는 비워둡니다.
	public static void methodTest() {
		System.out.println("methodTest 메소드 실행");
	}

	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		
		// 메소드의 리턴값이 존재하지 않는 경우
		// 해당 메소드의 호출 코드는 어떠한 값도 반환하지 않습니다.
		// 메소드의 매개변수가 존재하지 않을 경우
		// 메소드 호출 코드에는 소괄호 내부를 비워둡니다.
		methodTest();
		
		System.out.println("프로그램 종료");

	}

}






