
public class ControlStatement_SWITCH_02 {

	public static void main(String[] args) {
		// break 키워드
		// if 문을 제외한 첫 번째 블럭을 빠져나가는 명령 
		
		int num = 1;		
		
		// switch 구문은 입력된 정수에 해당되는 
		// case 구문의 실행문을 실행한 후, 
		// break 키워드를 만날때까지 계속해서 실행됩니다.
		// 만약 break 키워드가 존재하지 않으면, 
		// switch 문이 종료되는 지점까지 실행됩니다.		
		switch( num ) {
			case 1:
				System.out.println("case 1 실행");
				
			case 2:
				System.out.println("case 2 실행");
				break;
			case 3:
				System.out.println("case 3 실행");
				
			default:
				System.out.println("default 실행");
		}		
	}
}













