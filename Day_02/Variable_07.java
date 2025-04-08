
public class Variable_07 {

	public static void main(String[] args) {
		// 정수형과 실수형의 값을 사용한 산술 연산의 결과
		// Java 의 산술연산은 정수형과 정수형의 경우 기본형인 int 타입이 반환
		// (만약 정수형의 타입이 long 타입이라면, 예외적으로 long 타입이 반환)
		// Java 의 산술연산은 정수형과 실수형의 경우 실수형의 타입으로 반환
		// EX) byte + byte = int
		//     short + byte = int
		//     int + int = int
		//     byte + long = long
		//     int + float = float
		//     int + double = double
		
		int num;
		
		// 아래의 코드는 실수형인 float 타입을 반환하기 때문에 
		// int 형 변수에 대입할 수 없습니다.
		// num = 10 + 1.1F;
		
		// 위와 같은 에러를 피하기위해서 강제 형변환을 사용할 수 있습니다.
		num = (int)(10 + 1.1F);

	}

}






