package string;

// StringBuffer, StringBuilder 클래스
// 문자열 저장하기 위한 String 클래스는
// 매번 새로운 문자열 생성하여 참조하는 형태의 구현을 합니다.
// 이런 경우 많은 문자열 변수가 생성되어, GC(가비지 컬렉터)에게 부담을 줄 수 있습니다.
// 만약, 특정 문자열에 대입되는 문자열의 데이터가 고정된 크기의 영역을 가지고 있는 경우
// StringBuffer, StringBuilder 클래스를 활용하여 성능을 높일 수 있습니다.

// StringBuffer, StringBuilder 클래스는 String 클래스와는 달리
// 문자열을 지정된 메모리 공간에 저장하여 사용하는 클래스 입니다.

public class StringBuffer_01 {
	public static void main(String[] args) {
		// 기본 크기를 갖는 StringBuffer 클래스의 객체 생성
		StringBuffer sb = new StringBuffer();
		
		// capacity 의 값이 100 의 크기를 갖는 StringBuffer 클래스의 객체 생성
		// StringBuffer sb = new StringBuffer(100);
		
		// capacity 메소드
		// StringBuffer 클래스의 객체가 저장할 수 있는 메모리의 크기
		System.out.printf("StringBuffer의 크기 : %d\n", sb.capacity());
		
		// append 메소드
		// 현재 StringBuffer 클래스의 객체가 저장하고 있는 문자열의 마지막에
		// 문자열을 추가할 수 있는 메소드
		sb.append("Hello");
		// StringBuffer 의 toString 메소드는 현재 객체가 저장하고 있는 문자열을
		// String 타입으로 반환할 수 있습니다.
		System.out.printf("sb.toString() -> %s\n", sb.toString());
		
		sb.append(" World");
		System.out.printf("sb.toString() -> %s\n", sb.toString());
		
		sb.append("Hello");
		sb.append(" World");
		System.out.printf("sb.toString() -> %s\n", sb.toString());
		// StringBuffer 클래스의 객체는 capacity를 넘어서는 문자열이 추가될 경우
		// 자동으로 용량(capacity)을 증가 시켜줍니다.
		System.out.printf("StringBuffer의 크기 : %d\n", sb.capacity());
		
		// StringBuffer 클래스의 insert 메소드
		// append 메소드는 문자열의 종료지점에 문자열을 추가합니다.
		// 만약, 문자열의 중간에 추가하고자하는 경우는 insert 메소드를 사용할 수 있습니다.
		sb.insert(0, "Insert String");
		System.out.printf("sb.toString() -> %s\n", sb.toString());
		
		// StringBuffer 클래스의 delete 메소드
		// 아래와 같이 두개의 인덱스를 사용하는 경우
		// 1번째 매개변수는 시작 인덱스, 2번째 매개변수는 종료 인덱스를 의미합니다.
		// 아래의 코드는 0 번째 인덱스부터 6-1(5)번째 인덱스까지의 문자열을 삭제하는 코드입니다.
		sb.delete(0, 6);
		System.out.printf("sb.toString() -> %s\n", sb.toString());
		
		// StringBuffer 클래스의 reverse 메소드
		// StringBuffer 클래스의 객체가 저장하고 있는 문자열을 역으로 정렬하는 기능
		sb.reverse();
		System.out.printf("sb.toString() -> %s\n", sb.toString());		
	}
}









