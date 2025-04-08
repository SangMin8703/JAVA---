class Equals_04 {
	public int num;
	public Equals_04(int num) {
		this.num = num;
	}
	public boolean equals(Object obj) {		
		// equals 메소드에 전달된 Object 클래스의 타입을 비교하지 않고
		// 강제 형변환을 하는 경우
		Equals_04 source = (Equals_04)obj;		
		
		boolean result = this.num == source.num;		
		return result;
	}
}
public class Class_Object_Equals_04 {
	public static void main(String[] args) {
		Equals_04 e1 = new Equals_04(10);
		Equals_04 e2 = new Equals_04(10);
		// equals 메소드에 동일한 클래스 타입인 Equals_04을 전달하는경우
		// Object 타입의 비교를 하지 않아도
		// 형변환에 문제 없이 실행됩니다.
		if( e1.equals(e2) )
			System.out.println("e1 변수와 e2 변수는 동일합니다.");
		else
			System.out.println("e1 변수와 e2 변수는 서로 다릅니다.");
		
		// equals 메소드에 형변환 해야하는 클래스와 다른 타입인 String 타입을 전달하는경우
		// 강제 형변환 과정에서 에러가 발생됩니다.
		String strMsg = "Hello";
		if( e1.equals(strMsg) )
			System.out.println("e1 변수와 strMsg 변수는 동일합니다.");
		else
			System.out.println("e1 변수와 strMsg 변수는 서로 다릅니다.");
	}
}












