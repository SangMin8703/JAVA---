
public class ControlStatement_DOWHILE_01 {

	public static void main(String[] args) {
		// do ~ while 반복문
		// do ~ while 반복문은 while 반복문과 마찬가지로
		// 불특정한 횟수의 반복을 제어하고자 하는 경우 사용합니다.
		
		// do ~ while 반복문은 한번의 실행을 보장해주는 반복문입니다.
		
		// 사용법		
		/*
		   do {
		   	  실행문;
		   } while( 조건식 );		
		*/
		
		// do ~ while 반복문의 작성 시 주의사항
		// 1. do ~ while 반복문은 반드시 중괄호 {} 를 사용해서 정의해야 합니다.
		// 2. do ~ while 반복문은 while(조건식) 을 작성후에 
		//    반드시 ; 으로 마무리해야합니다.
		
		int i = 1;
		
		do {
			System.out.printf("i = %d\n", i);
			i++;
		} while(i < 10);
		
		System.out.printf("반복문의 종료 이후 : i = %d\n", i);

	}

}










