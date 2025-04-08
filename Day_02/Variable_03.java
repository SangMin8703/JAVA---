
public class Variable_03 {

	public static void main(String[] args) {
		// 다수개의 변수 생성 방법
		// 자료형 변수명1, 변수명2, 변수명N;
		int num1, num2, num3;		
		
		num1 = 10;
		num2 = 20;
		num3 = 30;
		
		System.out.printf(
				"num1 = %d, num2 = %d, num3 = %d\n", 
				num1, num2, num3);
		
		// 다수개의 변수를 생성하면서 동시에 초기화하는 방법
		// 자료형 변수명1 = 값1, 변수명2 = 값2, 변수명N = 값N;
		int num4 = 40, num5 = 50, num6 = 60;
		
		System.out.printf(
				"num4 = %d, num5 = %d, num6 = %d\n", 
				num4, num5, num6);
		
		// 다수개의 변수를 생성하면서 일부만 초기화하는 방법
		// 자료형 변수명1, 변수명2 = 값2, 변수명N;
		int num7, num8 = 80, num9;

	}

}







