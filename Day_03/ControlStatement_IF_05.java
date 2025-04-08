// import 외부의 기능을 불러서 사용할 수 있도록 해주는 선언문
// Scanner 클래스를 사용하여 입력을 처리하기 위한 사전 작업
import java.util.Scanner;

public class ControlStatement_IF_05 {

	public static void main(String[] args) {
		// 키보드 입력을 처리하기 위한 방법
		// 1. 소스코드의 상단에 import java.util.Scanner; 를 작성
		// 2. Scanner 클래스의 변수를 생성
		//   - Scanner 클래스의 변수 생성 방법
		//   - Scanner sc = new Scanner(System.in);
		// 3. Scanner 클래스의 변수를 사용하여 입력을 처리
		// 4. 입력을 종료한 후 close 메소드를 호출하여 Scanner 클래스의 변수를 종료
		
		// 입력 기능을 수행하기 위한 Scanner 클래스의 sc 변수 선언
		// 변수명은 수정 가능!
		Scanner sc = new Scanner(System.in);
		
		// 입력받은 값을 저장하기 위한 변수의 선언
		int number;
		
		System.out.print("정수를 입력하세요 : ");
		// Scanner 클래스의 nextInt 메소드를 사용하여 키보드로부터 정수 값을 입력
		number = sc.nextInt();
		
		System.out.printf("입력된 정수의 값은 %d 입니다.\n", number);		
		
		// 입력 기능의 사용이 끝난 후에 close 메소드를 호출
		sc.close();
	}
}











