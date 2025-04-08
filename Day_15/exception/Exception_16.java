package exception;

import java.util.Scanner;

// throw 키워드를 사용한 예외처리 방법
// throw 키워드는 예외를 강제적으로 발생시킬수 있는 키워드
// 모든 Java 의 API 클래스들은 예외적인 상황이 발생되었음을
// 개발자에게 알리기위해서 특정 예외처리 클래스를 사용하여
// throw 를 구현함.

// throw 키워드를 사용하는 이유
// 프로그램의 실행에는 문제가 없지만, 
// 논리적인 오류를 강제로 처리하도록 만들 수 있습니다.
public class Exception_16 {
	public static void process() {
		Scanner sc = new Scanner(System.in);
		int [] jumsu = new int[3];
		int tot = 0;
		double avg;
		
		for( int i = 0 ; i < jumsu.length ; i++ ) {
			System.out.printf("%d 번째 성적을 입력 : ", i+1);
			jumsu[i] = sc.nextInt();
			
			// 성적의 입력이 잘못된 경우 프로그램을 강제로 종료하는 방법
			if( jumsu[i] < 0 || jumsu[i] > 100 ) {
				System.out.println("점수의 입력에 오류가 생겨 프로그램을 종료합니다.");
				return;
			}
			
			tot += jumsu[i];
		}		
		avg = (double)tot / jumsu.length;
		sc.close();
		
		System.out.printf("총점 %d 점, 평균 %.2f 점 입니다.\n", tot, avg);
	}
	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		process();
		System.out.println("프로그램 종료");		
	}
}















