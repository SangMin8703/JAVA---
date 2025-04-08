// 제어문
// 프로그램 코드의 흐름을 제어할 수 있는 문법
// 특정 코드, 코드 블럭의 실행을 분기하거나 반복하여 처리하는 문법을 제공

// 분기문
// if, switch
// 반복문
// for, while, do ~ while

public class ControlStatement_IF_01 {

	public static void main(String[] args) {
		// if 문
		// 특정 코드, 코드 블럭의 실행을 분기할 수 있는 문법을 제공
		// 사용법
		// if( 조건문 )
		//	  조건문이 참일 경우에 실행될 실행문;

		// 성별의 정보를 저장하는 gender 변수
		// 1, 3의 값을 가지면 남성
		// 2, 4의 값을 가지면 여성
		int gender = 3;
		
		if( gender == 1 || gender == 3 )
			System.out.println("당신은 남성입니다.");
		
		if( gender == 2 || gender == 4 )
			System.out.println("당신은 여성입니다.");
		
		// number 변수의 값이 짝수인지 홀수인지를 판별하여 출력하세요.
		int number = 3;
		
		if( number % 2 == 0 )
			System.out.printf("정수 %d 은 짝수입니다.\n", number);
		
		if( number % 2 == 1 )
			System.out.printf("정수 %d 은 홀수입니다.\n", number);

	}

}















