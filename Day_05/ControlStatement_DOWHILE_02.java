import java.util.Scanner;

public class ControlStatement_DOWHILE_02 {

	public static void main(String[] args) {
		// 사용자로부터 정수를 입력받아 화면에 출력하세요.
		// 사용자가 100을 입력할때지 계속해서 수행되는 프로그램을 작성하세요.
		// do ~ while 반복문을 사용

		// 입력 변수 선언
		Scanner sc = new Scanner(System.in);

		// 처리 과정
		do {
			System.out.print("정수를 입력하세요 : ");
		} while (sc.nextInt() != 100);

		sc.close();
		System.out.println("프로그램 종료");

	}

}
