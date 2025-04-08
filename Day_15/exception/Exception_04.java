package exception;
import java.util.Scanner;

// 예외 처리의 방법
// 1. try ~ catch ~ finally 구문을 통해 예외를 처리하는 방법
// 2. throws 키워드를 사용해서 예외를 처리하는 방법
// 3. throw 와 throws 키워드를 사용해서 예외를 처리하는 방법

// try ~ catch 구문을 사용한 예외 처리 방법
// try 블럭 내부에는 예외가 발생할 가능성이 있는 코드를 작성합니다.
// try 블럭 내부에서 예외가 발생할 경우
// Java 가상 머신은 발생한 예외의 타입을 확인한 후
// 예외 객체로 생성합니다.
// 생성된 예외 객체는 catch 구문으로 전달되어 처리됩니다.
//  - 주의사항
//    catch 구문에 정의된 예외처리클래스가
//    try 구문에서 생성된 예외 객체를 받을 수 없는 타입이라면
//    예외를 처리할 수 없습니다.
// 만약 try 블럭 내부에서 어떠한 예외로 발생하지 않는 경우
// 프로그램은 기존의 흐름대로 진행됩니다.
// (catch 구문은 실행되지 않습니다.)
/*
	try {
		작성된 실행 코드 중,
		예외가 발생할 가능성이 있는 코드...
	} catch( 예외처리 클래스 ) {
		예외가 발생할 경우 처리할 실행 코드...
	}
*/

public class Exception_04 {
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
		
		int result = 0;
		try {
			result = num1 / num2;
		} catch(ArithmeticException e) {
			System.out.println("예외가 발생하여 계산하지 못했습니다.");
		}
		
		System.out.printf("%d / %d = %d\n", num1, num2, result);
		sc.close();
		
		System.out.println("프로그램 종료");
	}
}









