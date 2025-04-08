package exception;

import java.util.InputMismatchException;
import java.util.Scanner;

// try ~ catch ~ finally 구조의 예외처리 방법
// try 블럭 내부에는 입출력에 관련된 스트림을 생성하여 
// 사용하는 경우가 빈번히 발생합니다.
// 이때, 모든 스트림은 사용 후 close 메소드를 호출하여
// 스트림을 닫는 과정이 필요하게 됩니다.
// 하지만 try 와 catch 블럭만을 사용하는 경우
// 스트림을 종료하는 코드가 중복되는 문제점이 발생합니다.

// 이런 문제를 해결하기 위해
// try 블럭의 예외 발생 여부와 상관없이
// 반드시 실행되는 블럭을 추가적으로 작성할 수 있습니다.
// 이러한 블럭은 finally 키워드를 사용하여 정의합니다.

public class Exception_12 {
	public static void main(String[] args) {
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			int input;
			
			System.out.print("정수를 입력하세요 : ");
			// InputMismatchException 타입의 예외가 발생할 수 있는 코드
			input = sc.nextInt();
			
			System.out.printf("input => %d\n", input);
			
			// 위의 sc.nextInt() 실행 코드에서 예외가 발생한다면
			// 그 즉시 실행의 흐름이 catch 구문으로 이동하기 때문에
			// 아래의 close 메소드 호출을 실행되지 않습니다.
			// 반드시 close 메소드를 실행하려면
			// catch 구문에도 동일한 close 실행문이 있어야만 합니다.
			//sc.close();
		} catch(InputMismatchException e) {
			System.out.println("정수를 입력해야합니다.");
			
			// try 구문 내부에서 예외가 발생할 경우
			// Scanner 클래스의 객체를 종료하기 위해 
			// 작성된 실행문입니다.
			// (try 블럭내부와 동일한 코드가 중복)
			//sc.close();
		} finally {		
			// finally 블럭은 예외의 발생 유무와 관계없이
			// 항상 실행되는 영역입니다.
			// 일반적으로 아래와 같이 스트림 등의 종료 코드를 작성하게 됩니다.
			// (코드의 중복 제거 효과를 얻을 수 있음)
			sc.close();
			System.out.println("finally 블럭 실행");
		}		
	}
}














