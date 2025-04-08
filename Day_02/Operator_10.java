
public class Operator_10 {

	public static void main(String[] args) {
		// 삼항연산자
		// 조건식 결과의 참/거짓에 따라서 실행의 흐름을 분기할 수 있는 연산자
		// 조건식 : 관계식 또는 논리연산자를 사용하여 작성된 식
		//        조건식의 결과는 참 또는 거짓의 진리형의 결과를 반환합니다.
		// 조건식 ? 참일경우의 값 또는 식 : 거짓일경우의 값 또는 식;
		
		int gender = 2;
		
		// %s : 문자열
		System.out.printf("당신의 성별은 %s 입니다.\n", 
				(gender == 1 || gender == 3) ? "남자" : "여자");
		

	}

}
