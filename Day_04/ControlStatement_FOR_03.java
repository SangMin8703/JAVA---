
public class ControlStatement_FOR_03 {

	public static void main(String[] args) {
		// for 반복문을 사용 시 주의점
		// for 반복문을 정의하면서 세미콜론을 추가하면
		// 비어있는 실행문이 반복되어 
		// 아래의 예와 같이 원하는 실행문이 반복되지 않습니다.
		for( int i = 1 ; i <= 10 ; i++ ) ;
			System.out.printf("for 반복문의 실행문");

	}

}
