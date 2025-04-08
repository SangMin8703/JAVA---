// Object 클래스의 toString 메소드
// toString 메소드는 모든 객체들이 객체의 정보를 문자열로 반환할 수 있도록 제공되는 메소드입니다.
// Object 클래스가 제공하는 toString 메소드의 실행 결과는
// 클래스명@16진수의해시코드값
// 이 문자열로 반환됩니다.
class ToString_01 {}

public class Class_Object_ToString_01 {
	public static void main(String[] args) {		
		ToString_01 obj = new ToString_01();
		
		// hashCode 메소드의 실행결과는 
		// JVM에서 해당 객체를 관리하는 번호를 반환합니다.
		int hashcode = obj.hashCode();		
		System.out.printf("obj.hashCode() -> %d\n", hashcode);
		
		String strMessage = obj.toString();
		// toString 메소드의 실행결과
		// 클래스명@16진수의해시코드값
		System.out.printf("obj.toString() -> %s\n", strMessage);
	}
}







