
public class Method_11 {
	// 3개의 정수를 매개변수로 입력받아
	// 최대값을 반환하는 max 메소드와
	// 최소값을 반환하는 min 메소드를 작성하여 테스트하세요.
	// 예시
	// int max = max(10, 20, 30);
	// int min = min(10, 20, 30);
	
	public static int max(int n1, int n2, int n3) {
		int result;		
		if( n1 > n2 )
			result = n1;
		else 
			result = n2;		
		return result > n3 ? result : n3;
	}	
	public static int min(int n1, int n2, int n3) {
		int result;		
		if( n1 < n2 )
			result = n1;
		else 
			result = n2;		
		return result < n3 ? result : n3;
	}
	public static void main(String[] args) {		
		int max = max(10, 20, 30);
		int min = min(10, 20, 30);
		
		System.out.printf("max = %d\n", max);
		System.out.printf("min = %d\n", min);
	}

}








