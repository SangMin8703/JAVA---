
public class Array_09 {

	public static void main(String[] args) {
		// 레퍼런스 변수의 특징
		// 레퍼런스 변수는 다른 메모리의 참조값(주소값)을 가지는 변수입니다.
		
		// 배열 변수 선언(레퍼런스 변수)
		int [] arr1;
		int [] arr2;
		
		// 배열의 생성 및 배열 변수에 대입
		arr1 = new int[3];
		arr1[0] = 10;	arr1[1] = 20;	arr1[2] = 30;
		
		for( int i = 0 ; i < arr1.length ; i++ )
			System.out.printf("arr1[%d] = %d\n", i, arr1[i]);
		
		// 레퍼런스 변수 사이의 값의 대입
		// arr1 에 대입된 배열의 참조값을 arr2 에 대입
		// 동일한 배열을 arr1과 arr2 변수가 참조하는 모습
		arr2 = arr1;
		
		// arr2 레퍼런스 변수를 사용하여 배열 요소의 값을 수정
		// arr1 레퍼런스 변수를 사용하여 변경된 값을 확인할 수 있습니다.
		arr2[1] = 20000;
		
		for( int i = 0 ; i < arr1.length ; i++ )
			System.out.printf("arr1[%d] = %d\n", i, arr1[i]);

	}

}









