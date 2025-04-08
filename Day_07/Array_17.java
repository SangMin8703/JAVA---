
public class Array_17 {

	public static void main(String[] args) {
		// 서로 다른 길이를 갖는 다차원 배열
		// Java의 다차원 배열은 각 행이 서로 다른 크기의 
		// 1차원 배열을 참조할 수 있습니다.
		
		int [][] num;
		
		// 1차원 배열을 관리하는 2차원 배열의 생성
		// 아직까지는 2차원 배열의 생성이 완료되지 않은 상태
		num = new int[5][];
		
		num[0] = new int[]{1,2,3};
		num[1] = new int[]{4,5};
		num[2] = new int[]{6,7,8,9,10};
		num[3] = new int[]{11};
		num[4] = new int[]{12,13,14,15};
		
		for( int i = 0  ; i < num.length ; i++ ) {
			for( int j = 0 ; j < num[i].length ; j++ ) {
				System.out.printf("num[%d][%d] = %d\n", i, j, num[i][j]);
			}
			System.out.println();
		}

	}

}












