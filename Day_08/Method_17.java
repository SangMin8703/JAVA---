import java.util.Scanner;
public class Method_17 {
	public static int getStudentNumber() {
		Scanner sc = new Scanner(System.in);
		System.out.print("학생 수를 입력하세요 : ");
		return sc.nextInt();
	}
	public static int getSubjectNumber() {
		Scanner sc = new Scanner(System.in);
		System.out.print("과목 수를 입력하세요 : ");
		return sc.nextInt();
	}
	public static void input( int [] score ) {
		Scanner sc = new Scanner(System.in);
		for( int i = 0 ; i < score.length ; i++ ) {
			
			do {
				System.out.printf("%d 번째 성적을 입력하세요 : ", i+1);
				score[i] = sc.nextInt();
			} while( score[i] < 0 || score[i] > 100 );
			
		}
	}
	public static void input( int [][] score ) {
		for( int i = 0 ; i < score.length ; i++ ) {
			System.out.printf("%d 번째 학생 성적을 입력합니다.\n", i+1);
			input(score[i]);
		}
	}
	public static int getTotal( int [] score ) {
		int r = 0;
		for(int i = 0 ; i < score.length ; i++)
			r += score[i];
		return r;
	}
	public static float getAverage( int [] score ) {
		return (float)getTotal(score) / score.length;
	}
	public static void output(int [][] score) {
		System.out.println("========================");
		System.out.println("성적을 출력합니다.");		
		System.out.println("========================");
		
		for( int i = 0 ; i < score.length ; i++ ) {
			System.out.printf(
				"%d 번쨰 학생은 총점 %d 점, 평균 %.2f 점 입니다.\n", i+1,
					getTotal(score[i]), getAverage(score[i]));
		}
		
		System.out.println("========================");
	}
	public static void main(String[] args) {		
		int [][] score = 
				new int[getStudentNumber()][getSubjectNumber()];
		
		input(score);
		output(score);
	}
}



















