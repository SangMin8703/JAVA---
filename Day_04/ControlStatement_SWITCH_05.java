import java.util.Scanner;

public class ControlStatement_SWITCH_05 {

	public static void main(String[] args) {
		// 사용자에게 3개의 점수를 입력받아
		// 총점과 평균을 출력하세요.
		// 그리고 평균 점수를 사용하여 사용자의 평가를 출력하세요
		// 90점 이상 A, 80점 이상 B, 70점 이상 C, 60점 이상 D, 60 미만일 경우 F
		
		// 입력에 사용할 변수
		Scanner sc = new Scanner(System.in);
		int num1, num2, num3;
		
		// 출력에 사용할 변수
		int tot;
		double avg;
		char grade;
		
		// 입력 처리
		System.out.print("1 번째 성적을 입력하세요 : ");
		num1 = sc.nextInt();
		System.out.print("2 번째 성적을 입력하세요 : ");
		num2 = sc.nextInt();
		System.out.print("3 번째 성적을 입력하세요 : ");
		num3 = sc.nextInt();
		
		// 처리 과정
		tot = num1 + num2 + num3;
		avg = tot / 3.0;
					
		switch( (int)avg / 10 ) {
			case 10:				
			case 9:
				grade = 'A';	break;
			case 8:
				grade = 'B';	break;
			case 7:
				grade = 'C';	break;
			case 6:
				grade = 'D';	break;
			case 5:				
			case 4:				
			case 3:
			case 2:
			case 1:
			case 0:
				grade = 'F';	break;			
			default:
				grade = '?';	break;			
		}
		
		System.out.printf("입력한 성적의 총점은 %d 점, 평균은 %.2f 점 입니다.\n", tot, avg);
		
		if( grade != '?' )
			System.out.printf("입력한 성적의 평가는 %c 입니다.\n", grade);
		else
			System.out.println("입력된 성적 점수를 확인하세요.");
	}
}












