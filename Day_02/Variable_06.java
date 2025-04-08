
public class Variable_06 {

	public static void main(String[] args) {
		// 실수형 변수
		// 실수형 변수의 기본형
		// 8 byte 크기의 double 형
		
		float f1;
		// Java 의 실수형의 기본형은 double 타입이기 때문에
		// 일반적인 실수의 값을 float 타입으로 대입할 수 없습니다.
		// f1 = 1.1;
		
		// float 타입의 변수에 실수를 대입하는 방법
		// 1. 형변환을 통한 값의 대입
		f1 = (float)1.1;
		
		// 2. float 형의 실수형 값을 사용한 값의 대입
		//  - 실수형값F, 실수형값f
		//  - 4 byte 크기의 실수형 값을 선언
		f1 = 1.1F;
		f1 = 1.1f;
	}

}









