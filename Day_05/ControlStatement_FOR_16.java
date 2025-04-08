import java.util.Scanner;
public class ControlStatement_FOR_16 {

	public static void main(String[] args) {
		// 사용자로부터 3 개의 성적 점수를 입력받아 
		// 합계와 평균 점수를 출력하세요.
		// 프로그램의 종료는 사용자가 원할때 이뤄집니다.
		
		// 성적을 입력받을 때, 중첩된 반복문을 사용하여  
		// 0 에서 100 사이의 값 만을 입력받을 수 있도록 구현하세요.
		
		// 입력 변수
		Scanner sc = new Scanner(System.in);
		int num1, num2, num3;
		char exitFlag;
		
		// 출력 변수
		int tot;
		double avg;
		
		for(;;) {
			// 0 에서 100 까지의 정수가 입력될때까지 
			// 계속해서 입력받는 내부의 반복문을 구현  
			for(;;) {
				System.out.print("1 번째 성적을 입력하세요 : ");
				num1 = sc.nextInt();
				
				if( num1 >= 0 && num1 <= 100 )
					break;
			}
			for(;;) {
				System.out.print("2 번째 성적을 입력하세요 : ");
				num2 = sc.nextInt();
				
				if( num2 >= 0 && num2 <= 100 )
					break;
			}
			for(;;) {
				System.out.print("3 번째 성적을 입력하세요 : ");
				num3 = sc.nextInt();
				
				if( num3>= 0 && num3 <= 100 )
					break;
			}			
			
			tot = num1 + num2 + num3;
			avg = tot / 3.0;
			
			System.out.printf("입력된 성적의 총점은 %d 점, 평균은 %.2f 점입니다.\n", 
					tot, avg);
			
			System.out.print("종료 하시겠습니까?(y/n) : ");
			exitFlag = sc.next().charAt(0);
			
			if( exitFlag == 'y' || exitFlag == 'Y' )
				break;
		}
		
		sc.close();
		System.out.println("프로그램 종료");
		

	}

}







