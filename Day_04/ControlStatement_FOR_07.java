import java.util.Scanner;
public class ControlStatement_FOR_07 {

	public static void main(String[] args) {
		// 사용자에게 5개의 정수를 입력받아
		// 합계, 평균, 최대값, 최소값을 출력하세요.
		
		// 입력 변수
		Scanner sc = new Scanner(System.in);
		int input;
		
		// 출력 변수
		int tot, max, min;
		double avg;
		
		// 처리 과정
		
		// 합계를 구하기 위한 tot 변수의 초기화
		tot = 0;
		max = min = 0;
		for( int i = 1 ; i <= 5 ; i++ ) {
			System.out.printf("%d 번째 정수를 입력하세요 : ", i);
			input = sc.nextInt();
			
			// 합계 계산
			tot += input;
			
			// 최대값과 최소값 계산
			if( i == 1 ) {
				// 첫번째 입력된 정수의 값을 
				// 최대값과 최소값의 기준으로 지정
				max = min = input;
			} else {
				// 최대값과 현재 입력된 값을 비교하여
				// 더 큰값이 입력되면 max 변수의 값을 변경
				if( input > max )
					max = input;
				// 최소값과 현재 입력된 값을 비교하여
				// 더 작은값이 입력되면 min 변수의 값을 변경
				if( min > input )
					min = input;			
			}
		}		
		// 평균 계산
		avg = tot / 5.0;
		
		// 출력 과정
		System.out.printf("입력된 정수들의 합계는 %d,\n", tot);
		System.out.printf("입력된 정수들의 평균는 %.2f,\n", avg);
		System.out.printf("입력된 정수들의 최대값은 %d,\n", max);
		System.out.printf("입력된 정수들의 최소값은 %d 입니다.\n", min);

	}
}






