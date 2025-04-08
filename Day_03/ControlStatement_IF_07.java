import java.util.Scanner;

public class ControlStatement_IF_07 {

	public static void main(String[] args) {
		// 사용자로부터 3개의 정수를 입력받아
		// 최대값과 최소값, 평균을 출력하세요.
		
		// 변수의 선언
		// 입력에 사용되는 변수
		Scanner sc = new Scanner(System.in);
		int num1, num2, num3;
		
		// 출력에 사용되는 변수
		int max, min;
		double avg;
		
		// 입력 과정
		System.out.print("1번째 정수를 입력하세요 : ");
		num1 = sc.nextInt();
		System.out.print("2번째 정수를 입력하세요 : ");
		num2 = sc.nextInt();
		System.out.print("3번째 정수를 입력하세요 : ");
		num3 = sc.nextInt();
		sc.close();
		
		// 처리 과정
		// 평균 값 계산
		avg = (num1 + num2 + num3) / 3.0;
		
		// 최대값
		// num1 과 num2 를 비교하여 더 큰 수를 max 변수에 대입		
		if( num1 > num2 )
			max = num1;
		else
			max = num2;
		// num1과 num2 를 비교하여 큰 수를 추출한 max 를 num3 과 비교하여
		// 최대값 처리
		if( num3 > max )
			max = num3;
		
		// 최소값
		// num1 과 num2 를 비교하여 더 작은 수를 min 변수에 대입		
		if( num1 > num2 )
			min = num2;
		else
			min = num1;
		// num1과 num2 를 비교하여 작은 수를 추출한 min 변수를 num3 과 비교하여
		// 최소값 처리
		if( min > num3 )
			min = num3;
		
		// 출력 처리
		System.out.printf("3개 정수의 평균 값은 %.2f,\n", avg);
		System.out.printf("3개 정수 중 최대 값은 %d,\n", max);
		System.out.printf("3개 정수 중 최소 값은 %d 입니다.\n", min);
	}

}










