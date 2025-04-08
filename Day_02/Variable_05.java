
public class Variable_05 {

	public static void main(String[] args) {
		// 변수의 타입에 따른 산술 연산의 결과
		byte b1 = 10;
		byte b2 = 20;
		// 자바에서 정수 사이의 산술 연산은 
		// 정수의 기본형인 int 타입으로 반환됩니다.
		// 아래의 코드는 4 byte int 형 값을 1 byte b3 변수에 
		// 대입할 수 없기 때문에 컴파일 에러가 발생됩니다.
		// byte b3 = b1 + b2;
		
		// 형변환
		// 특정 타입의 값 또는 변수를 다른 형으로 변경하는 방법
		// 형변환 문법
		// (변경하고자하는 타입명)값 또는 변수명
		byte b3 = (byte)(b1 + b2);
	}

}














