// static 멤버 필드의 활용
// 다른 클래스 사이에서 공유될 변수를 선언하고자 하는 경우에 활용
class Constant {
	public static int ARRAY_SIZE = 10;
}

public class Class_Static_03 {
	public static void main(String[] args) {		
		
		int [] arr = new int[Constant.ARRAY_SIZE];
		
		// static 키워드를 활용한 전역 변수의 예
		// 1. System 클래스의 out 변수
		// 2. Math 클래스의 PI
		System.out.printf("Math.PI = %f\n", Math.PI);

	}
}
