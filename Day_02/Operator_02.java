
public class Operator_02 {

	public static void main(String[] args) {
		// 관계연산자
		// 좌항과 우항의 크기를 비교하여 참/거짓의 여부를 반환하는 연산자
		// 사칙연산자와는 다르게 결과는 항상 진리형으로 반환됩니다.
		// >, <, >=, <=, ==, !=
		
		// 주의사항
		// = 기호는 대입 연산자로 사용되는 기호이기 때문에
		// 좌항과 우항의 값이 같은지 비교하기 위해서는 == 를 사용합니다.
		
		System.out.printf("%d > %d = %b \n", 20, 10, (20 > 10) );
		System.out.printf("%d < %d = %b \n", 20, 10, (20 < 10) );
		
		System.out.printf("%d >= %d = %b \n", 20, 10, (20 >= 10) );
		System.out.printf("%d <= %d = %b \n", 20, 10, (20 <= 10) );
		
		System.out.printf("%d == %d = %b \n", 20, 10, (20 == 10) );
		System.out.printf("%d != %d = %b \n", 20, 10, (20 != 10) );

	}

}


