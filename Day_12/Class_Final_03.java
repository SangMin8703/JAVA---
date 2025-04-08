// final 키워드
// final 은 마지막의 의지를 가집니다.
// (불변의 의미)
// 기존의 C언어와 같은 경우 const 키워드를 사용하여 구현...

// 1. class 의 선언에 사용되는 경우
// 2. 메소드의 선언에 사용되는 경우
// 3. 멤버필드의 선언에 사용되는 경우

// final 키워드가 멤버필드의 선언에 사용되는 경우
//  - 특정 멤버필드를 상수로 선언하기 위해 사용
//   (값의 변경을 허용하지 않도록 강제)
//  - final 멤버필드는 반드시 초기화가 이뤄져야 합니다.
//  - final 멤버의 초기화는 멤버필드의 선언부 또는 생성자에서 가능합니다.
//   (그외의 장소에서는 final 멤버를 초기화할 수 없습니다.)
//  - final 멤버의 초기화는 멤버필드의 선언부나 생성자 둥중 한 곳에서만 가능합니다.
class Final_03 {
	// 일반 멤버필드의 선언
	public int normalMember;	
	// 멤버필드의 선언부에서 final 멤버를 초기화하면
	// 해당 클래스의 모든 객체들은 동일한 값을 갖는 final 멤버를 갖게됩니다.
	// (일반적으로는 사용이 많이 되지않고, static 키워드와 같이 사용됩니다.)
	public final int finalMember01 = 10;
	// public static final int finalMember01 = 10;	
	public final int finalMember02;
	
	public Final_03(int finalMember01, int finalMember02) {
		// 멤버필드의 선언부에서 초기화된 final 멤버는 
		// 생성자에서 추가적으로 초기화될 수 없습니다.
		// this.finalMember01 = finalMember01;
		
		// 생성자에서 초기화는 final 멤버필드는
		// 각각의 객체마다 서로다른 값을 가질 수 있습니다.
		this.finalMember02 = finalMember02;
	}
	
	public void setFinalMember01(int finalMember01) {
		// final 멤버필드는 값의 수정을 할 수 없습니다.
		//this.finalMember01 = finalMember01;
	}
}

public class Class_Final_03 {
	public static void main(String[] args) {		
		Final_03 f = new Final_03(10, 20);
		// final 멤버필드는 값의 수정을 할 수 없습니다.
		// f.finalMember01 = 10;
	}
}

 



