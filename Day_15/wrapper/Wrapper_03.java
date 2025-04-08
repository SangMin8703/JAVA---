package wrapper;

// Wrapper 클래스와 기본 자료형의 형변환
// - 오토 박싱, 오토 언박싱
// 기본 자료형을 Wrapper 클래스의 객체로 생성하기 위해서는
// 기존의 객체를 만드는 것과 같이 생성자를 호출하는 코드가 필요합니다.
// 이러한 경우 기본 자료형을 쓰는것에 비해, 코드의 양이 늘어나고
// Wrapper 클래스를 사용하기에 불편함을 유발합니다.

// 이러한 문제를 해결하기 위해서 JDK 1.5 이 후의 버전에서는
// 오토박싱과 오토언박싱을 지원합니다.
// 오토 박싱 -> 기본 자료형을 Wrapper 클래스의 객체로 자동 변환하는 것
// 오토 언박싱 -> Wrapper 클래스의 객체를 기본 자료형으로 자동 변환하는 것

public class Wrapper_03 {
	public static void main(String[] args) {	
		
		int i1_A = 10;
		// i1 변수를 사용하여 Integer 클래스의 객체를 생성하는 
		// 기존의 코드
		Integer i1_B = new Integer(i1_A);		
		// 오토 박싱을 적용한 코드
		// int 타입의 i1_A 변수를 Integer 클래스의 객체로 자동 생성
		Integer i1_C = i1_A;
		
		// i2_A 변수에 i1_B 객체가 저장하고 있는 정수의 값을
		// 대입하기 위한 기존의 코드
		int i2_A = i1_B.intValue();
		// 오토 언박싱을 적용한 코드
		// Integer 타입의 i1_B 객체를 int 타입의 기본 자료형으로 자동 변환
		int i2_B = i1_B;
	}
}















