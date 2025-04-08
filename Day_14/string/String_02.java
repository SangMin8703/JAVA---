package string;

public class String_02 {
	public static void main(String[] args) {		
		String str1 = "Hello";
		String str2 = new String("Hello");
		
		// String 클래스의 레퍼런스 변수들이 가지는
		// 참조값을 비교하는 if 문
		if( str1 == str2 )
			System.out.println("str1 과 str2의 문자열은 동일합니다.");
		else
			System.out.println("str1 과 str2의 문자열은 서로 다릅니다.");
				
		// String 클래스는 Object 클래스의 equals 메소드를 오버라이딩하고 있기때문에
		// equals 메소드를 사용하여 두 레퍼런스 변수의
		// 실제 문자열을 비교할 수 있습니다.

		// String 클래스의 레퍼런스 변수들이 참조하는
		// 문자열의 내용이 동일한지 비교하는 if 문
		if( str1.equals(str2) )
			System.out.println("str1 과 str2의 문자열은 동일합니다.");
		else
			System.out.println("str1 과 str2의 문자열은 서로 다릅니다.");
	}
}










