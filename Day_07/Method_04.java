
public class Method_04 {
	
	// 메소드의 실행에 필요한 매개변수가 존재하는 경우
	// 매개변수는 변수의 선언을 통해 정의합니다.
	// 매개변수는 소괄호 내부에 전달 받고자하는 타입의 변수를 선언하여 처리합니다.
	public static void methodTest_1( int num ) {
		System.out.println("methodTest_1 실행");
		System.out.printf("매개변수 num = %d\n", num);
	}

	public static void main(String[] args) {
		System.out.println("프로그램 시작");		
		
		// 매개변수가 정의된 메소드를 호출하기 위해서는
		// 매개변수의 타입에 일치하는 값을 전달하야만 호출할 수 있습니다.
		methodTest_1(100);
		
		System.out.println("프로그램 종료");
	}

}





