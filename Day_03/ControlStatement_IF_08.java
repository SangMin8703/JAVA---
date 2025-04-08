import java.util.Scanner;
public class ControlStatement_IF_08 {
	public static void main(String[] args) {
		// 정수 2개와 사칙연산 부호를 입력받아 계산의 결과를 출력하세요
		// 예시
		// 1 번째 정수를 입력하세요 : 20
		// 2 번째 정수를 입력하세요 : 10
		// 부호를 입력하세요 : -
		// 20 - 10 = 10
		
		// 변수 선언		
		// 입력에 사용될 변수의 선언
		Scanner sc = new Scanner(System.in);
		int num1, num2;
		char buho;
		
		// 출력에 사용될 변수의 선언
		// 사칙연산의 결과를 저장할 변수
		double result;
		
		// 입력 과정
		System.out.print("1 번째 정수를 입력하세요 : ");
		num1 = sc.nextInt();
		System.out.print("2 번째 정수를 입력하세요 : ");
		num2 = sc.nextInt();
		System.out.print("부호를 입력하세요 : ");
		// Scanner 클래스의 next 메소드는 
		// 사용자가 엔터키를 입력할 때 까지의 문자열을 반환
		// charAt 메소드는 특정 문자열에서 특정 인덱스 위치의 문자를 반환
		buho = sc.next().charAt(0);
		
		sc.close();
		
		// 처리과정
		if( buho == '+' )
			result = num1 + num2;
		else if( buho == '-' )
			result = num1 - num2;
		else if( buho == '*' )
			result = num1 * num2;
		else if( buho == '/' )
			result = (double)num1 / num2;
		else {
			buho = '?';
			result = 0;
		}
		
		// 출력
		if( buho != '?')
			System.out.printf("%d %c %d = %.2f\n", num1, buho, num2, result);
		else
			System.out.println("잘못된 부호를 입력했습니다.");
	}
}











