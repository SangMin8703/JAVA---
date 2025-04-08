// 상속
// 클래스의 재활용을 위해 사용되는 문법
// 기존의 클래스의 내용을 다른 클래스에서 사용할 수 있도록 도와주는 문법

// 클래스의 재활용이 활용되는 경우
// 1. 포함 관계( has a )
//  - 특정 클래스가 다른 클래스를 사용하는 경우
//  EX) 유저와 아이템의 관계 (유저는 아이템을 사용하여 플레이를 진행기 때문에)
// 2. 상속 관계( is a )

// 포함 관계의 구현( has a )
// 특정 클래스의 멤버 필드로 다른 클래스의 레퍼런스를 선언하여 구현
class Item {
	public void used() {
		System.out.println("아이템을 사용하여 능력치가 향상되었습니다.");
	}
}
class User {
	// User 클래스의 멤버 필드로 Item 클래스의 레퍼런스 변수를 선언
	Item item;	
	public User(Item item) {
		this.item = item;
	}	
	public void action() {
		// 포함 관계의 경우 포함하고 있는 객체가 null 값을 가지고 있는지
		// 확인한 후 사용해야만 합니다.
		// NullPointerException 이 발생하여 프로그램이 강제 종료될 수 있습니다.
		if( this.item == null )
			System.out.println("아이템을 보유하지 않아 능력치에 변경이 없습니다.");
		else
			this.item.used();
		
		System.out.println("유저가 액션을 취합니다.");
	}
}
public class Class_Extends_01 {
	public static void main(String[] args) {
		Item item = new Item();
		User user = new User(null);
		
		user.action();

	}
}









