package exception;

import java.util.Scanner;

// 사용자 정의 예외처리 클래스는 발생한 예외에 대한 
// 정보를 저장할 수 있습니다.
class InvalidRecordException extends Exception {
	private int record;

	InvalidRecordException(int record) {
		super("잘못된 성적이 입력 : " + record);
		this.record = record;
	}

	@Override
	public String getMessage() {		
		return String.valueOf(this.record);
	}	
}

public class Exception_20 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 3; i++) {
			System.out.printf("%d 번째 성적을 입력하세요 : ", i+1);
			int input = sc.nextInt();
			
			try {
				
				if (input < 0 || input > 100)
					throw new InvalidRecordException(input);
				
			} catch (InvalidRecordException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			
		}
	}
}
