// 추상클래스의 문제점과 해결 방법
// 추상클래스는 추상메소드를 선언하여 자식클래스들에게
// 해당 추상메소드를 반드시 오버라이딩하도록 강제하는 클래스입니다.
// 하지만 특정 경우는 추상클래스의 추상메소드가 모든 자식클래스들에게
// 오버라이딩하도록 강제하는것이 불합리한 경우가 발생합니다.
abstract class Abstract_05_Super {
	public abstract void abstractMethod01();
	public abstract void abstractMethod02();
	public abstract void abstractMethod03();
	public abstract void abstractMethod04();
	public abstract void abstractMethod05();
	public abstract void abstractMethod06();
	public abstract void abstractMethod07();
	public abstract void abstractMethod08();
	public abstract void abstractMethod09();
	public abstract void abstractMethod10();
}
// Abstract_05_Super 클래스의 abstractMethod01 메소드만 사용하고자하는
// Abstract_05_Sub 클래스의 선언
// 필요한 메소드는 하나이지만, 추상메소는 반드시 구현해야만하는 메소드이기 때문에
// 불필요한 나머지 9개의 메소드도 반드시 오버라이딩해야만 합니다.
class Abstract_05_Sub_01 extends Abstract_05_Super {	
	public void abstractMethod01() {
		System.out.println("핑요한 메소드의 오버라이딩 구현~!");		
	}
	// 자식클래스에서 오버라이딩 하지않아도 되는 메소드들...
	public void abstractMethod02() {}
	public void abstractMethod03() {}
	public void abstractMethod04() {}
	public void abstractMethod05() {}
	public void abstractMethod06() {}
	public void abstractMethod07() {}	
	public void abstractMethod08() {}
	public void abstractMethod09() {}
	public void abstractMethod10() {}	
}

// Adapter 패턴
// 위와 같은 경우처럼 특정 추상클래스가 많은 수의 추상메소드를 포함하는경우
// 자식클래스에게 많은 부담을 주게됩니다.
// Adapter 패턴은 이러한 문제를 해결하기 위해
// 부모추상클래스를 상속하여 모든 추상메소드들을 
// 더미형태(아무것도 하지않는 메소드)로 구현해놓은 패턴입니다.

// Adapter 패턴을 구현하는 클래스는
// 부모추상클래스이름Adapter 로 이름을 작성합니다.
class Abstract_05_SuperAdapter extends Abstract_05_Super {
	// 어댑터 패턴을 구현하는 클래스는 
	// 부모 추상클래스의 모든 추상메소드를
	// 아래와 같이 더미형태로 구현합니다.	
	public void abstractMethod01() {}
	public void abstractMethod02() {}
	public void abstractMethod03() {}
	public void abstractMethod04() {}
	public void abstractMethod05() {}
	public void abstractMethod06() {}
	public void abstractMethod07() {}	
	public void abstractMethod08() {}
	public void abstractMethod09() {}
	public void abstractMethod10() {}	
}

// 어댑터 패턴을 사용하면 추상클래스의 상속이 손쉬워 집니다.
// 해당 자식클래스에서 사용할 메소드만 선별적으로 오버라이딩이 가능해짐
class Abstract_05_Sub_02 extends Abstract_05_SuperAdapter {	
	public void abstractMethod01() {
		System.out.println("핑요한 메소드의 오버라이딩 구현~!");		
	}
}
public class Class_Abstract_05 {
	public static void main(String[] args) {
		// 최상위 추상클래스의 레퍼런스는 
		// 어댑터클래스를 상속받은 자식클래스의 객체를 참조할 수 있습니다.
		Abstract_05_Super s = new Abstract_05_Sub_02();
	}
}












