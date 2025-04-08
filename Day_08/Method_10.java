
public class Method_10 {

	// 리턴값을 반환하는 메소드의 선언
	// 리턴값을 반환하는 경우, 리턴값의 타입에는
	// 반환하고자하는 값의 자료형을 작성합니다.
	// 만약 리턴되는 값이 없다면, void 키워드를 사용하여
	// 정의합니다.
	
	// 정수형의 값을 반환하는 getNumber 메소드의 선언
	public static int getNumber() {		
		// 리턴값의 타입을 정의한 메소드는 반드시 해당 타입에 맞는 값을
		// 반환해야만 합니다.
		// return 키워드를 사용하여 값을 반환
		
		// return 키워드
		// 메소드의 반환값을 정의하는 키워드
		// return (메소드가 종료된 후 반환한 값, 식)
		// return 100;
		
		// return 키워드의 의미
		// 1. 현재 실행되고있는 메소드를 종료하고, 
		//    호출한 지점으로 돌아가도록 하는 명령
		//    이런 케이스의 경우 우항에는 어떠한 값도 존재하지 않습니다.
		// 2. 현재 실행되고있는 메소드를 종료하고,
		//    우항에 정읙된 값 호출한 지점으로 반환하도록 하는 명령
		return 100;
	}
	
	public static void main(String[] args) {
		
		System.out.println("프로그램 시작");
		
		int num;
		
		num = getNumber();
		
		if( 10 > 5 )
			// main 메소드의 실행을 종효나는 return 키워드
			return;
		
		System.out.printf("num = %d\n", num);
		
		System.out.println("프로그램 종료");
		

	}

}







