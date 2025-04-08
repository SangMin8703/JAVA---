class Equals_02 {
	public int num;
	public Equals_02(int num) {
		this.num = num;
	}
}
public class Class_Object_Equals_02 {
	public static void main(String[] args) {
		// 객체의 같음을 비교하기 위해서는 
		// Object 클래스의 equals 메소드를 사용합니다.
		// equals 메소드는 매개변수로 Object 타입을 사용하기 때문에
		// 어떠한 타입의 객체라도 전달할 수 있는 메소드입니다.
		// equals 메소드는 두개의 객체를 비교하여 서로 같은 객체인지를 판단한 후
		// true/false 값을 반환합니다.
		
		Equals_02 e1 = new Equals_02(100);
		Equals_02 e2 = new Equals_02(100);
		
		// Object 클래스의 equals 메소드는
		// 기본 구현으로 참조값을 비교합니다.
		// 그렇기 때문에 아래의 코드는
		// if(e1 == e2) 와 동일하게 동작합니다. 
		if( e1.equals(e2) )
			System.out.println("e1 변수와 e2 변수는 동일합니다.");
		else
			System.out.println("e1 변수와 e2 변수는 서로 다릅니다.");
	}
}











