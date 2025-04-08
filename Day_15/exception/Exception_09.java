package exception;
import java.util.Scanner;

// 다중 catch 문과 Exception 클래스의 활용
// 다중 catch 문을 작성하면서
// Exception 클래스 타입의 catch 문을 추가하려면
// 반드시 Exception 클래스 타입의 catch 문은
// 마지막에 위치해야 합니다.

// Exception 클래스는 모든 예외 처리의 클래스의 최상위 부모 클래스이기 때문에
// Exception 클래스의 catch 문 이후의 catch 문들은 실행될 수 없습니다.

public class Exception_09 {
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
		} catch( ArrayIndexOutOfBoundsException e ) {
			System.out.println("배열 인덱스 연산에서 예외가 발생했습니다.");
		} catch( Exception e ) {
			System.out.println("try 블럭 내부에서 예외가 발생하였습니다.");
		}
		
		sc.close();
	}
}







