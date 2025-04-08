
public class ControlStatement_FOR_13 {

	public static void main(String[] args) {
		// 중첩된 형태의 반복문
		// 반복문 내부에 또 다른 반복문이 정의되는 형태
		// 외부의 반복문이 1 번 실행될 때,
		// 내부의 반복문은 전체가 실행됩니다.
		
		for( int i = 1 ; i <= 3 ; i++ ) {
			
			for( int j = 1 ; j <= 3 ; j++ ) {
				
				System.out.printf("i = %d, j = %d\n", i, j);
				
			}
			
		}

	}

}
