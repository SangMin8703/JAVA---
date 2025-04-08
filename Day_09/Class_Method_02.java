// 클래스의 멤버 메소드는
// 해당 클래스의 멤버 필드를 자유롭게 사용할 수 있습니다. 
class Method_B {
	// Method_B 클래스의 멤버 필드
	int num;
	
	void setNum(int n) {
		// 클래스의 멤버 필드인 num 변수에
		// 매개변수 n 의 값을 대입하는 코드
		num = n;
	}	
	void printNum() {
		// 클래스의 멤버 필드인 num 변수의 값을 출력하는 코드
		System.out.printf("num = %d\n", num);
	}	
}
public class Class_Method_02 {
	public static void main(String[] args) {		
		Method_B m = new Method_B();
		
		m.setNum(97);
		m.printNum();
	}
}
