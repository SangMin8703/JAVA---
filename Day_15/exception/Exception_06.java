package exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception_06 {
	public static void main(String[] args) {
		// 예외가 발생하는 프로그램 3	
		System.out.println("프로그램 시작");
		
		Scanner sc = new Scanner(System.in);
		int age;
		
		try {
			System.out.print("당신의 나이는?");
			age = sc.nextInt();			
			// try 블럭에서 예외가 발생하는 경우
			// 예외가 발생된 이후의 실행 코드들은
			// 실행되지 않습니다.
			// try 블럭에서 예외가 발생되면
			// 실행 흐름은 catch 구문으로 이동하기 때문에...
			System.out.printf("입력한 나이는 %d 세 입니다.\n", age);
		} catch( InputMismatchException e ) {
			System.out.println("정수의 타입으로 나이를 입력해주세요...");
		}
		
		sc.close();
		
		System.out.println("프로그램 종료");
	}
}





