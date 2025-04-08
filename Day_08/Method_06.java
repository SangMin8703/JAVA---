
public class Method_06 {
	// 정수 3개를 매개변수로 입력 받아 최대값을 출력하는 max 메소드와
	// 정수 3개를 매개변수로 입력 받아 최소값을 출력하는 min 메소드를 작성하세요.
	// 예시
	// max(10, 20, 30);
	// 최대값은 '30' 입니다.
	// min(10, 20, 30);
	// 최소값은 '10' 입니다.
	public static void max(int n1, int n2, int n3) {		
		int result;
		
		// n1, n2 두 변수를 비교하여 큰 수를 result 변수에 저장 
		result = n1 > n2 ? n1 : n2;
		// result 변수의 값과 n3 변수를 비교하여 n3 이 더 큰 경우 
		// n3 의 값으로 result 변수를 수정
		result = n3 > result ? n3 : result;
		
		System.out.printf("최대값은 '%d' 입니다.\n", result);		
	}
	public static void min(int n1, int n2, int n3) {		
		int result;
		
		// n1, n2 두 변수를 비교하여 작은 수를 result 변수에 저장 
		result = n1 < n2 ? n1 : n2;
		// result 변수의 값과 n3 변수를 비교하여 n3 이 더 작은 경우 
		// n3 의 값으로 result 변수를 수정
		result = n3 < result ? n3 : result;
		
		System.out.printf("최소값은 '%d' 입니다.\n", result);		
	}
	
	// 정수형 2개와 char 형 1개를 입력받아 실행되는 메소드 cal 을 정의하세요.
	// cal 메소드는 char 타입으로 전달된 매개변수의 값의 따라서 사칙연산을 수행합니다.
	// 예시
	// cal(10, '+', 10);
	// 10 + 10 = 20;
	public static void cal(int n1, char buho, int n2) {
		System.out.println("cal 메소드 실행");
		
		double result;
		switch(buho) {
			case '+':
				result = n1 + n2;
				break;
			case '-':
				result = n1 - n2;
				break;
			case '*':
				result = n1 * n2;
				break;
			case '/':
				result = (double)n1 / n2;
				break;
			default:
				result = 0;
				buho = '?';
		}
		
		if( buho != '?' )
			System.out.printf("%d %c %d = %.2f\n", n1, buho, n2, result);
		else
			System.out.println("잘못된 부호가 전달되었습니다.");
	}

	public static void main(String[] args) {
		cal(10, '+', 5);		
		cal(10, '-', 5);		
		cal(10, '*', 5);		
		cal(10, '/', 5);		
		cal(10, '#', 5);
		
		max(10, 20, 30);
		min(10, 20, 30);
	}

}








