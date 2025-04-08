import java.util.Scanner;

// 정수 두 개와 부호를 입력받아 사칙연산을 수행할 수 있는 
// Calculator 클래스를 작성하세요.
class Calculator {	
	// 입력
	private int num1;
	private int num2;
	private char buho;
	// 출력
	private double result;
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.print("1 번째 정수를 입력하세요 : ");
		num1 = sc.nextInt();
		System.out.print("2 번째 정수를 입력하세요 : ");
		num2 = sc.nextInt();
		System.out.print("부호를 입력하세요 : ");
		buho = sc.next().charAt(0);
		sc.close();
	}
	public void process() {
		switch( buho ) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			case '/':
				result = (double)num1 / num2;
				break;
		}
	}
	public void output() {
		System.out.printf("%d %c %d = %.2f\n", num1, buho, num2, result);
	}	
}
public class Class_Constructor_08 {
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		// input 메소드를 실행하여
		// 정수 2개와 부호를 입력
		cal.input();
		// process 메소드를 실행하여
		// 사칙 연산의 결과를 추출
		cal.process();
		// output 메소드를 실행하여
		// 실행 결과를 화면에 출력합니다.
		cal.output();
	}
}
