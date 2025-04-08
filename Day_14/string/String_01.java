package string;

// 문자열을 저장하기 위한 클래스
// String, StringBuilder, StringBuffer
// 1. String
//  - 불변 객체 타입의 문자열 저장 클래스 
//  - 문자열을 참조만 할 뿐, 값을 수정할 수 없는 클래스
//  - 문자열의 연산이 일어날 경우, 새로운 문자열 생성하여 참조하는 클래스

// String 클래스의 객체 생성 방법
// 1. String 클래스의 레퍼런스에 문자열을 대입하는 방법
//  - String str = "Hello";
//  - 상수 영역에 존재하는 문자열 "Hello" 를 참조하게 됩니다.(HEAP 에 생성되는 것이 아님)
// 2. String 클래스의 레퍼런스에 객체를 생성하여 문자열을 대입하는 방법
//  - String str = new String("Hello");
//  - 상수 영역에 존재하는 문자열 "Hello"를 사용하여 HEAP 에 문자열 객체를 생성하고
//    그 곳을 참조하게 됩니다.
public class String_01 {
	public static void main(String[] args) {		
		String str1 = "Hello";
		String str2 = "Hello";		
		// 동일한 문자열 "Hello" 를 참조하는 str1과 str2는
		// 동일한 상수의 공간을 참조하기 때문에 같은 참조값을 가집니다.
		if( str1 == str2 )
			System.out.println("str1 과 str2의 문자열은 동일합니다.");
		else
			System.out.println("str1 과 str2의 문자열은 서로 다릅니다.");
		
		String str3 = new String("Hello");
		// str3 레퍼런스는 HEAP 메모리에 String 의 객체를 생성하여
		// HEAP 메모리의 참조값을 가지기 때문에
		// 상수 영역을 참조하는 str1과 서로 다른 값을 가집니다. 
		if( str1 == str3 )
			System.out.println("str1 과 str3의 문자열은 동일합니다.");
		else
			System.out.println("str1 과 str3의 문자열은 서로 다릅니다.");
		
		String str4 = "He";
		// str4 레퍼런스는 상수 영역의 "He" 문자열의 참조값을 가지므로
		// 상수 영역의 "Hello" 를 참조하는 str1과 서로 다른 값을 가집니다.
		if( str1 == str4 )
			System.out.println("str1 과 str4의 문자열은 동일합니다.");
		else
			System.out.println("str1 과 str4의 문자열은 서로 다릅니다.");
		
		str4 += "llo";
		// str4 레퍼런스가 참조하고 있는 상수 영역의 "He" 문자열을 
		// "llo" 문자열과 결합하여 새로운 공간에 저장한 후, 그 참조값을 가지므로
		// 상수 영역의 "Hello" 를 참조하는 str1과 서로 다른 값을 가집니다.
		if( str1 == str4 )
			System.out.println("str1 과 str4의 문자열은 동일합니다.");
		else
			System.out.println("str1 과 str4의 문자열은 서로 다릅니다.");
		
		str4 = "He" + "llo";
		// "He" + "llo" 연산의 결과는 "Hello" 와 동일하기 때문에
		// str1 이 참조하는 "Hello"의 공간을 str4 도 참조하게 됩니다.		
		if( str1 == str4 )
			System.out.println("str1 과 str4의 문자열은 동일합니다.");
		else
			System.out.println("str1 과 str4의 문자열은 서로 다릅니다.");
	}
	
}











