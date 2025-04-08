package string;

import java.util.StringTokenizer;

// StringTokenizer
// 문자열 내부의 구분 문자를 사용하여 
// 하나의 문자열을 다수개의 문자열로 분리하여 
// 처리할 수 있는 기능을 제공하는 클래스

public class StringTokenizer_01 {
	public static void main(String[] args) {
		String names = "name01;name02;name03";
		
		// StringTokenizer 클래스의 객체 생성 방법
		// StringTokenizer(문자열, 구분문자열);
		// 아래의 st 레퍼런스는 names 문자열을 ; 을 기준으로
		// 문자열을 분리하는 StringTokenizer 객체를 참조합니다.
		StringTokenizer st = new StringTokenizer(names, ";");
		
		// StringTokenizer 클래스의 객체는
		// 구분 문자열을 기준으로 잘라놓은 각각의 문자열을 token 으로 칭합니다.
		// 각각의 토큰에 접근하기 위해서 hasMoreTokens 메소드를 호출합니다.
		// hasMoreTokens 메소드는 다음에 접근할 토큰의 여부를 판별하여
		// boolean 타입의 값을 반환합니다.
		while( st.hasMoreTokens() ) {
			// StringTokenizer 클래스의 객체는 
			// nextToken 메소드를 사용하여 각가의 토큰(문자열)을 반환합니다.
			// 아래의 name 변수는 반복이 진행되면서
			// names 문자열에 포함된
			// name01, name02, name03 의 문자열 값을 반환받습니다.
			String name = st.nextToken();
			System.out.println(name);
		}		

	}
}






