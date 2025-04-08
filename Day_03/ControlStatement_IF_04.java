
public class ControlStatement_IF_04 {

	public static void main(String[] args) {
		// if 문의 사용 시 주의할 점
		// if, else if, else 구문은
		// 블럭이 지정되지 않으면 
		// 하나의 실행문을 실행할 수 있습니다.
		// 만약 블럭이 지정되어 있다면
		// 하나 이상의 실행문을 실행할 수 있습니다.
		
		int number = 10;
		
		// if 문은 하나의 실행문 만을 실행할 수 있기때문에
		// 아래와 같이 두개의 실행문을 작성할 수 없습니다.
		/*
		if( number % 2 == 0 )
			System.out.println("짝수 입니다.");
			System.out.println("짝수 입니다.");
		else
			System.out.println("홀수 입니다.");
		*/
		
		// 만약, if 문의 조건이 참인 경우
		// 다수개의 실행문을 실행하고자 한다면
		// if, else if, else 구문의 블럭을 지정해야합니다.
		if( number % 2 == 0 ) {
			System.out.println("짝수 입니다.");
			System.out.println("짝수 입니다.");
		} else
			System.out.println("홀수 입니다.");
	}

}













