import java.util.Scanner;
public class ControlStatement_IF_09 {

	public static void main(String[] args) {
		// 사용자의 3개의 성적 정보를 저장하는 변수를 생성하고
		// 사용자가 입력한 값으로 초기화 하세요.
		// 3개의 성적 정보를 활용하여 사용자의 총점과 평균 점수를 출력하세요.	

		// 키보드 입력을 처리하기 위한 Scanner 변수
		Scanner sc = new Scanner(System.in);
		
		// 성적 저장을 위한 변수 3개
		int num_1, num_2, num_3;

		// 성적 입력 처리
		System.out.print("1 번째 성적을 입력하세요 : ");
		num_1 = sc.nextInt();
		System.out.print("2 번째 성적을 입력하세요 : ");
		num_2 = sc.nextInt();
		System.out.print("3 번째 성적을 입력하세요 : ");
		num_3 = sc.nextInt();
		sc.close();

		// 총점을 저장하기 위한 변수
		int tot;
		// 평균을 저장하기 위한 변수
		double avg;

		// 출력해야 하는 정보를 추출하기 위한 처리과정을 수행
		tot = num_1 + num_2 + num_3;		
		avg = tot / 3.0;

		// 프로그램의 수행 결과를 출력
		System.out.printf("사용자의 총점은 %d 점, 평균은 %.2f 점 입니다.\n", tot, avg);

		// 만약, 사용자의 평균 점수가 90 점 이상이라면,
		// "우수한 성적입니다" 라는 메세지를 출력하세요.
		// 90점 미만의 평균 점수일 경우는
		// "조금 더 분발하세요" 라는 메세지를 출력하세요.

		// 출력 메세지를 저장하기 위한 변수 선언
		// 문자열을 저장하기 위한 String 타입
		String strMsg = "";
		if( avg >= 90 )
			strMsg = "우수한 성적입니다";
		else
			strMsg = "조금 더 분발하세요";		
		
		System.out.printf("%s\n", strMsg);
		
		// 평균 점수를 기준으로 평가를 출력하세요.
		// 평균 점수가 90 점 이상일 경우 A
		// 평균 점수가 80 점 이상일 경우 B
		// 평균 점수가 70 점 이상일 경우 C
		// 평균 점수가 60 점 이상일 경우 D
		// 평균 점수가 60 점 미만일 경우 F
		// EX) 사용자의 평가 결과는 'A' 입니다.
		char grade;
		
		if( avg >= 90 )
			grade = 'A';
		else if( avg >= 80 )
			grade = 'B';
		else if( avg >= 70 )
			grade = 'C';
		else if( avg >= 60 )
			grade = 'D';
		else
			grade = 'F';
		
		System.out.printf("사용자의 평가 결과는 '%c' 입니다.\n", grade);
	}
}







