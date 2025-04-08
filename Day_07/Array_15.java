
public class Array_15 {

	public static void main(String[] args) {
		// 다차원 배열의 length 속성 사용
		
		int [] num1 = new int[]{10, 20, 30};
		// 일차원 배열의 length 속성은 해당 일차원 배열의 개수(크기)를 반환합니다.
		// 아래의 num1.length 속성은 3을 반환합니다.
		for( int i = 0 ; i < num1.length ; i++ )
			System.out.printf("num1[%d] = %d\n", i, num1[i]);
		
		int [][] num2 = new int[][]{{1,2,3,100,200}, {4,5,6,300,400}};
		
		// 2차원 배열은 length 속성을 2군데에 사용할 수 있습니다.
		
		// 2차원 배열의 이름을 사용하여 length 속성을 호출하면
		// 행의 개수를 반환합니다.
		System.out.printf("num2.length = %d\n", num2.length);
		
		// 2차원 배열의 이름과 2차원 배열의 인덱스 연산을 사용하여 length 속성을 호출하면
		// 열의 개수(실제 1차원 배열의 크기)를 반환합니다.
		System.out.printf("num2[0].length = %d\n", num2[0].length);
		System.out.printf("num2[1].length = %d\n", num2[1].length);
		
		// 2차원 배열의 행을 제어하는 외부의 반복문
		for( int i = 0 ; i < num2.length ; i++ ) {
			// 2차원 배열의 열을 제어하는 내부의 반복문
			for( int j = 0 ; j < num2[i].length ; j++ ) {
				System.out.printf("num2[%d][%d] = %d\n", i, j, num2[i][j]);
			}
		}
		

	}

}





