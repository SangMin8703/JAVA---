
public class ControlStatement_WHILE_01 {

	public static void main(String[] args) {
		// while 반복문
		// 조건식을 기준으로 반복의 여부를 결정하여
		// 실행문을 반복해서 실행할 수 있는 반복문
		
		// 사용법
		/*
		   while( 조건식 )
		   	  조건식이 참일 경우에 실행될 실행문;
		*/
		
		// while 반복문이 사용되는 경우
		// while 반복문은 불특정한 횟수의 반복을 제어하는 경우에 사용됩니다.
		// 파일 처리와 같은 역할 수행
		
		// for 반복문은 반복의 횟수를 지정하여 처리하는 경우 사용됩니다.
		// 배열처리 등과 같은 역할을 수행
		for( int i = 0 ; i < 10 ; i++ )
			System.out.println(i);
		
		int i = 1;

		while( i <= 10 ) {
			System.out.printf("i = %d\n", i);
			i++;
		}
		
		System.out.printf("반복문 종료 후 : i = %d\n", i);
	}

}













