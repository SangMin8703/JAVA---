
public class Array_18 {

	public static void main(String[] args) {
		// 배열의 복제
		// Java의 배열은 복제가 가능합니다.
		// clone 메소드

		// 1 차원 배열의 경우 clone 메소드를 활용하여 완벽한 배열의 복제가 가능합니다.
		// 두개의 배열간에 완전 분리
		
		int [] num1 = {10, 20, 30};
		// 배열변수.clone();
		// 해당 배열을 복제하여 반환
		int [] num2 = num1.clone();
		
		System.out.println("배열을 복제한 후, 수정 전 결과");
		for( int i = 0 ; i < num1.length ; i++ ) {
			System.out.printf("num1[%d] = %d, num2[%d] = %d\n", 
					i, num1[i], i, num2[i]);
		}
			
		num2[1] = 777;
		
		System.out.println("배열을 복제한 후, 수정 후 결과");
		for( int i = 0 ; i < num1.length ; i++ ) {
			System.out.printf("num1[%d] = %d, num2[%d] = %d\n", 
					i, num1[i], i, num2[i]);
		}

	}

}









