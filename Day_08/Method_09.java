import java.util.Scanner;
public class Method_09 {
	
	public static void input(Scanner sc, int [] score) {
		// 입력 과정
		
		// call by reference 방식의 메소드 호출이기 때문에
		// 입려된 데이터는 main 메소드에서도 사용할 수 있습니다.
		for( int i = 0 ; i < score.length ; i++ ) {
			System.out.printf("%d 번째 성적을 입력하세요 : ", i+1);
			score[i] = sc.nextInt();
		}
	}
	
	public static void output(int [] score) {
		// 출력 변수
		int tot;
		double avg;
		
		// 처리 과정
		tot = 0;
		for( int i = 0 ; i < score.length ; i++ )
			tot += score[i]; 
		
		avg = (double)tot / score.length;
		
		// 출력 과정
		System.out.printf("입력한 성적의 총점은 %d 점, 평균은 %.2f 점입니다.\n", 
				tot, avg);
	}

	public static void main(String[] args) {
		// 사용자에게 성적 3개를 입력받아
		// 총점과 평균을 출력하는 예제를 작성하세요.
		
		// 입력 변수 선언
		Scanner sc = new Scanner(System.in);
		int [] score = new int[3];
		
		input(sc, score);
		
		output(score);
	}

}







