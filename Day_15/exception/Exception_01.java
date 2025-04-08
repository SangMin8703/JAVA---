package exception;

import java.util.Scanner;

// 에러(ERROR)
// - 잘못된 것
// - 에러가 있는 프로그램은 구동될 수 없음
// - 에러는 반드시 수정해야만 프로그램이 구동될 수 있습니다.
// EX) 컴파일 에러와 같은 것
// 예외(Exception)
// - 에러와 같이 치명적인 문제는 아님
// - 일반적인 상황이라면 원활히 프로그램 구동될 수 있음
// - 특별한 상황에서 에러와 같이 프로그램을 강제종료 시킬 수 있음

// 예외 처리
// - 예외가 발생할 수 있음을 인정하고, 예외가 발생할 경우
//   프로그램 강제 종료되지 않도록 도와주는 것.

public class Exception_01 {
	public static void main(String[] args) {		
		// 예외가 발생하는 프로그램 1
		System.out.println("프로그램 시작");
		
		Scanner sc = new Scanner(System.in);
		
		int num1;
		int num2;
		
		System.out.print("1 번째 정수를 입력하세요 : ");
		num1 = sc.nextInt();
		System.out.print("2 번째 정수를 입력하세요 : ");
		num2 = sc.nextInt();
		
		int result = num1 / num2;
		
		System.out.printf("%d / %d = %d\n", num1, num2, result);
		sc.close();
		
		System.out.println("프로그램 종료");
	}
}














