package exception;
import java.util.Scanner;

// throw 키워드의 사용법
// throw 예외처리클래스의 객체;
// EX) throw new Exception("점수의 입력에 오류가 생겨 프로그램을 종료합니다.");

public class Exception_17 {
	public static void process() throws Exception {
		Scanner sc = new Scanner(System.in);
		int [] jumsu = new int[3];
		int tot = 0;
		double avg;
		
		for( int i = 0 ; i < jumsu.length ; i++ ) {
			System.out.printf("%d 번째 성적을 입력 : ", i+1);
			jumsu[i] = sc.nextInt();
			
			// 성적의 입력이 잘못된 경우 프로그램을 강제로 종료하는 방법
			if( jumsu[i] < 0 || jumsu[i] > 100 ) {
				// 성적의 입력이 잘못된 경우
				// 예외처리 클래스의 객체를 생성하여
				// 예외를 발생시킴
				// throw 키워드를 사용하여 강제로 예외를 발생시키면
				// 반드시 예외처리를 해야합니다.
				// 1. throws 를 사용한 예외를 떠넘기기
				// 2. try ~ catch 를 사용한 예외처리		
				
				// 강제로 예외를 발생시키고자하는 경우 반드시 throw 키워드와 함께
				// 예외처리 객체를 전달해야합니다.
				// 단순히 예외처리클래스의 객체를 생성하는 것은 예외가 발생되지 않습니다.
				
				// Exception 클래스의 객체를 생성하면서
				// 생성자의 매개변수에 문자열을 전달하면
				// 해당 객체의 getMessage() 메소드로 
				// 해당 문자열의 값을 확인할 수 있습니다.
				throw new Exception("점수의 입력에 오류가 생겨 프로그램을 종료합니다.");
			}
			
			tot += jumsu[i];
		}		
		avg = (double)tot / jumsu.length;
		sc.close();
		
		System.out.printf("총점 %d 점, 평균 %.2f 점 입니다.\n", tot, avg);
	}
	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		
		try {
			
			process();
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
		System.out.println("프로그램 종료");		
	}
}











