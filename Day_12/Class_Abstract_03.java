import java.util.Scanner;

abstract class Calculator {
	private int num1;
	private int num2;	
	public Calculator(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}		
	public int getNum1() {
		return num1;
	}	
	public int getNum2() {
		return num2;
	}	
	// 사칙연산의 결과를 반환하는 메소드
	public abstract double getResult();
}
class Plus extends Calculator {		
	public Plus(int num1, int num2) {
		super(num1, num2);
	}	
	public double getResult() {
		double r;		
		r = this.getNum1() + this.getNum2();
		return r;
	}	
}
class Minus extends Calculator {
	public Minus(int num1, int num2) {
		super(num1, num2);
	}
	
	public double getResult() {
		double r;
		r = this.getNum1() - this.getNum2();
		return r;
	}	
}
class Mul extends Calculator {	
	public Mul(int num1, int num2) {
		super(num1, num2);
	}
	
	public double getResult() {
		double r;
		r = this.getNum1() * this.getNum2();
		return r;
	}	
}
class Div extends Calculator {		
	public Div(int num1, int num2) {
		super(num1, num2);
	}
	
	public double getResult() {
		double r;
		r = (double)this.getNum1() / this.getNum2();
		return r;
	}		
}
public class Class_Abstract_03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char buho;
		int num1, num2;
		
		System.out.print("수행할 사칙 연산의 부호를 입력하세요 : ");
		buho = sc.next().charAt(0);
		System.out.print("좌항의 정수값을 입력하세요 : ");
		num1 = sc.nextInt();
		System.out.print("우항의 정수값을 입력하세요 : ");
		num2 = sc.nextInt();
		
		Calculator calculator;
		switch(buho) {
			case '+':
				calculator = new Plus(num1, num2);
				break;
			case '-':
				calculator = new Minus(num1, num2);
				break;
			case '*':
				calculator = new Mul(num1, num2);
				break;
			case '/':
				calculator = new Div(num1, num2);
				break;
			default:
				calculator = null;
		}
		
		if( calculator != null )
			System.out.printf("%d %c %d = %.2f\n", num1, buho, num2, 
					calculator.getResult());
		else
			System.out.println("잘못된 부호를 입력했습니다.");
		

	}
}











