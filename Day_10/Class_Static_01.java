// static 키워드
// static 키워드는 클래스, 멤버필드, 멤버메소드에 사용할 수 있습니다.

// static 키워드를 사용한 멤버필드
// 1. 공유
//  - 하나의 클래스로부터 생성된 모든 객체들이 
//    공유하게 되는 멤버를 선언할 수 있습니다.
// 2. 정적 멤버

class S_1 {
	// 일반 멤버 필드인 n 변수 선언
	// static 키워드가 사용되지 않은 일반 멤버필드는 모든 객체들에게
	// 각각 할당되는 멤버입니다.
	public int n;
	// static 멤버 필드인 s 변수 선언
	// static 키워드가 사용된 멤버 필드는
	// 모든 객체들이 공유하게 되는 멤버입니다.
	// (static 멤버필드는 단 하나만 생성되어, 모든 객체들이 공유합니다.)
	public static int s;
}
public class Class_Static_01 {
	public static void main(String[] args) {
		// Java 프로그램의 실행 과정
		// 1. 소스 코드에서 사용된 상수들이 STACK에 로딩
		// 2. 소스 코드에서 정의된 static 멤버, 메소드가 STACK에 로딩
		// 3. STACK 내부의 static 영역에서
		//    main 메소드를 검색하여 실행		
		S_1 s1 = new S_1();
		S_1 s2 = new S_1();
		S_1 s3 = new S_1();		
		
		// static 멤버 필드, 멤버 메소드는 프로그램의 실행 이전부터
		// 메모리에 로딩되어 존재하는 멤버입니다.
		// 그렇기 때문에, 각각의 객체마다 따로 할당되는것이 아닌
		// 모든 객체가 하나의 static 멤버를 참조하는 모습을 갖게됩니다.
		
		// s1 레퍼런스를 사용한 s 변수는 s1, s2, s3 이 공유하게 되는 변수
		s1.n = 10;	s1.s = 100;
		System.out.printf("s1.n = %d, s1.s = %d\n", s1.n, s1.s);
		// s2 레퍼런스를 사용한 s 변수는 s1, s2, s3 이 공유하게 되는 변수
		s2.n = 20;	s2.s = 200;
		System.out.printf("s2.n = %d, s2.s = %d\n", s2.n, s2.s);
		// s3 레퍼런스를 사용한 s 변수는 s1, s2, s3 이 공유하게 되는 변수
		s3.n = 30;	s3.s = 300;
		System.out.printf("s3.n = %d, s3.s = %d\n", s3.n, s3.s);
		
		System.out.printf("s1.s = %d, s2.s = %d, s3.s = %d\n", s1.s, s2.s, s3.s);
	}
}










