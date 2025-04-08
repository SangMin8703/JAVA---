import java.util.Scanner;
public class ControlStatement_SWITCH_06 {

	public static void main(String[] args) {
		// 사용자로부터 정수 2개와 사칙연산 부호를 입력받아
		// 계산의 결과를 출력하는 프로그램을 작성하세요.
		// 예시
		// 1 번째 정수를 입력하세요 : 20
		// 2 번째 정수를 입력하세요 : 10
		// 부호를 입력하세요 : +
		// 결과 -> 20 + 10 = 30
		
		// 입력에 사용될 변수
		Scanner sc = new Scanner(System.in);
		int num1, num2;
		char buho;
		
		// 출력에 사용될 변수
		double result;
		
		// 입력 과정 처리
		System.out.print("1 번째 정수를 입력하세요 : ");
		num1 = sc.nextInt();
		System.out.print("2 번째 정수를 입력하세요 : ");
		num2 = sc.nextInt();
		System.out.print("부호를 입력하세요 : ");
		buho = sc.next().charAt(0);
		
		// 처리 과정
		switch( buho ) {
			case '+':	result = num1 + num2;	break;
			case '-':	result = num1 - num2;	break;
			case '*':	result = num1 * num2;	break;
			case '/':	result = num1 / (double)num2;	break;
			default:	
				buho = '?';	
				result = 0;
		}
		
		// 출력 과정
		if( buho != '?' )
			System.out.printf("%d %c %d = %.2f\n", num1, buho, num2, result);
		else
			System.out.println("잘못된 부호가 입력되었습니다.");

	}

}











