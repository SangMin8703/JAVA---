import java.util.Scanner;

public class ControlStatement_SWITCH_04 {

	public static void main(String[] args) {
		// 사용자에게 1 ~ 12 까지의 정수를 입력받아
		// 해당 월의 일수를 출력하는 프로그램을 작성하세요.
		// 예시
		// 1 ~ 12 까지의 정수를 입력하세요 : 1
		// 1 월은 31일 까지 있습니다.
		
		// 입력에 사용할 변수
		Scanner sc = new Scanner(System.in);
		int month;
		
		// 출력에 사용할 변수
		int day;
		
		// 입력 과정 처리
		System.out.print("1 ~ 12 까지의 정수를 입력하세요 : ");
		month = sc.nextInt();
		sc.close();
		
		// 처리 과정
		switch( month ) {
			case 1 :				
			case 3 :				
			case 5 :				
			case 7 :				
			case 8 :				
			case 10 :				
			case 12 :
				day = 31;
				break;
			case 4 :				
			case 6 :				
			case 9 :				
			case 11 :
				day = 30;
				break;
			case 2 :
				day = 28;
				break;
			default :
				day = -1;
		}
		
		// 출력 처리
		if( day != -1 )
			System.out.printf("%d 월은 %d 일 까지 있습니다.\n", month, day);
		else
			System.out.println("범위를 벗어난 값을 입력했습니다.\n");

	}

}











