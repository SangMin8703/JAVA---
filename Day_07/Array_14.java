import java.util.Scanner;

public class Array_14 {

	public static void main(String[] args) {
		// 사용자로부터 학생 2명의 성적을 입력받아
		// 각 학생의 총점과 평균을 출력하세요.
		// 성적은 3과목으로 이루어져 있고, 각 과목은 국어, 영어, 수학 입니다.

		// 예시
		// 1 번째 학생의 국어 성적을 입력하세요 : 100
		// 1 번째 학생의 영어 성적을 입력하세요 : 100
		// 1 번째 학생의 수학 성적을 입력하세요 : 100
		// 2 번째 학생의 국어 성적을 입력하세요 : 90
		// 2 번째 학생의 영어 성적을 입력하세요 : 90
		// 2 번째 학생의 수학 성적을 입력하세요 : 90
		
		// 1번째 학생의 총점은 300 점, 평균은 100.00 점 입니다.
		// 2번째 학생의 총점은 270 점, 평균은 90.00 점 입니다.
		
		// 프로그램 내부에서 사용할 변수
		String [] subjects = {"국어", "영어", "수학"};
		
		// 입력 변수의 선언
		Scanner sc = new Scanner(System.in);
		int [][] score = new int[2][3];
		
		// 출력 변수의 선언
		int [] tot = new int[2];
		double [] avg = new double[2];
		
		// 입력 과정
		// 각각의 학생을 구분하기 위한 외부의 반복문
		for( int i = 0 ; i < 2 ; i++ ) {
			System.out.printf("%d 번째 학생의 성적 입력을 시작합니다.\n", i+1);
			
			// 각 학생의 성적을 입력받기 위한 내부의 반복문
			for( int j = 0 ; j < 3 ; j++ ) {
				System.out.printf("%d 번째 학생의 %s 성적을 입력하세요 : ", 
						i+1, subjects[j]);
				
				score[i][j] = sc.nextInt();
				
				// 성적이 입력되면서 총점을 같이 계산하도록 처리
				// HEAP 에 생성된 변수는 초기화가 지원되기 때문에
				// tot 배열을 초기화할 필요가 없습니다.
				tot[i] += score[i][j];
			}
			
			// 한명의 학생 성적 입력이 완료되면 평균을 계산하도록 처리
			avg[i] = tot[i] / 3.0;			
		}
		
		// 출력과정
		for( int i = 0 ; i < 2 ; i++ ) {
			System.out.printf("%d 번째 학생의 총점은 %d 점, 평균은 %.2f 점 입니다.\n", 
					i+1, tot[i], avg[i]);
		}
		
		sc.close();		
	}
}











