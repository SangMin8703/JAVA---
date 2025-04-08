class S_2 {
	// static 멤버의 초기화
	// 일반 멤버필드와 동일한 방식으로 초기화 할 수 있습니다.
	public static int array_size = 10;
}
public class Class_Static_02 {
	public static void main(String[] args) {
		S_2 s1 = new S_2();		
		int [] arr1 = new int[s1.array_size];
		
		// static 멤버들은 클래스의 이름으로 접근할 수 있습니다.
		// 그 이유는 프로그램의 시작 이전부터 메모리에 로딩되어 있기 때문에...
		int [] arr2 = new int[S_2.array_size];

	}
}
