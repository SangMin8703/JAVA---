import java.util.Scanner;

public class Array_16 {

	public static void main(String[] args) {
		// 사용자로부터 성적을 처리할 학생수와 과목수를 입력받아
		// 배열을 생성하고, 값을 입력받으세요.
		// 각 학생의 총점과 평균을 출력하세요.

		// 예시
		// 성적을 처리할 학생 수를 입력하세요 : 2
		// 과목 수를 입력하세요 : 3
		// 1번째 학생의 성적입력을 시작합니다.
		// 1 번째 학생의 1번째 성적을 입력하세요 : 100
		// 1 번째 학생의 2번째 성적을 입력하세요 : 100
		// 1 번째 학생의 3번째 성적을 입력하세요 : 100
		// 2 번째 학생의 1번째 성적을 입력하세요 : 90
		// 2 번째 학생의 2번째 성적을 입력하세요 : 90
		// 2 번째 학생의 3번째 성적을 입력하세요 : 90

		// 1번째 학생의 총점은 300 점, 평균은 100.00 점 입니다.
		// 2번째 학생의 총점은 270 점, 평균은 90.00 점 입니다.

		// 입력 변수 선언
		Scanner sc = new Scanner(System.in);
		// 성적 점수 저장 배열
		int[][] score;
		// 학생수
		int student;
		// 과목수
		int subject;
		// 과목명
		String[] subjects;

		// 출력 변수 선언
		// 총점
		int[] tot;
		// 평균
		double[] avg;

		// 입력 과정
		System.out.print("성적을 처리할 학생 수를 입력하세요 : ");
		student = sc.nextInt();
		System.out.print("과목 수를 입력하세요 : ");
		subject = sc.nextInt();

		// 사용자가 입력한 학생수와 과목수를 사용하여 2차원 배열을 생성
		score = new int[student][subject];

		// 과목명을 저장하기 위한 배열 생성
		subjects = new String[subject];

		for (int i = 0; i < subjects.length; i++) {
			System.out.printf("%d 번째 과목명을 입력하세요 : ", i+1);
			// 사용자가 입력한 문자열 사용하여 과목명을 저장
			subjects[i] = sc.next();
		}

		// 각 학생의 총점과 평균을 저장하기 위한 배열을 생성
		tot = new int[student];
		avg = new double[student];
		
		// 성적 입력
		for( int i = 0 ; i < score.length ; i++ ) {
			System.out.printf("%d 번째 학생의 성적 입력을 시작합니다.\n", i+1);			
			for( int j = 0 ; j < score[i].length ; j++ ) {
				System.out.printf("%d 번째 학생의 %s 성적을 입력하세요 : ", 
						i+1, subjects[j]);
				score[i][j] = sc.nextInt();
				tot[i] += score[i][j];
			}
			avg[i] = tot[i] / (double)score[i].length;
		}
		
		// 출력과정
		for( int i = 0 ; i < score.length ; i++ ) {
			System.out.printf("%d 번째 학생의 총점은 %d 점, 평균은 %.2f 점 입니다.\n", 
					i+1, tot[i], avg[i]);
		}
		
		sc.close();
	}
}














