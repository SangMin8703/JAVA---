package exception;
import java.util.InputMismatchException;
import java.util.Scanner;

// 다수개의 예외 처리를 지워하는 try ~ catch 구문
/*
 	try {
	 	예외가 발생할 수 있는 실행코드 ...
 	} catch( 1번째 예외처리 클래스의 변수를 선언 ) {
 		1번째 예외가 발생할 경우 실행할 코드
 	} catch( 2번째 예외처리 클래스의 변수를 선언 ) {
 		2번째 예외가 발생할 경우 실행할 코드
 	}

*/

public class Exception_07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] arr;
		int size;
		
		try {
			
			System.out.print("배열의 크기를 입력하세요 : ");
			size = sc.nextInt();
			
			arr = new int[size];
			
			for( int i = 0 ; i <= arr.length ; i++ ) {
				System.out.printf("%d 번째 배열 요소 : ", i+1);
				arr[i] = sc.nextInt();
			}		
			for( int i = 0 ; i < arr.length ; i++ )
				System.out.printf("arr[%d] = %d\n", i, arr[i]);
			
		} catch( InputMismatchException e ) {
			System.out.println("배열의 크기는 정수로 입력하세요.");
		} catch( ArrayIndexOutOfBoundsException e ) {
			System.out.println("배열의 인덱스 연산에서 문제가 발생했습니다.");
		}
		
		sc.close();
	}
}










