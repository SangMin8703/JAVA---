
public class Array_07 {

	public static void main(String[] args) {
		// 배열의 크기
		// 배열의 크기는 프로그램에서 중요한 정보입니다.
		// 대다수의 프로그램에서 배열을 사용하면
		// 반복문을 사용하여 제어하게 됩니다.
		// 이때 배열의 크기가 변경이 되면, 
		// 배열을 사용하는 모든 반복문의 조건식이 수정되야만 합니다.
		// 만약, 반복문에서 배열의 크기를 잘못 수정하면
		// 런타임 에러가 발생하여 프로그램이 강제 종료됩니다.
		// 이러한 문제를 해결하기 위해서 Java의 모든 배열은 length 속성을 제공합니다.
		// 배열변수명.length 는 해당 배열의 크기를 반환합니다.
		
		// 배열변수명.length 속성을 사용하면,
		// 배열의 크기가 변경되는 경우 프로그램 코드의 수정을 최소화할 수 있습니다.
		
		int [] arr = new int[15];
		
		for( int i = 0 ; i < arr.length ; i++ ) {
			arr[i] = 10 * (i+1);
		}
		
		for( int i = 0 ; i < arr.length ; i++ ) {
			System.out.printf("arr[%d] = %d\n", i, arr[i]);
		}
	}

}












