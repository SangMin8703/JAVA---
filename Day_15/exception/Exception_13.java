package exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Exception_13 {
	public static void main(String[] args) {
		// finally 블럭은 대다수의 경우 리소스의 종료 코드를 작성합니다.
		// Exception_12 클래스에서 확인했듯이
		// sc.close() 와 같은 메소드 호출을 사용해
		// 리소스를 종료합니다.
		
		// JDK 1.8 에서는 finally 블럭의 제거를 위해 try 블럭의 선언 시
		// 자동 종료를 할 수 있는 입출력 스트림의 생성을 지원합니다. 
		
		// 아래의 코드는 try 블럭을 실행하면서 Scanner의 객체를 생성하는 코드입니다.
		// 추가적으로 해당 try ~ catch ~ finally 영역 모두 종료될 때,
		// Scanner 클래스의 객체는 자동으로 close 메소드가 호출됩니다.
		try (Scanner sc = new Scanner(System.in) ) {
			int input;
			
			System.out.print("정수를 입력하세요 : ");			
			input = sc.nextInt();
			
			System.out.printf("input => %d\n", input);
			
		} catch(InputMismatchException e) {
			System.out.println("정수를 입력해야합니다.");
		} finally {		
			//sc.close();
			System.out.println("finally 블럭 실행");
		}		
	}
}
