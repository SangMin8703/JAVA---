import java.util.Scanner;

public class Array_08 {

	public static void main(String[] args) {
		// 입력변수 선언
		Scanner sc = new Scanner(System.in);
		int arraySize;
		int [] source;
		int selectCode;
		int result;
		
		// 입력 과정 처리
		do {
			System.out.print("배열의 크기를 입력하세요 : ");
			arraySize = sc.nextInt();
		} while(arraySize <= 0);		
		
		source = new int[arraySize];
		
		for( int i = 0 ; i < source.length ; i++ ) {
			System.out.printf("배열의 %d 번째 요소의 값을 입력하세요 : ", i+1);
			source[i] = sc.nextInt();
		}
		
		do {
			System.out.println("실행할 기능을 선택하세요"); 
			System.out.println("1. 최대값 출력");
			System.out.println("2. 최소값 출력");
			System.out.println("3. 오름차순 정렬 출력");
			System.out.println("4. 내림차순 정렬 출력");
			System.out.println("5. 프로그램 종료");
			System.out.print("입력 : ");
			if( (selectCode = sc.nextInt()) == 5 )
				break;
			
			switch(selectCode) {
				case 1:
					result = source[0];					
					for( int i = 1 ; i < source.length ; i++ ) {
						if( source[i] > result )
							result = source[i];						
					}
					System.out.printf("입력된 정수 중 최대값은 %d 입니다.\n\n", result);
					break;
				case 2:
					result = source[0];					
					for( int i = 1 ; i < source.length ; i++ ) {
						if( source[i] < result )
							result = source[i];						
					}
					System.out.printf("입력된 정수 중 최소값은 %d 입니다.\n\n", result);
					break;
				case 3:
					for( int i = 0 ; i < source.length - 1 ; i++ ) {
						for( int j = i + 1 ; j < source.length ; j++ ) {					
							if( source[i] > source[j] ) {
								int swapValue = source[i];
								source[i] = source[j];
								source[j] = swapValue;
							}							
						}
					}
					
					System.out.println("오름 차순 정렬 결과 출력");
					for( int i = 0 ; i < source.length ; i++ )
						System.out.printf("%d ", source[i]);
					System.out.println();
					System.out.println();
					break;
				case 4:
					for( int i = 0 ; i < source.length - 1 ; i++ ) {
						for( int j = i + 1 ; j < source.length ; j++ ) {					
							if( source[i] < source[j] ) {
								int swapValue = source[i];
								source[i] = source[j];
								source[j] = swapValue;
							}							
						}
					}
					
					System.out.println("내림 차순 정렬 결과 출력");
					for( int i = 0 ; i < source.length ; i++ )
						System.out.printf("%d ", source[i]);
					System.out.println();
					System.out.println();
					break;
				default:
					System.out.println("잘못된 메뉴 번호를 선택했습니다.\n");
			}			
		} while( true );
		
		System.out.println("프로그램 종료");
	}

}








