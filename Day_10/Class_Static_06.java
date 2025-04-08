// 싱글턴 패턴
// 어떤 클래스의 객체를 단 하나만 생성하도록 강제하는 패턴
// 싱글턴 패턴을 구현한 클래스는 어떤한 상황에서도 단 하나의 객체만을 생성합니다.
class SingletonEx {
	// 자기 자신의 타입을 private static 으로 선언
	// 초기값을 null 값을 가집니다.
	private static SingletonEx instance = null;	
	public static SingletonEx getInstance() {
		// static 멤버인 instance 의 값을 확인하여
		// null 값을 가지는 경우에만 객체를 생성
		// 최초의 단 한번만 객체가 생성됩니다.
		if(SingletonEx.instance == null)
			SingletonEx.instance = new SingletonEx();
		
		return SingletonEx.instance;
	}
	// 싱글턴 패턴을 구현하는 클래스는
	// 외부에서 생성자를 통한 객체의 생성을 차단하기 위해
	// 생성자의 접근지정자를 private 으로 작성합니다.
	private SingletonEx() {
		System.out.println("SingletonEx 생성자 호출");
	}
}
public class Class_Static_06 {
	public static void main(String[] args) {
		SingletonEx s1 = SingletonEx.getInstance();
		SingletonEx s2 = SingletonEx.getInstance();
		// private 으로 지정된 생성자는 
		// 외부에서는 호출할 수 없습니다.
		//SingletonEx s3 = new SingletonEx();
	}	
}







