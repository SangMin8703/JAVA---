package exception;

import java.util.Scanner;

// Exception 클래스를 사용한 예외처리 
// Java 의 모든 예외처리에 관련된 클래스들은
// Exception 클래스를 상속받습니다.
// Exception 클래스를 사용하면 어떠한 종류의 예외가 발생하더라도
// 하나의 catch 문을 사용하여 처리할 수 있습니다.

// catch 문에 전달되는 예외 객체는 메소드의 매개변수와 동일한 방법으로 처리되기 때문에
// 부모 클래스인 Exception 클래스의 레퍼런스를 사용하여
// 모든 자식 Exception 클래스의 객체를 참조할 수 있습니다.

public class Exception_08 {
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
		} catch( Exception e ) {
			System.out.println("try 블럭 내부에서 예외가 발생하였습니다.");
		}
		
		sc.close();
	}
}
