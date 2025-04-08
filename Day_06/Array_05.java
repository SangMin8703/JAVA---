import java.util.Scanner;

public class Array_05 {

	public static void main(String[] args) {
		// 사용자에게 5과목의 성적을 입력받아
		// (배열을 사용하여 성적 점수를 저장하고)
		// 총점과 평균을 계산하여 출력하세요.
		
		// 입력변수 선언
		Scanner sc = new Scanner(System.in);
		int n1, n2, n3, n4, n5;
		int [] num = new int[5];
		
		// 출력변수 선언
		int tot;
		double avg;
		
		// 처리 과정
		
		// 성적을 저장하기 위해서 사용되는 변수가 각각의 변수로 선언된 케이스
		// 중복되는 코드가 발생하고 있음
		/*
		System.out.print("1 번째 성적을 입력하세요 : ");
		n1 = sc.nextInt();
		System.out.print("2 번째 성적을 입력하세요 : ");
		n2 = sc.nextInt();
		System.out.print("3 번째 성적을 입력하세요 : ");
		n3 = sc.nextInt();
		System.out.print("4 번째 성적을 입력하세요 : ");
		n4 = sc.nextInt();
		System.out.print("5 번째 성적을 입력하세요 : ");
		n5 = sc.nextInt();
		*/
		
		// 배열을 사용한 성적 입력
		for( int i = 0 ; i < 5 ; i++ ) {
			System.out.printf("%d 번째 성적을 입력하세요 : ", i+1);
			num[i] = sc.nextInt();
		}
		
		// 배열을 사용하지 않은 경우 총점 계산
		//tot = n1 + n2 + n3 + n4 + n5;
		
		// 배열을 사용한 총점 계산
		tot = 0;
		for( int i = 0 ; i < 5 ; i++ ) {			
			tot += num[i];
		}
		
		avg = tot / 5.0;
		
		
		// 출력 처리
		System.out.println("----------------------------------");
		System.out.println("입력된 성적 점수 출력");
		System.out.println("----------------------------------");
		for( int i = 0 ; i < 5 ; i++ ) {	
			System.out.printf("%d : %d 점\n", i+1, num[i]);
		}
		System.out.println("----------------------------------");
		System.out.printf("총점 : %d 점\n평균 : %.2f 점\n", tot, avg);
		

	}

}












