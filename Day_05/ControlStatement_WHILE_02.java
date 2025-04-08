import java.util.Scanner;
public class ControlStatement_WHILE_02 {

	public static void main(String[] args) { 
		// 사용자로부터 정수를 입력받아 화면에 출력하세요. 
		// 사용자가 100을 입력할때지 계속해서 수행되는 프로그램을 작성하세요.
		// while 반복문을 사용
		
		// 입력 변수 선언
		Scanner sc = new Scanner(System.in);
		int input;
		
		// 처리 과정
		System.out.print("정수를 입력하세요 : ");
		while( sc.nextInt() != 100 ) {
			System.out.print("정수를 입력하세요 : ");
		}
		
		/*
		input = 0;
		while( input != 100 ) {
			System.out.print("정수를 입력하세요 : ");
			input = sc.nextInt();
		}
		*/
		
		sc.close();
		System.out.println("프로그램 종료");
	}

}









