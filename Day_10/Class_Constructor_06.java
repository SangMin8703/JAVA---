// 구구단을 출력할 수 있는 클래스
// 1. 구구단 클래스의 객체 생성 시, 매개변수가 전달되면
//    해당 단수를 출력합니다.
// 2. 구구단 클래스의 객체 생성 시, 매개변수가 전달되지 않으면
//    2 ~ 9 단 까지 출력합니다.
class GuGuDan {
	// 출력할 단 수를 저장하는 멤버필드
	private int dan;	
	public GuGuDan() {
		dan = -1;
	}	
	public GuGuDan(int d) {
		dan = d;
	}	
	public void print() {
		if( dan == -1 )
			printGuGuDan();
		else
			printGuGuDan(dan);
	}
	public void printGuGuDan() {
		System.out.println("2 ~ 9 단까지 구구단을 출력합니다.");
		
		for( int i = 2 ; i <= 9 ; i++ ) {
			printGuGuDan(i);			
		}
	}	
	public void printGuGuDan(int d) {
		System.out.printf("%d 단 구구단을 출력합니다.\n", d);
		for( int j = 1 ; j <= 9 ; j++ ) {
			System.out.printf("%d * %d = %d\n", d, j, d*j);
		}
		System.out.println();
	}
}
public class Class_Constructor_06 {
	public static void main(String[] args) {
		// 전체 구구단을 출력할 수 있는 GuGuDan 클래스의 객체 생성
		GuGuDan g1 = new GuGuDan();
		g1.print();
		
		// 특정 단수의 구구단을 출력할 수 있는 GuGuDan 클래스의 객체 생성
		GuGuDan g2 = new GuGuDan(5);
		g2.print();
	}
}










