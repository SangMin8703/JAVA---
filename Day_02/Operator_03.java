
public class Operator_03 {

	public static void main(String[] args) {
		// 논리연산자
		// 다수 개의 관계연산자를 하나의 식으로 묶어서 처리하기위한 연산자
		// &&(AND), ||(OR), !(NOT)
		
		// 1. && (AND)
		//  - 좌항과 우항의 관계식이 모두 참인 경우에 참을 반환하는 연산자
		//  좌항      우항       결과
		//  false  false   false
		//  false  true    false
		//  true   false   false
		//  true   true    true
		System.out.printf("%b && %b = %b\n", false, false, (false && false) );
		System.out.printf("%b && %b = %b\n", false, true, (false && true) );
		System.out.printf("%b && %b = %b\n", true, false, (true && false) );
		System.out.printf("%b && %b = %b\n", true, true, (true && true) );
		
		// 2. || (OR)
		//  - 좌항과 우항의 관계식중에 하나라도 참인 경우에 참을 반환하는 연산자
		//  좌항      우항       결과
		//  false  false   false
		//  false  true    true
		//  true   false   true
		//  true   true    true
		System.out.printf("%b || %b = %b\n", false, false, (false || false) );
		System.out.printf("%b || %b = %b\n", false, true, (false || true) );
		System.out.printf("%b || %b = %b\n", true, false, (true || false) );
		System.out.printf("%b || %b = %b\n", true, true, (true || true) );
		
		// 3. ! (NOT)
		//  - 단항연산자로서, 관계식의 결과를 부정하는 연산자
		//  관계식    결과
		//  false  true
		//  true   false
		System.out.printf("!%b = %b\n", false, !false );
		System.out.printf("!%b = %b\n", true, !true );
	}

}









