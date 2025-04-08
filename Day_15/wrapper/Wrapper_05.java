package wrapper;
//Wrapper 클래스의 static 멤버 활용
//Wrapper 클래스들은 기본자료형과 관련된 다양한 static 멤버 필드와
//static 멤버 메소드를 제공하고 있습니다.
//이러한 static 멤버를 사용하여 다양한 기능을 손쉽게 구현할 수 있습니다.
public class Wrapper_05 {
	public static void main(String[] args) {
		// Integer 클래스의 static 멤버 메소드의 사용
		
		// 특정 정수값을 구성하는 2진수의 값중, 1의 개수를 반환하는 bitCount 메소드 
		// 10 -> 1010
		// 이진수를 구성하는 숫자 중 1의 개수가 2개 이므로 2를 반환
		System.out.printf("Integer.bitCount(10) -> %d\n", 
				Integer.bitCount(10));
		
		// 문자열로 저장된 숫자의 값을 실제 숫자 타입으로 변환하여
		// 반환하는 parse 메소드
		// Integer.parseInt("10") -> 문자열로 저장된 10을 반환
		// Java에서 입출력은 일반적으로 문자열로 해결하는 경우가 많습니다.
		// 기본자료형을 문자열로 입력받는 경우
		// 본래의 타입으로 변환하기 위해서 자주 사용이 됩니다.
		System.out.printf("Integer.parseInt(\"10\") -> %d\n", 
				Integer.parseInt("10"));
		// Double.parseDouble("10.12") -> 문자열로 저장된 10.12 를 반환
		System.out.printf("Double.parseDouble(\"10.12\") -> %.2f\n", 
				Double.parseDouble("10.12"));
		
		// parse 메소드의 오버로딩된 메소드
		// 10 진법이 아닌 다른 진법으로 저장된 문자열을
		// 10 진수로 반환할 수 있는 메소드
		// Integer.parseInt("1100100", 2) 
		// -> 2진법으로 구성된 1100100을 10진수 100으로 반환
		// Integer.parseInt("144", 8) 
		// -> 8진법으로 구성된 144을 10진수 100으로 반환
		// Integer.parseInt("64", 16) 
		// -> 16진수으로 구성된 64을 10진수 100으로 반환
		System.out.printf("Integer.parseInt(\"1100100\", 2) -> %d\n", 
				Integer.parseInt("1100100", 2));
		System.out.printf("Integer.parseInt(\"144\", 8) -> %d\n", 
				Integer.parseInt("144", 8));
		System.out.printf("Integer.parseInt(\"64\", 16) -> %d\n", 
				Integer.parseInt("64", 16));
	}
}








