class Equals_06 {
	private int num;
	public Equals_06(int num) {
		this.num = num;
	}
	public boolean equals(Object obj) {
		if( !(obj instanceof Equals_06) )
			return false;
		
		Equals_06 source = (Equals_06)obj; 
		
		// 일반적으로 private 멤버는
		// 클래스의 레퍼런스를 사용하여 접근할 수 없습니다.
		// source.num -> Equals_06 클래스의 private 멤버이기 때문에
		// 외부에는 접근이 불가능합니다.
		// 하지만 해당 클래스의 내부에서는 private 멤버에 레퍼런스를 통한 
		// 접근이 가능합니다.
		// 아래의 source.num 코드는 현재 객체의 멤버에 접근하는 코드가 아님에도
		// 같은 클래스의 선언문 내부에서 사용하는 것이므로 접근이 가능합니다.
		boolean result = this.num == source.num;		
		return result;
	}
}
public class Class_Object_Equals_06 {
	public static void main(String[] args) {
	}
}
