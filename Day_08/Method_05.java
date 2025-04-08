
public class Method_05 {
	
	// 다수개의 매개변수를 사용하는 메소드의 정의
	// 매개변수를 다수개 사용하는 경우, 각각의 매개변수는 변수로서 등록합니다.
	// 각각의 매개변수는 , 를 기준으로 분류합니다.
	// 이때 주의할 점은 매개변수의 타입이 동일한 경우도 새로운 변수로 등록해야합니다.
	
	// 서로 다른 타입을 가지는 2개의 매개변수를 사용하는 메소드 예쩨
	public static void methodTest_1(int i, double d) {
		System.out.println("methodTest_1 실행");
		System.out.printf("i = %d, d = %.2f\n", i, d);
	}
	
	// 다수개의 매개변수가 동일한 타입이라도, 각 매개변수는 
	// "자료형 변수명" 의 규칙을 지켜서 선언해야 합니다.  
	public static void methodTest_2(int i1, int i2) {
		System.out.println("methodTest_2 실행");
		System.out.printf("i1 = %d, i2 = %d\n", i1, i2);
	}

	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		
		// 다수개의 매개변수를 선언한 메소드를 호출하기 위해서는
		// 선언된 매개변수의 위치(순서)를 지켜서 호출해야만 합니다.
		// methodTest_1 의 경우 매개변수가 2개이고
		// 첫번째 매개변수는 정수형, 두번째 매개변수는 실수형입니다.
		// 그렇기 때문에 호출할에도 이 순서를 지켜서 값을 전달해야합니다.
		methodTest_1(100, 10.1);
		
		methodTest_2(100, 200);
		
		System.out.println("프로그램 종료");
	}

}









