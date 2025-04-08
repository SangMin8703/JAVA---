package wrapper;
// Wrapper 클래스의 static 멤버 활용
// Wrapper 클래스들은 기본자료형과 관련된 다양한 static 멤버 필드와
// static 멤버 메소드를 제공하고 있습니다.
// 이러한 static 멤버를 사용하여 다양한 기능을 손쉽게 구현할 수 있습니다.
public class Wrapper_04 {
	public static void main(String[] args) {
		// Integer 클래스의 static 멤버 필드의 사용
		// 객체의 생성없이 클래스의 이름(Integer)을 사용하여 접근할 수 있습니다.
		System.out.printf("Integer.BYTES -> %d\n", Integer.BYTES);
		System.out.printf("Integer.SIZE -> %d\n", Integer.SIZE);
		System.out.printf("Integer.MAX_VALUE -> %d\n", Integer.MAX_VALUE);
		System.out.printf("Integer.MIN_VALUE -> %d\n", Integer.MIN_VALUE);
		
	}
}
