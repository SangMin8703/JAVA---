
public class ControlStatement_FOR_04 {

	public static void main(String[] args) {
		// 1 에서 100 까지의 정수 중, 
		// 홀수만 출력하는 반복문을 작성하세요.
		
		// 제어문은 서로 중첩되어 사용될 수 있습니다.
		// for 반복문 내부에서 if 문을 사용하면
		// 반복문의 실행 여부를 조건에 따라 결정할 수 있습니다.
		for( int i = 1 ; i <= 100 ; i++ ) {
			
			if( i % 2 == 1 )
				System.out.printf("i = %d\n", i);
			
		}

	}

}
