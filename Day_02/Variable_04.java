
public class Variable_04 {

	public static void main(String[] args) {
		// 변수 사용의 주의사항
		
		// 1. 변수의 사용은 변수의 선언 이후에만 가능합니다.		
		//System.out.printf("num1 = %d\n", num1);
		int num1 = 10;
		System.out.printf("num1 = %d\n", num1);
		
		// 2. 변수의 사용은 변수의 초기화 이후에만 가능합니다.
		int num2;
		//System.out.printf("num1 = %d\n", num2);
		num2 = 20;
		System.out.printf("num1 = %d\n", num2);
	}

}
