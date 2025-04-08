// 상속 관계를 구현 시 자식클래스에서 접근할 수 있는 부모 클래스의 멤버
// 1. public 멤버(아무 제약이 없음)
// 2. default 접근 지정자를 사용한 멤버(클래스 파일의 위치에 따라서 접근이 안될수도 있음)
// 3. protected 접근 지정자를 사용한 멤버(아무 제약이 없음)
// default 와 protected 접근 지정자는 패키지 수업을 할때 따로 설명

// 자식 클래스는 부모클래스의 private 멤버에는 접근할 수 없습니다.
class Super_04 {
	public int n1;
	private int n2;
	int n3;	// 디폴트 접근 지정자
	protected int n4;
}
class Sub_04 extends Super_04 {
	public Sub_04(int n1, int n2, int n3, int n4) {
		this.n1 = n1;
		// 자식 클래스는 부모클래스의 private 멤버에는 접근할 수 없습니다.
		// this.n2 = n2;
		this.n3 = n3;
		this.n4 = n4;
	}
	public void printMembers() {
		System.out.printf("n1 = %d\n", this.n1);
		// 자식 클래스는 부모클래스의 private 멤버에는 접근할 수 없습니다.
		// System.out.printf("n2 = %d\n", this.n2);
		System.out.printf("n3 = %d\n", this.n3);
		System.out.printf("n4 = %d\n", this.n4);
	}
}
public class Class_Extends_04 {
	public static void main(String[] args) {
		// 
	}
}
