import java.util.Scanner;

public class Method_13 {	
	public static int getArraySize(Scanner sc) {		
		System.out.print("배열의 크기를 입력하세요 : ");		
		return sc.nextInt();
	}
	public static void insertValues(Scanner sc, int [] input) {
		System.out.println("배열에 값을 입력하세요");		
		for( int i = 0 ; i < input.length ; i++ ) {
			System.out.printf("%d 번째 정수를 입력하세요 : ", i+1);
			input[i] = sc.nextInt();
		}
	}
	public static int getMax(int [] input) {
		int result = input[0];		
		for( int i = 1 ; i < input.length ; i++ ) {
			if( input[i] > result )
				result = input[i];
		}		
		return result;
	}
	public static int getMin(int [] input) {
		int result = input[0];		
		for( int i = 1 ; i < input.length ; i++ ) {
			if( result > input[i] )
				result = input[i];
		}		
		return result;
	}
	public static double getAvg(int [] input) {
		int tot = 0;
		double result = 0;
		
		for( int i = 0 ; i < input.length ; i++ ) {
			tot += input[i];
		}
		result = (double)tot / input.length;
					
		return result;
	}
	public static void output(int [] input, int max, int min, double avg) {
		System.out.println("------------------");
		System.out.println("배열의 값 확인");
		System.out.println("------------------");
		for( int i = 0 ; i < input.length ; i++ ) {
			System.out.printf("input[%d] = %d\n", i, input[i]);
		}
		System.out.println("------------------");
		
		System.out.printf("입력된 배열의 요소 중 최대값은 %d,\n", max);
		System.out.printf("입력된 배열의 요소 중 최소값은 %d,\n", min);
		System.out.printf("입력된 배열의 요소의 평균값은 %.2f 입니다.\n", avg);
	}
	public static void main(String[] args) {
		// 사용자에게 배열의 크기를 입력받아 배열을 생성한 후,
		// 배열의 크기 만큼 정수를 입력하세요.
		// 입력이 종료된 후, 입력된 값중에 최대값, 최소값, 평균을 구하여 출력하세요.
		
		// 입력 변수 선언
		Scanner sc = new Scanner(System.in);
		int [] input;
		int arraySize;
		
		// 출력 변수 선언
		int max, min;
		double avg;
		
		// 입력 과정
		// 배열의 크기를 반환하는 getArraySize 메소드 호출
		arraySize = getArraySize(sc);
		input = new int[arraySize];
		
		// 배열의 값을 입력받는 insertValues 메소드 호출
		insertValues(sc, input);
		
		// 처리 과정
		max = getMax(input);
		min = getMin(input);
		avg = getAvg(input);
		
		// 출력 과정
		output(input, max, min, avg);
	}	

}







