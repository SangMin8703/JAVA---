import java.util.Scanner;
public class ControlStatement_FOR_10 {

	public static void main(String[] args) {
		// 사용자에게 정수 2개와 부호를 입력받아
		// 사칙연산의 결과를 제공하는 프로그램을 작성하세요.
		// 프로그램은 사용자가 종료를 원할경우에 종료합니다.
		
		// 입력 변수 선언
		Scanner sc = new Scanner(System.in);
		int num1, num2;
		char buho;
		// 종료를 원하는지 확인하기 위해서 입력받는 문자
		char exitFlag;
		
		// 출력 변수 선언
		double result;

		// 처리 과정
		
		System.out.println("프로그램 시작");
		// 사용자가 종료를 원할때까지 계속해서 수행해야 하므로
		// 무한루프의 형태로 반복문을 선언합니다. 
		for(;;) {
			
			System.out.print("1 번째 정수를 입력하세요 : ");
			num1 = sc.nextInt();
			System.out.print("2 번째 정수를 입력하세요 : ");
			num2 = sc.nextInt();
			System.out.print("부호를 입력하세요 : ");
			buho = sc.next().charAt(0);
			
			switch(buho) {
				// 반복문 내부의 switch 구문에서 break 키워드를 사용하면
				// 반복문을 종료하는 것이 아닌 switch 구문을 종료합니다. 
				case '+':	result = num1 + num2;	break;
				case '-':	result = num1 - num2;	break;
				case '*':	result = num1 * num2;	break;
				case '/':	result = (double)num1 / num2;	break;
				default:	buho = '?';	result = 0;					
			}
			
			if( buho != '?' )
				System.out.printf("%d %c %d = %.2f\n", num1, buho, num2, result);
			else
				System.out.println("잘못된 부호를 입력했습니다.");
		
			// 사용자가 종료를 원하는 지 확인하여 반복을 종료할 수 있도록 구현
			System.out.print("종료하시겠습니까? (y/n) : ");
			exitFlag = sc.next().charAt(0);
			if( exitFlag == 'y' || exitFlag == 'Y')
				break;
		}		
		
		sc.close();
		System.out.println("프로그램 종료");			
	}

}













