public class Method_14 {
	// 메소드 오버로딩의 구현
	// 메소드의 이름은 같고, 매개변수의 타입, 개수, 순서가 다르면
	// 서로 다른 메소드로 인지하는 문법
	// 일관된 메소드 이름을 사용하여 사용자에게 직관적인 이름을 알려줍니다.
	public static void sum( int n1, int n2 ) {
		System.out.printf("%d + %d = %d\n", n1, n2, n1+n2);		
	}	
	public static void sum( int n1, int n2, int n3 ) {
		System.out.printf("%d + %d + %d = %d\n",
				n1, n2, n3, n1+n2+n3);
	}
	public static void sum( int n1, int n2, int n3, int n4 ) {
		System.out.printf("%d + %d + %d + %d = %d\n",
				n1, n2, n3, n4, n1+n2+n3+n4);
	}	
	public static void main(String[] args) {
		sum(10, 20);
		sum(10, 20, 30);
		sum(10, 20, 30, 40);

		// println 메소드는 동일한 이름을 사용해
		// 다양한 매개변수를 사용할 수 있습니다.		
		// 메소드 오버로딩의 예		
		System.out.println(10);
		System.out.println(1.1);
		System.out.println(1.1f);
		System.out.println("Hello");
	}
}






