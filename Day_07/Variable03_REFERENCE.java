// 레퍼런스 변수( 참조형 변수 )
// 기본형의 값( 정수/실수/문자 등 )이 아닌 특정 메모리의 위치값을 가지는 변수
// HEAP 메모리를 참조하는 변수들...
// 지역변수로 선언되는 경우가 많습니다.
// 배열 변수, 클래스 타입의 변수( String )
public class Variable03_REFERENCE {	
	public static void main(String[] args) {
		// null 값
		// 레퍼런스 변수를 초기화할 수 있는 값으로
		// 정수의 0와 같은 의미입니다.
		
		String str = "Hello World";
		//String str = null;	

		
		System.out.printf("%s 의 문자열 길이는 %d 입니다.\n",
				str, str.length() );
		
		int [] arr;
		// 레퍼런스 변수는 0 으로 초기화할 수 없습니다.
		//arr = 0;
		// 레퍼런스 변수를 초기화 하기 위해 null 값을 사용합니다.
		arr = null;
		
		//System.out.print(arr.length);
	}
}









