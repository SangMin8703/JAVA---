// 변수의 라이프 싸이클(생명 주기)
// 1. 전역변수(클래스의 멤버필드)
// 2. 지역변수 1
//  - 메소드 내부에 선언된 변수
//  - 메소드의 실행 시 메모리에 로딩, 메소드가 종료 시 메모리 해재
// 3. 지역변수 2
//  - 메소드 내부에 선언된 변수
//    메소드 내부의 또 다른 블럭안에 선언된 변수
public class Variable01_LifeCycle {	
	public static void main(String[] args) {
		int i;	// 지역변수 타입 1
		
		// 지역변수 타입 2
		// 메소드 내부에 선언된 블럭에서 만들어진 변수는
		// 해당 블럭이 종료되면 메모리에서 사라집니다.
		for( int j = 1 ; j <= 5 ; j++ ) {
			System.out.println(j);
		}
		
		for( int j = 1 ; j <= 5 ; j++ ) {
			System.out.println(j);
		}
		
		while(true) {
			int j = 1;
			
			if( j == 3 )
				break;
			
			j++;
		}
		
		{
			int j = 10;
			System.out.println(j);
		}
	}
}








