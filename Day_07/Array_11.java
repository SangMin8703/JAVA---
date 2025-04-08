
public class Array_11 {

	public static void main(String[] args) {
		// 다차원 배열
		// 다차원 배열 다수개의 인덱스 연산을 사용하여 접근할 수 있는 배열
		// 2차원 배열은 행과 열의 개념을 사숑하는 배열
		
		// 다차원 배열의 정의는 다수개의 인덱스를 통해 정의할 수 있습니다.
		// 사용법
		// 자료형 [][] 배열변수명 = new 자료형[행의개수][열의개수];
		
		// 2행 3열의 2차원 배열의 생성
		int [][] num = new int[2][3];
		
		num[0][0] = 10;
		num[0][1] = 20;
		num[0][2] = 30;
				
		num[1][0] = 40;
		num[1][1] = 50;
		num[1][2] = 60;
		
		System.out.printf("num[%d][%d] = %d\n", 0, 0, num[0][0]);
		System.out.printf("num[%d][%d] = %d\n", 0, 1, num[0][1]);
		System.out.printf("num[%d][%d] = %d\n", 0, 2, num[0][2]);
		
		System.out.printf("num[%d][%d] = %d\n", 1, 0, num[1][0]);
		System.out.printf("num[%d][%d] = %d\n", 1, 1, num[1][1]);
		System.out.printf("num[%d][%d] = %d\n", 1, 2, num[1][2]);
	}

}










