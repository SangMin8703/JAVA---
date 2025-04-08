package string;

import java.util.StringTokenizer;

public class StringTokenizer_02 {
	public static void main(String[] args) {
		String names = "name01;name02?name03_name04!name05";
		
		// 문자열을 구분하는 문자가 다수개일 경우
		// StringTokenizer(문자열, "구붐문자의나열");
		// 아래의 StringTokenizer 객체는
		// ;, ?, _, ! 문자를 기준으로 names 문자열을 분리합니다.
		StringTokenizer st = new StringTokenizer(names, ";?_!");
		
		while( st.hasMoreTokens() ) {			
			String name = st.nextToken();
			System.out.println(name);
		}		

	}
}
