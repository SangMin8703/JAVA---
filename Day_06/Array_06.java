import java.util.Scanner;
public class Array_06 {

	public static void main(String[] args) {
		// 사용자에게 5개의 정수를 입력받아
		// 최대값과 최소값을 출력하세요.
		// 그리고 입력된 정수 5개를 오름차순으로 정렬하여 출력하세요.
		
		// 입력 변수 선언
		Scanner sc = new Scanner(System.in);
		int [] input = new int[5];
		
		// 출력 변수 선언
		int max, min;
		
		// 입력 처리
		for( int i = 0 ; i < 5 ; i++ ) {
			System.out.printf("%d 번째 정수 입력 : ", i+1);
			input[i] = sc.nextInt();
		}
		sc.close();
		
		// 처리 과정 수행
		
		// 최대값, 최소값
		// 배열의 첫번째 요소를 기준으로 최대값과 최소값을 설정
		max = min = input[0];
		// 최대값과 최소값을 위한 배열의 비교는 두번째 요소부터 수행
		for( int i = 1 ; i < 5 ; i++ ) {
			if( input[i] > max )
				max = input[i];
			if( min > input[i] )
				min = input[i];
		}
		
		// 오름차순 정렬
		// 현재 정렬되고 있는 위치를 지정하는 외부의 반복문
		// 배열의 첫번째 요소부터 마지막 - 1 까지만 반복을 수행
		for( int i = 0 ; i < 4 ; i++ ) {
			
			// 비교 연산을 위해서 사용된 내부의 반복문
			// 외부 반복문의 위치에 있는 값과 다른 값을 비교하기 위해서 사용
			for( int j = i + 1 ; j < 5 ; j++ ) {
				
				// 오름차순 정렬은 작은 값이 먼저 나와야하므로
				// i 번째의 값이 크다면 서로간의 값을 변경합니다.
				if( input[i] > input[j] ) {
					int swapValue = input[i];
					input[i] = input[j];
					input[j] = swapValue;
				}
				
			}
		}
		
		// 출력 과정 수행
		// 최대값과 최소값 출력
		System.out.printf("입력된 정수 중 최대값은 %d, 최소값은 %d 입니다.\n", max, min);
		// 오름차순 결과 출력
		for( int i = 0 ; i < 5 ; i++ )
			System.out.printf("%d ", input[i]);
		
		

	}

}








