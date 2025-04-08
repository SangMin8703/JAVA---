
public class Method_07 {
	
	// 메소드 매개변수의 사용
	// call by value, call by reference
	// call by value - 메소드의 매개변수로 값을 전달하는 방식
	// call by reference - 매소드의 매개변수로 레퍼런스(참조값)을 전달하는 방식
		
	// call by value - 값을 전달하여 메소드를 실행하는 방식
	public static void methodTest_1( int num ) {
		// call by value 방식의 특징
		// 호출된 메소드에서 값을 수정하여도
		// 원본 데이터( main 메소드의 num 변수 )의 값에는 영향이 없습니다.
		
		// methodTest_1 메소드의 지역변수 num 이 수정
		num = 100;
		System.out.printf("num = %d\n", num);
	}

	public static void main(String[] args) {		
		System.out.println("프로그램 시작");
		
		int num = 10;
		System.out.printf("메소드 호출 전 : num = %d\n", num);
		
		methodTest_1(num);
		
		System.out.printf("메소드 호출 후 : num = %d\n", num);
		
		System.out.println("프로그램 종료");
	}

}










