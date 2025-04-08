import java.util.Scanner;
public class ControlStatement_FOR_06 {

	public static void main(String[] args) {
		// 사용자에게 하나의 정수를 입력받아
		// 1 에서 사용자가 입력한 정수까지의 
		// 짝수의 합계를 구해서 출력하세요.
		
		// 입력 변수 선언
		Scanner sc = new Scanner(System.in);
		int input;
		
		// 출력 변수 선언
		int sum = 0;
		
		// 입력 과정 처리
		System.out.print("정수를 입력하세요 : ");
		input = sc.nextInt();
		sc.close();
		
		// 처리 과정		
		// 누적 데이터를 저장하기 위한 변수의 초기화
		sum = 0;
		for( int i = 1 ; i <= input ; i++ ) {					
			if( i % 2 == 0 )
				sum += i;	//sum = sum + i;
		}		
		
		// 출력
		System.out.printf("1 부터 %d 까지의 짝수 합계는 %d 입니다.\n", input, sum);
		
		/*
		// 반복문을 사용해 누적할 값을 저장하는 변수는
		// 반복문의 외부에서 선언해야만 합니다.
		// 주의사항!
		// 특정 변수의 값을 누적하는 변수는
		// 반드시 초기화가 선행되야만 합니다.
		int sum = 0;
		
		for( int i = 1 ; i <= 10 ; i++ ) {
			// 특정 변수의 값을 누적하는 방법
			// sum 변수에 i 번수의 값을 누적하여 저장
			// 1 + 2 + 3 + 4 + 5 + 6 ... + 10
			sum = sum + i;
		}
		System.out.printf("1 ~ 10 까지의 합계는 %d 입니다.\n", sum);
		*/
		
		/*
		for( int i = 1, sum = 0 ; i <= 10 ; i++ ) {
			// 특정 변수의 값을 누적하는 방법
			// sum 변수에 i 번수의 값을 누적하여 저장
			// 1 + 2 + 3 + 4 + 5 + 6 ... + 10
			sum = sum + i;
		}
		
		// 반복문에서 선언된 sum 변수는 
		// 반복문 외부에서 사용할 수 없습니다.
		System.out.printf("1 ~ 10 까지의 합계는 %d 입니다.\n", sum);
		*/
	}

}
