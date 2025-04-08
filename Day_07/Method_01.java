import java.util.Scanner;

public class Method_01 {
	
	public static void printGuGuDan(int dan) {
		System.out.println("-------------------");
		System.out.printf("%d 단을 출력합니다.\n", dan);
		System.out.println("-------------------");
		for( int i = 1 ; i < 10 ; i++ ) {
			System.out.printf("%d * %d = %d\n", dan, i, dan * i);
		}
	}
	
	public static boolean isExit(Scanner sc) {
		System.out.print("프로그램을 종료 하시겠습니까? (y/n) : ");
		char exitFlag = sc.next().charAt(0);		
		
		return (exitFlag == 'y' || exitFlag == 'Y');
	}

	public static void main(String[] args) {
		// method - 메소드
		// 실행 코드의 재활용을 위해 사용되는 문법
		// 중복되는 실행 코드를 한곳에 모아 관리할 수 있습니다.
		
		// 사용자에게 구구단의 단수를 입력받아,
		// 해당 구구단을 출력하는 예제를 작성하세요.
		// 프로그램의 종료는 사용자에게 확인한 후 종료하세요.
		
		// 예시
		// 구구단의 단 수를 입력하세요 : 5
		// 5 단을 출력합니다.
		// 5 * 1 = 5
		// ...
		
		// 프로그램을 종료 하시겠습니까? (y/n) : 
		
		// 입력 변수 선언
		Scanner sc = new Scanner(System.in);
		int dan;
		char exitFlag;
		
		// 입력 과정
		do {			
			System.out.print("구구단의 단 수를 입력하세요 : ");
			dan = sc.nextInt();
			
			printGuGuDan(dan);		
			
		} while( !isExit(sc) );	
		
		do {			
			System.out.print("구구단의 단 수를 입력하세요 : ");
			dan = sc.nextInt();
			
			printGuGuDan(dan);		
			
		} while( !isExit(sc) );	
		
		
		System.out.println("프로그램 종료");
	}

}







