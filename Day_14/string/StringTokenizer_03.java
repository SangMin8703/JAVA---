package string;

import java.util.StringTokenizer;

public class StringTokenizer_03 {

	public static void main(String[] args) {
		// 아래의 students 문자열 변수는
		// 세 명의 학생 이름과 각 학생의 성적 점수를 포함하고 있습니다.
		// StringTokenizer 클래스를 사용하여
		// 각 학생의 총점과 평균을 이름과 같이 출력하세요.
		// 출력 결과
		// 이순신 : 총점 -> 300 점, 평균 -> 100.00 점
		// 유관순 : 총점 -> 270 점, 평균 -> 90.00 점
		// 홍길동 : 총점 -> 240 점, 평균 -> 80.00 점
		
		String students = "이순신;100,100,100-유관순;90,90,90-홍길동;80,80,80";
				
		StringTokenizer st1 = new StringTokenizer(students, "-");
		while( st1.hasMoreTokens() ) {
			// "이순신;100,100,100", "유관순;90,90,90", "홍길동;80,80,80"
			String student = st1.nextToken();
			
			StringTokenizer st2 = new StringTokenizer(student, ";");
			// 이순신, 유관순, 홍길동
			String name = st2.nextToken();
			
			// "100,100,100", "90,90,90", "80,80,80"
			String numbers = st2.nextToken();
			StringTokenizer st3 = new StringTokenizer(numbers, ",");
			int tot = 0;
			double avg = 0;
			while(st3.hasMoreTokens()) {
				String strNum = st3.nextToken();
				// 문자열로 이뤄진 정수를 실제 정수타입으로 반환하는 방법
				// Integer 클랙스의 parseInt 메소드를 사용하여 처리
				// Integer.parseInt("10");
				// 위의 코드실 int 타입의 10 을 반환합니다.
				int num = Integer.parseInt(strNum);
				tot += num;
			}
			avg = tot / 3.0;
			System.out.printf("%s : 총점 -> %d 점, 평균 -> %.2f 점\n", 
					name, tot, avg);			
		}
	}
}









