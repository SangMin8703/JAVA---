public class ControlStatement_IF_02 {

	public static void main(String[] args) {
		// if ~ else 문
		// 조건문의 참/거짓 유무에 따라서 흐름을 분기할 수 있는 방법을 제공하는 문법
		// 사용법
		// if( 조건문 )
		//	  조건문이 참일 경우에 실행될 실행문;
		// else
		//	  조건문이 거짓일 경우에 실행될 실행문;

		// 성별의 정보를 저장하는 gender 변수
		// 1, 3의 값을 가지면 남성
		// 2, 4의 값을 가지면 여성
		int gender = 2;
		
		if( gender == 1 || gender == 3 )
			System.out.println("당신은 남성입니다.");
		else
			System.out.println("당신은 여성입니다.");
		
		// number 변수의 값이 짝수인지 홀수인지를 판별하여 출력하세요.
		int number = 10;
		
		if( number % 2 == 0 )
			System.out.printf("정수 %d 은 짝수입니다.\n", number);		
		else
			System.out.printf("정수 %d 은 홀수입니다.\n", number);

	}

}















