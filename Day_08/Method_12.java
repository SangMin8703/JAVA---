import java.util.Scanner;
public class Method_12 {
	
	public static void input(Scanner sc, int [] score) {
		for( int i = 0 ; i < score.length ; i++ ) {
			System.out.printf("%d 번째 성적을 입력하세요 : ", i+1);
			score[i] = sc.nextInt();
		}
	}
	
	public static int getTotal(int [] score) {		
		int tot;	
	
		tot = 0;
		for( int i = 0 ; i < score.length ; i++ )
			tot += score[i]; 
		
		return tot;
	}
	
	public static double getAvg(int tot, int [] score) {		
		double avg;		
		avg = (double)tot / score.length;
		
		return avg;
	}
	
	public static void output(int tot, double avg) {
		System.out.printf("입력한 성적의 총점은 %d 점, 평균은 %.2f 점입니다.\n", 
				tot, avg);
	}

	public static void main(String[] args) {
		// 사용자에게 성적 3개를 입력받아
		// 총점과 평균을 출력하는 예제를 작성하세요.
		
		// 입력 변수 선언
		Scanner sc = new Scanner(System.in);
		int [] score = new int[3];
		
		// 출력 변수 선언
		int tot;
		double avg;
		
		// 입력 과정
		input(sc, score);
		
		// 처리 과정
		tot = getTotal(score);
		avg = getAvg(tot, score);
		
		// 출력 과정
		output(tot, avg);
	}

}







