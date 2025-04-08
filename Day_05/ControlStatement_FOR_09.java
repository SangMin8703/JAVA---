import java.util.Scanner;
public class ControlStatement_FOR_09 {

	public static void main(String[] args) {
		// 사용자에게 정수를 입력받아
		// 입력된 정수가 100 이라면 프로그램을 종료하고,
		// 입력된 정수가 100 이 아니라면 계속해서 입력을 요구하는
		// 프로그램을 작성하세요.
		
		// 입력 변수 선언
		Scanner sc = new Scanner(System.in);
		int input;
		
		System.out.println("프로그램 시작");
		
		// for 문의 반복 조건을 제어하여 계속해서 반복을 수행하는 예제
		
		// 무한 루프의 정의
		// 반복문의 조건이 항상 true 의 값을 가지므로 반복이 종료되지 않습니다.
		// 무한 루프를 정의하는 경우, 반복문의 내부에는 반드시 break 를 사용하여
		// 반복을 종료할 수 있도록 제어해야만 합니다.
		/*
		for( ; 0 == 0 ; ) {
			System.out.print("정수를 입력하세요 : ");
			input = sc.nextInt();
			
			if( input == 100 ) {
				break;
			}
		}
		*/
		
		// for 문을 사용한 무한루프의 정의
		// for 문의 조건식을 비워두면 
		// 조건은 항상 참이되어 무한루프를 구현할 수 있습니다.
		/*
		for( ; ; ) {
			System.out.print("정수를 입력하세요 : ");
			input = sc.nextInt();
			
			if( input == 100 ) {
				break;
			}
		}
		*/
		
		// for 문의 실행 순서를 이용하여 처리하는 예쩨
		for(System.out.print("입력:");(input = sc.nextInt())!=100;System.out.print("입력:")) 
			;
		 
		sc.close();
		System.out.println("프로그램 종료");

	}

}











