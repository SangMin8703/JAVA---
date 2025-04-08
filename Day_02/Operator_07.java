
public class Operator_07 {

	public static void main(String[] args) {
		// 변형된 형태의 대입 연산자
		// 자기 자신에 대해서 연산한 결과를 대입할 수 있는 연산자
		// +=, -=, *=, /=, %=, <<=, >>=, &=, |= ...
		int num = 10;
		
		// num 변수에 20 을 증가시켜 대입하세요.
		
		// 1. 일반적인 방법의 증가 방법 - 기본 대입 연산자를 사용하는 방법
		num = num + 20;
		System.out.printf("num = %d\n", num);
		
		// num 변수에 20을 증가한 후 num 변수에 대입하는 변형된 형태의 대입연산자
		// 2. 변형된 형태의 대입 연산자를 사용하여 증가하는 방법
		num += 20;	// num = num + 20;
		System.out.printf("num = %d\n", num);
	}
}





