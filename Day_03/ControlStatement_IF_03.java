
public class ControlStatement_IF_03 {

	public static void main(String[] args) {
		// 다수개의 조건식으로 구성된 if 문
		// if ~ else if ~ else
		// 사용법
		// if( 조건문1 )
		//	   조건문1이 참일 경우에 실행될 실행문;
		// else if( 조건문2 )
		//    조건문2이 참일 경우에 실행될 실행문;
		// ...
		// else
		//	  모든 조건문이 거짓일 경우에 실행될 실행문;
				
		int menu = 3;
		
		// menu 변수의 값이 1 이라면 한식, 
		// 2 라면 양식, 3 이라면 중식을 출력하세요.
		
		// if ~ else 를 활용한 처리방법
		// else 구문 내부의 코드가 복잡해집니다.
		if( menu == 1 )
			System.out.println("한식");
		else
			if( menu == 2 )
				System.out.println("양식");
			else
				System.out.println("중식");
		
		// if ~ else if ~ else 구문을 활용한 처리 방법
		if( menu == 1 )
			System.out.println("한식");
		else if( menu == 2 )
			System.out.println("양식");
		else
			System.out.println("중식");		
	}
}









