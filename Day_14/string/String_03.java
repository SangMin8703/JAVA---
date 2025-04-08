package string;

import java.util.StringTokenizer;

public class String_03 {
	public static void main(String[] args) {
		// 문자열 비교와 공백문자(스페이스, 탭, 엔터)
		String str1 = "Hello";
		String str2 = new String(" Hello ");
		
		if( str1.equals(str2) )
			System.out.println("str1 과 str2의 문자열은 동일합니다.");
		else
			System.out.println("str1 과 str2의 문자열은 서로 다릅니다.");
		
		// 문자열에 존재하는 공백문자를 제거할 수 있는 trim 메소드
		// trim 메소드는 해당 String 클래스의 레퍼런스가 참조하는 문자열의
		// 공백을 제거하는 메소드입니다.
		// 주의사항
		// 문자열의 앞뒤에 존재하는 공백을 제거
		// 문자열의 내부(사이)에 존재하는 공백을 제거할 수 없습니다.
		str2.trim();		
		
		// String 클래스의 모든 메소드는 메소드의 실행 결과로
		// 새롭게 만들어진 문자열을 반환하기 때문에
		// 반드시 대입받아 사용해야 합니다.
		// str2 는 여전히 앞뒤에 공백이 있는 문자열을 참조하는 상황
		if( str1.equals(str2) )
			System.out.println("str1 과 str2의 문자열은 동일합니다.");
		else
			System.out.println("str1 과 str2의 문자열은 서로 다릅니다.");
		
		// str2 레퍼런스에 앞뒤의 공백이 제거된
		// 새로운 문자열을 대입하는 코드
		str2 = str2.trim();
		// 앞뒤의 공백이 제거된 문자열을 str2 가 참조하기 때문에
		// 아래의 분기문의 결과는 참이 됩니다.
		if( str1.equals(str2) )
			System.out.println("str1 과 str2의 문자열은 동일합니다.");
		else
			System.out.println("str1 과 str2의 문자열은 서로 다릅니다.");

	}
}








