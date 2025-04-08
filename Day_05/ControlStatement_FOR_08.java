
public class ControlStatement_FOR_08 {

	public static void main(String[] args) {
		// break 키워드의 사용
		// switch, 반복문에서 사용할 수 있는 키워드
		// if 문을 제외한 첫번째 블럭을 빠져나가는 명령
		
		// switch 구문에서 break 키워드가 사용될 경우
		// 해당 지점에서 switch 구문을 종료하고 빠져나가는 의미로 사용
		
		// 반복문에서 break 키워드가 사용되는 경우
		// 현재 지점에서 반복을 종료하고 반복문을 빠져나가는 의미로 사용
		
		for( int i = 1 ; i <= 10 ; i++ ) {
			
			System.out.printf("i = %d\n", i);
			
			if( i == 5 ) {
				break;
			}
			
		}

	}

}












