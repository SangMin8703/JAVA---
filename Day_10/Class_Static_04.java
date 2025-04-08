// static 메소드
// static 멤버 필드와 마찬가지로 프로그램의 시작 이전부터 메모리 로딩된 메소드
// 1. static 멤버 필드를 초기화하기 위한 목적
// 2. 자주 사용되는 간단한 기능을 제공하기 위한 목적
class S_4 {
	private static int num;
	// private 멤버로 지정된 static 멤버필드 num의 값을 수정하고 추출할 수 있는
	// public static 메소드 사용
	public static void setNum(int num) {
		S_4.num = num;
	}	
	public static int getNum() {
		return num;
	}
}
public class Class_Static_04 {
	public static void main(String[] args) {
		// static 멤버필드도 private 으로 지정되면
		// 외부 참조가 되지 않습니다.
		//S_4.num = 100;
		S_4.setNum(100);
		System.out.printf("S_4.num = %d\n", S_4.getNum());
		
	}
}





