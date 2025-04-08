import java.io.IOException;

public class PrintMethods {

	public static void main(String[] args) {
		
		// 출력에 활용되는 메소드
		// 1. print
		//  - 메소드의 매개변수를 출력하고, 자동 개행하지 않는 메소드
		// Hello Java_(커서의 위치)
		System.out.print("Hello ");
		System.out.print("Java");
		
		//  - print 메소드를 사용하는 경우 개행문자를 사용하여
		//    개행 여부를 제어할 수 있습니다.
		//  - 개행 문자 -> \n (new line)
		System.out.print("\n");
		System.out.print("Hello \n");
		System.out.print("Java\n");
		
		// 개행 문자를 지정할 때 사용되는 역슬래쉬 (\)는
		// Java의 문자열에서 의미를 가지는 문자 입니다.
		// 그렇기 때문에 \ 자체를 출력하기 위해서는
		// \\ 로 정의해야만 합니다.
		System.out.print("\\ \n");
		
		// '\' 를 활용한 특수 문자들
		// \t : tab 문자
		System.out.print("Hello\tJava\n");
		
		// \" : " 문자 자체를 출력하는 경우 사용
		System.out.print("지금은 \"Java\" 수업 시간입니다.\n");
		
		// \b : 백스페이스 문자
		// \b 를 사용하면 커서를 오른쪽에서 왼쪽으로 한 칸 이동할 수 있습니다.
		System.out.print("메뉴를 선택하세요 : [ ]\b\b");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 2. println
		// - 메소드의 매개변수를 출력하고, 자동 개행하는 메소드
		System.out.println("Hello ");
		System.out.println("Java");
		
		// 3. printf
		// - 메소드의 매개변수를 출력하고, 자동 개행하지 않는 메소드
		// 만약 출력하고자 하는 문자열의 내용중에 서식 문자가 포함되어 있다면,
		// 서식 문자의 자리에 특정 값을 출력하는 메소드
		
		// printf 메소드를 print 메소드와 동일한 형태로 사용하는 경우
		System.out.printf("Hello Java\n");
		
		// 서식 문자를 사용한 printf 메소드의 사용법
		// printf("문자열 포맷", 값1, 값2 ...);
		// 문자열 내부에 % 로 시작하는 서식문자가 존재한다면
		// 문자열 다음의 매개변수인 값1, 값2 를 사용하여 해당 위치에 출력합니다.
		
		// %d : 10 진수의 값을 출력하는 문자
		// %f : 부동소수점을 출력하는 문자
		// %c : 하나의 문자값을 출력하는 문자
		// %b : 진리형의 값을 출력하는 문자 (true / false)
		
		// %d 의 자리에 20의 값을 사용하여 출력하는 예제
		System.out.printf("10 + 10 = %d\n", 20);
		// 첫번째 %d의 자리에 가장 왼쪽의 10 을 사용하여 출력
		// 두번째 %d의 자리에 두번째 10 을 사용하여 출력
		// 세번째 %d의 자리에 마지막에 위치한 20 을 사용하여 출력
		System.out.printf("%d + %d = %d\n", 10, 10, 20);
		
		// 실수를 출력하는 경우
		System.out.printf("평균 점수는 %f 점 입니다.\n", 95.77);
		// 실수를 출력하되 자릿수를 지정하여 출력하는 예제 - 반올림 처리가 된 결과를 출력
		System.out.printf("평균 점수는 %.1f 점 입니다.\n", 95.77);
		// 실수를 출력하되 자릿수를 지정하여 출력하는 예제 - 전체 숫자의 자리수를 지정하여 출력
		// 전체 자리수(칸수)는 5자리를 사용하여 출력하고, 소수점 이하는 한자리만 출력 
		System.out.printf("평균 점수는 %5.1f 점 입니다.\n", 95.77);
		
		// 문자를 출력하는 경우
		// %c 를 사용하여 처리
		// %c 는 한개의 문자 값을 출력할 경우 사용
		// Java 에서 문자의 정의는 ' 를 사용하여 정의
		System.out.printf("시험 성적의 평가는 '%c' 입니다.\n", 'B');
		
		// 진리형의 값(true, false)을 출력하는 경우
		// %b 를 사용하여 처리		
		System.out.printf("10 > 5 = %b \n", 10 > 5);
		System.out.printf("10 < 5 = %b \n", 10 < 5);
	}

}











