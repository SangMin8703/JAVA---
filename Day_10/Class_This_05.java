class T_5 {
	public T_5() {
		System.out.println("T_5() 생성자 호출"); 
	}
	public T_5(int i) {
		// 생성자는 객체가 생성될 때 호출되는 메소드로
		// 메소드 이름을 사용한 명시적인 호출은 불가능합니다.
		// T_5();
		
		// 생성자의 호출이 가능한 예외적인 경우
		// 조건 1. 생성자의 호출은 생성자 내부에서만 가능합니다.
		//       (오버로딩된 다른 생성자에서 호출이 가능)
		// 조건 2. 생성자 사이의 호출은 해당 생성자의 첫번째 실행코드로만 가능합니다.
		//       (반드시 첫번째 실행믄으로만 생성자의 호출이 가능)
		
		// 생성자 내부에서 다른 생성자를 호출하는 방법
		// this(생성자에 정의된 매개변수);
		this();
		
		System.out.println("T_5(int i) 생성자 호출");
		
		// this 키워드를 사용한 생성자의 호출은 첫번째 실행문으로만 가능합니다.
		// this();
	}
	
	public void display() {
		// this 키워드를 활용한 생성자의 호출은
		// 생성자 내부에서만 가능합니다.
		// this();
	}
}

public class Class_This_05 {
	public static void main(String[] args) {
		T_5 t = new T_5(10);

	}
}







