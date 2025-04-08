
public class ControlStatement_FOR_11 {

	public static void main(String[] args) {
		// continue 키워드
		// continue 키워드는 반복문에서만 사용이 가능합니다.
		// continue 현재의 반복을 중지하고 다음 반복으로 이동하는 역할을 제공
		
		// continue 키워드의 정의
		// if 문을 제외한 첫 번째 블럭의 종료 지점으로 이동하는 명령
		
		for( int i = 1 ; i <= 10 ; i++ ) {
			
			if( i == 4 )
				continue;
			
			System.out.printf("i = %d\n", i);			
			
		}

	}

}
