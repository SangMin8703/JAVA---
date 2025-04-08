
public class ControlStatement_FOR_15 {

	public static void main(String[] args) {
		// 중첩된 반복문을 활용한 구구단 예제
		
		// 단 수를 제어하기 위한 외부의 반복문을 정의
		for( int i = 2 ; i <= 9 ; i++ ) {
			
			// 내부의 반복문이 실행되기 이전에 단수를 출력합니다.
			System.out.printf("%d 단을 출력합니다.\n\n", i);
			
			// 단수에 곱해지는 수를 제어하기 위한 내부의 반복문을 정의
			for( int j = 1 ; j <= 9 ; j++ ) {
				
				if( i % 2 == j % 2 )
					System.out.printf("%d * %d = %d\n", i, j, i*j );
				
				/*
				boolean flag1 = (i % 2 == 0 && j % 2 == 0);
				boolean flag2 = (i % 2 == 1 && j % 2 == 1);
				
				if( flag1 || flag2 )
					System.out.printf("%d * %d = %d\n", i, j, i*j );
				*/
				
			}
			
			// 다음 단으로 이동하기 전에 개행을 추가합니다.
			System.out.println();
			
		}

	}

}
