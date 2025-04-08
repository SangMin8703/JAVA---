class Equals_05 {
	public int num;
	public Equals_05(int num) {
		this.num = num;
	}
	public boolean equals(Object obj) {		
		// Object 타입을 강제 형변환 이전에 타입을 비교하는 경우
		if( !(obj instanceof Equals_05) )
			return false;
		
		Equals_05 source = (Equals_05)obj;		
		
		boolean result = this.num == source.num;		
		return result;
	}
}
public class Class_Object_Equals_05 {
	public static void main(String[] args) {
		Equals_05 e1 = new Equals_05(10);
		String strMsg = "Hello";	
		
		// equals 메소드에서 형변환 이전에 타입을 비교하여 처리하는 경우
		// 해당 클래스와 다른 타입인 String 타입이 전달되어도
		// 문제없이 비교를 수행할 수 있습니다.		
		if( e1.equals(strMsg) )
			System.out.println("e1 변수와 strMsg 변수는 동일합니다.");
		else
			System.out.println("e1 변수와 strMsg 변수는 서로 다릅니다.");

	}
}
