package exception;

// Exception 클래스의 printStackTrace 메소드의 출력 결과 분석

/*
Exception in thread "main" java.lang.NullPointerException
	at exception.Exception_11.exception_05(Exception_11.java:28)
	at exception.Exception_11.exception_04(Exception_11.java:24)
	at exception.Exception_11.exception_03(Exception_11.java:21)
	at exception.Exception_11.exception_02(Exception_11.java:18)
	at exception.Exception_11.exception_01(Exception_11.java:15)
	at exception.Exception_11.main(Exception_11.java:32)
*/
// 첫번째 라인은 예외 객체의 타입을 출력
// 두번째 라인은 최종적으로 예외가 발생한 위치
// 두번째 이후의 라인은 최종적으로 예외가 발생하기 까지 호출된 메소드의 순서를 보여줍니다.
// (STACK 메모리의 메소드 순서를 출력합니다.)

// 위의 예외 메세지는
// main 메소드에서 exception_01 메소드를 실행하고,
// exception_01에서 exception_02 메소드를 호출
// exception_02에서 exception_03 메소드를 호출
// exception_03에서 exception_04 메소드를 호출
// exception_04에서 exception_05 메소드를 호출
// exception_05 메소드를 실행하는 도중 NullPointerException 예외가 발생

public class Exception_11 {
	public static void exception_01() {
		exception_02();
	}
	public static void exception_02() {
		exception_03();
	}
	public static void exception_03() {
		exception_04();
	}
	public static void exception_04() {
		exception_05();
	}
	public static void exception_05() {
		String message = null;
		int size = message.length();
		System.out.printf("size = %d\n", size);
	}
	public static void main(String[] args) {
		exception_01();
	}
}





