import java.util.Scanner;

// 학생의 이름과 3과목의 성적을 입력받아
// 총점과 평균 값을 출력할 수 있는 Grade 클래스를 작성하세요.
class Grade {
	// 멤버필드
	// 입력
	private String name;
	private int [] score;
	// 출력
	private int tot;
	private double avg;
	
	public Grade() {
		// Grade 클래스의 객체가 생성될 때,
		// 성적 점수를 저장하기 위한 배열을 생성
		score = new int[3];
	}	
	public void input() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("학생 이름을 입력하세요 : ");
		name = sc.next();
		
		for( int i = 0 ; i < score.length ; i++ ) {
			System.out.printf("%d 번째 성적을 입력하세요 : ", i+1);
			score[i] = sc.nextInt();
			tot += score[i];
		}
		
		avg = (double)tot / score.length;
		
		sc.close();
	}	
	public void output() {
		System.out.printf("%s 학생의 성적 정보를 출력합니다.\n", name);
		
		System.out.println("===================");
		for( int i = 0 ; i < score.length ; i++ )
			System.out.printf("%d : %d 점\n", i+1, score[i]);
		System.out.println("===================");
		
		System.out.printf("총점 : %d 점\n", tot);
		System.out.printf("평균 : %.2f 점\n", avg);
	}
}
public class Class_Constructor_07 {
	public static void main(String[] args) {		
		// 실행 코드
		Grade g = new Grade(); 
		g.input();
		g.output();
	}
}
 





