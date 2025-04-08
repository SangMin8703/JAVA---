
public class Operator_06 {

	public static void main(String[] args) {
		// 대입 연산자
		// = 기호를 사용하는 연산자
		// 우항의 값을 좌항에 대입하는 연산자
				
		// num 변수에 10을 대입하는 코드
		int num;		
		num = 10;
		
		// 대입 연산자의 특징
		// 우항의 값을 좌항에 대입한 이 후, 좌항을 남겨줍니다.
		System.out.printf("num = %d\n", (num = 77) );
		
		int n1, n2, n3;
		// n1, n2, n3 변수에 100의 값을 대입하고 하는 경우
		// n1 = 100; n2 = 100; n3 = 100;
		n1 = n2 = n3 = 100;
		System.out.printf("n1 = %d, n2 = %d, n3 = %d\n", n1, n2, n3 );
		
		// number 변수의 값을 2배 증가 시킨 후, 300 이상인지 확인하세요.
		int number = 100;
		
		// number 변수의 값을 2배 증가 시키는 연산을 먼저 실행한 후
		//number = number * 2;
		// number 변수의 값을 비교
		//boolean flag = number >= 300;
		
		// number 변수의 값을 2배 증가하고 즉시 비교 연산을 먼저 실행
		boolean flag = (number = number * 2) >= 300;
		
		System.out.printf("result -> %b\n", flag);
	}
}













