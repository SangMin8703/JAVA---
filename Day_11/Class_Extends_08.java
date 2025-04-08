// 명시적으로 super 키워드를 반드시 사용해야 되는 경우
// 1. 부모클래스에 디폴트 생성자가 존재하지 않는 경우
// 2. 부모클래스와 동일한 이름의 멤버 필드가 자식클래스에 존재하는 경우
//   (부모클래스의 멤버를 접근하기 위해서 super 키워드를 사용합니다.)
class Super_08 {
	public int num;	
	public void printSuperNum() {
		System.out.printf("Super_08.num = %d\n", this.num);
	}
}
class Sub_08 extends Super_08 {
	public int num;	
	public void setNum(int num) {
		this.num = num;
		// 만약 부모 클래스와 동일한 이름의 멤버필드가 자식클래스에 존재하면
		// 자식 클래스에서는 자식 클래스에서 선언한 멤버필드가 우선시 됩니다.
		// 부모 클래스의 멤버에 접근하기 위해서는 super 키워드를 사용하여
		// 명시적으로 지정해야만 접근할 수 있습니다.
		super.num = num / 2;
	}
	public void printSubNum() {		
		System.out.printf("Sub_08.num = %d\n", this.num);
	}
}
public class Class_Extends_08 {
	public static void main(String[] args) {
		Sub_08 sub = new Sub_08();
		sub.setNum(100);
		sub.printSuperNum();
		sub.printSubNum();
	}
}




