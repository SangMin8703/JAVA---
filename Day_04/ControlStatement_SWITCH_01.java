
public class ControlStatement_SWITCH_01 {

	public static void main(String[] args) {
		// switch 문
		// 정수의 값을 기준으로 흐름을 분기할 수 있는 문법
		// 사용법
		/*
		switch( 정수형 변수 / 정수형의 값 / 정수형의 값을 반환하는 식 ) {
		
			case 상수1 :
				해당 상수의 값이 들어왔을 경우 실행될 실행문;
				...
				break;
			case 상수2 :
				해당 상수의 값이 들어왔을 경우 실행될 실행문;
				...
				break;
			default : 
				모든 case 에 해당되지 않는 경우 실행될 실행문;				
		}
		*/
		
		// 상수
		// 컴파일 이 후에 절대로 변경되지 않는 값
		// 아래의 예시 코드에서는 num 변수의 초기화를 위해 사용되는 10 이 정수형 상수로 사용
		// printf 메소드에 의해서 출력될 문자열도 상수로 사용됩니다.
		int num = 2;
		System.out.printf("num = %d\n", num);
		
		switch( num ) {		
			
			// num 변수의 값이 1인 경우 실행될 케이스의 정의
			case 1:		// if( num == 1 )
				System.out.println("case 1 실행");
				break;
			// num 변수의 값이 2인 경우 실행될 케이스의 정의
			case 2:		// else if( num == 2 )
				System.out.println("case 2 실행");
				break;
			// num 변수의 값이 3인 경우 실행될 케이스의 정의
			case 3:		// else if( num == 3 )
				System.out.println("case 3 실행");
				break;
			// num 변수의 값 1,2,3 이 아닌 경우에 실행될 영역을 정의
			default:	// else
				System.out.println("default 실행");		
				
		}
		
	}

}













