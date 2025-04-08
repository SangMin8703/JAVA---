class Equals_01 {
	public int num;
	public Equals_01(int num) {
		this.num = num;
	}
}
public class Class_Object_Equals_01 {
	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 11;
		
		// Java 의 기본 자료형을 사용한 변수들은 서로 같은 지 확인하기 위해
		// == 연산자를 사용합니다.
		
		// num1과 num2 변수가 서로 같은지 확인하기 위해서는
		// == 연산자가 사용됩니다.
		if( num1 == num2 )
			System.out.println("num1 변수와 num2 변수는 동일합니다.");
		else
			System.out.println("num1 변수와 num2 변수는 서로 다릅니다.");
		
		// 동일한 모습의 객체를 참조하는 e1, e2 레퍼런스 변수의 선언 
		Equals_01 e1 = new Equals_01(100);
		Equals_01 e2 = new Equals_01(100);
		
		// 클래스의 레퍼런스 변수는 객체의 참조값을 가지는 변수로
		// == 연산자를 사용하여 비교하는 경우
		// 참조값만을 비교합니다.
		// 실제 객체가 동일한 형태를 가지고 있어도, 
		// 참조값만을 비교하기 때문에 아래의 분기문을 false 를 반환합니다.
		if( e1 == e2)
			System.out.println("e1 변수와 e2 변수는 동일합니다.");
		else
			System.out.println("e1 변수와 e2 변수는 서로 다릅니다.");
	}
}







