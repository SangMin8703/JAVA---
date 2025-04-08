package thread;

// Java 언어에서 Thread를 생성하는 방법
// 1. java.lnag.Thread 클래스를 상속하는 방법
//  - Thread 클래스를 상속받는 자식 클래스의 선언
//  - Thread 클래스의 public void run() 메소드를 오버라이딩하여
//    쓰레드가 실행될 때, 실행할 코드를 작성
//  - 해당 클래스의 객체를 생성한 후, start() 메소드를 호출하여 쓰레드를 실행

// 2. java.lnag.Runnable 인터페이스를 구현하는 방법

class Thread_02_A extends Thread {
	public void run() {
		for( int i = 0 ; i < 10  ; i++ ) {
			System.out.printf("Thread_02_A.i = %d\n", i);
		}
	}
}
class Thread_02_B extends Thread {
	public void run() {
		for( int i = 0 ; i < 10  ; i++ ) {
			System.out.printf("Thread_02_B.i = %d\n", i);
		}
	}
}
public class Thread_02 {
	public static void main(String[] args) {	
		// Thread 클래스의 자식 클래스를 선언한 후,
		// 해당 클래스의 객체를 생성
		Thread_02_A a = new Thread_02_A();
		Thread_02_B b = new Thread_02_B();
		// 생성된 객체를 사용하여 오버라이딩한 run 메소드를 호출
		// - run 메소드는 쓰레드를 구동하는 메소드가 아님
		//   (쓰레드로 처리되지 않습니다.)
		// - 쓰레드로 구동되기 위해서는 해당 객체의 
		//   start() 메소드를 호출해야만 합니다.
		a.run();
		b.run();
		
		for( int i = 0 ; i < 10  ; i++ ) {
			System.out.printf("main.i = %d\n", i);
		}
	}
}
















