
public class Operator_09 {

	public static void main(String[] args) {
		// 쉬프트 연산자
		// 정수형 피 연산자의 각 비트의 위치를 이동시킬 수 있는 연산자
		// <<, >>
		
		int num = 10;
		
		// 1. 레프트 쉬프트
		//  피 연산자의 각 비트 중 1인 자리를 왼쪽으로 이동시킬수 있는 연산자
		// 변수명 << N
		// N의 숫자만큼 특정 변수의 비트를 왼쪽으로 이동합니다.
		// 변수값 * 2의 N승
		System.out.printf("%d << %d = %d\n", num, 1, num << 1);
		
		// 2. 라이트 쉬프트
		//  피 연산자의 각 비트 중 1인 자리를 오른쪽으로 이동시킬수 있는 연산자
		// 변수명 >> N
		// N의 숫자만큼 특정 변수의 비트를 오른쪽으로 이동합니다.
		// 변수값 / 2의 N승
		System.out.printf("%d >> %d = %d\n", num, 1, num >> 1);
		
		// 쉬프트 연산자는 피연산자의 값을 변경하지 않습니다.
		System.out.printf("num = %d\n", num);
		
		// 변형된 형태의 대입 연산자를 활용한 쉬프트 연산
		num <<= 1;	// num = num << 1;
		System.out.printf("num = %d\n", num);
	}

}











