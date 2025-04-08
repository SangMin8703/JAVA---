// 객체지향에서 정의하는 클래스의 제약 조건
// 1. 캡슐화
//  - 클래스 내부에는 해당 클래스가 제공하고자 하는 기능에 연관된 멤버만 선언하여 사용합니다.
// 2. 정보은닉
//  - 클래스의 내부의 데이터를 외부에 노출하지 않고, 기능만을 외부에 노출하여 사용하도록 합니다.

// 정보은닉의 개념을 적용하지 않은 클래스
// 모든 멤버 public 으로 지정된 클래스
class Account_NoHide {
	// 통장 잔고
	public int balance;	
	// 입금
	public void deposit(int money) {
		balance += money;
	}
	// 출금
	public void withdraw(int money) {
		// 현재 잔고가 출금하고자 하는 금액 이상일 경우에만 출금 기능을 수행
		if( balance >= money )
			balance -= money;
		else
			System.out.println("잔고가 부족합니다.");
	}
	// 잔고 확인
	public void display() {
		System.out.printf("현재 계좌의 잔고는 %d 원입니다.\n", balance);
	}
}
// 정보은닉의 개념을 적용한 Account 클래스
class Account {
	// 통장 잔고
	private int balance;	
	// 입금
	public void deposit(int money) {
		balance += money;
	}
	// 출금
	public void withdraw(int money) {
		// 현재 잔고가 출금하고자 하는 금액 이상일 경우에만 출금 기능을 수행
		if( balance >= money )
			balance -= money;
		else
			System.out.println("잔고가 부족합니다.");
	}
	// 잔고 확인
	public void display() {
		System.out.printf("현재 계좌의 잔고는 %d 원입니다.\n", balance);
	}
}
public class Class_Access_03 {
	public static void main(String[] args) {
		Account_NoHide account_1 = new Account_NoHide();
		
		account_1.deposit(100000);
		account_1.display();
		account_1.withdraw(50000);
		account_1.display();
		account_1.withdraw(150000);
		account_1.display();	
		
		// 정보은닉의 개념을 지키지 않고
		// 멤버필드를 외부에 노출하게 되면
		// 아래와 같이 메소드를 통하여 멤버의 값이 변경되는 것이 아닌
		// 직접적인 값의 수정이 가능하게 되므로
		// 정보은닉의 개념을 지켜서 클래스를 설계하는 것이 중요합니다.
		account_1.balance = 0;
		
		Account account_2 = new Account();
		
		account_2.deposit(100000);
		account_2.display();
		account_2.withdraw(50000);
		account_2.display();
		account_2.withdraw(150000);
		account_2.display();	
		
		// 정보은닉의 개념을 적용한 클래스의 경우
		// 아래와 같이 private 멤버에 직접 접근이 차단되어
		// 값을 수정할 수 없습니다.
		// 이런 경우 balance 필드의 값 수정은
		// 반드시 Account 클래스의 메소드 호출에 의해서만 
		// 가능하기 때문에, balance 필드의 값을 안전하게 수정할 수 있습니다.
		// (메소드 내부의 분기문을 사용하여 예외적인 경우를 처리핤 수 있음 - withdraw 메소드)
		//account_2.balance = 0;

	}
}










