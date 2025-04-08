
public class Operator_08 {

	public static void main(String[] args) {
		// 비트 연산자
		// 두 개의 정수간의 비트연산을 제공하는 연산자
		// & (AND), | (OR), ~ (NOT), ^ (XOR)
		
		int n1 = 10, n2 = 5;
		
		System.out.printf("%d & %d = %d\n", n1, n2, n1 & n2);
		System.out.printf("%d | %d = %d\n", n1, n2, n1 | n2);
		System.out.printf("~%d & %d = %d\n", ~n1, n2, ~n1 & n2);
		System.out.printf("%d ^ %d = %d\n", n1, n2, n1 ^ n2);

	}

}
