
public class Array_19 {

	public static void main(String[] args) {
		// 다차원 배열의 복제

		int [][] num1 = {{10,20},{30,40}};
		// 2차원 배열의 복제도
		// 1차원 배열과 마찬가지로 clone 메소드를 사용하여 처리할 수 있습니다.
		int [][] num2 = num1.clone();
		
		System.out.println("배열을 복제한 후, 수정 전 결과");
		for( int i = 0 ; i < num1.length ; i++ ) {
			for( int j = 0 ; j < num1[i].length ; j++ ) {
				System.out.printf("num1[%d][%d] = %d, num2[%d][%d] = %d\n", 
						i, j, num1[i][j], i, j, num2[i][j]);
			}
		}
		
		// 다차원 배열의 경우
		// clone 메소드를 사용하여 복제하면,
		// 실제 데이터를 저장하는 1차원 배열까지 복제되는 것이 아닌
		// 해당 1차원 배열들을 관리하는 2차원 배열이 복제됩니다.
		
		// 아래의 수정 코드는 num1 배열이 참조하는 데이터가 수정되는 결과입니다. 
		num2[0][1] = 777;
		
		System.out.println("배열을 복제한 후, 수정 후 결과");
		for( int i = 0 ; i < num1.length ; i++ ) {
			for( int j = 0 ; j < num1[i].length ; j++ ) {
				System.out.printf("num1[%d][%d] = %d, num2[%d][%d] = %d\n", 
						i, j, num1[i][j], i, j, num2[i][j]);
			}
		}

	}

}






