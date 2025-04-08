
public class Method_08 {
	// 메소드 매개변수의 사용
	// call by value, call by reference
	// call by value - 메소드의 매개변수로 값을 전달하는 방식
	// call by reference - 매소드의 매개변수로 레퍼런스(참조값)을 전달하는 방식
		
	// call by reference - 참조값(주소값)을 전달하여 메소드를 실행하는 방식
	public static void methodTest_1( int [] arr ) {		
		
		// call by reference 호출 방식 특징
		// 호출된 메소드에서 매개변수로 전달된 참조값을 사용하여
		// 변수의 값을 수정하면
		// 원본 데이터( main 메소드의 arr 배열 ) 가 수정됩니다.
		// 지역변수는 서로 다르지만( main 의 arr, methodTest_1 의 arr)
		// 참조하게 되는 공간이 동일하기 때문입니다.
		arr[ arr.length - 1 ] = 1000;
		System.out.printf("arr[%d] = %d\n", arr.length-1, arr[arr.length-1]);
		
	}
	
	public static void main(String[] args) {
		
		int [] arr = new int[]{10, 20, 30, 40, 50, 60, 70};

		System.out.println("메소드 호출 전");
		System.out.printf("arr[%d] = %d\n", arr.length-1, arr[arr.length-1]);
		
		methodTest_1(arr);
		
		System.out.println("메소드 호출 후");
		System.out.printf("arr[%d] = %d\n", arr.length-1, arr[arr.length-1]);
	}

}










