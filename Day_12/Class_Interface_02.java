// 인터페이스는 
// public static final 멤버필드와
// public abstract 메소드만을 포함할 수 있습니다.
interface Inter_02 {
	// 인터페이스 내부에 선언된 모든 멤버필드들은
	// public static final 을 생략하고 선언할 수 있습니다.
	// 아래의 num 멤버필드는
	// public static final int num = 10;
	// 로 처리됩니다.
	int num = 10;
	// 인터페이스 내부에 선언되는 모든 멤버 메소드(추상메소드)들은
	// public abstract 을 생략하고 선언할 수 있습니다.
	// 아래의 추상 메소드 선언은
	// public abstract void print();
	// 로 처리됩니다.
	void print();
}
public class Class_Interface_02 {
	public static void main(String[] args) {

	}
}
