package thread;

// Java 언어에서 Thread를 생성하는 방법
// 1. java.lnag.Thread 클래스를 상속하는 방법
//  - Thread 클래스를 상속받는 자식 클래스의 선언
//  - Thread 클래스의 public void run() 메소드를 오버라이딩하여
//    쓰레드가 실행될 때, 실행할 코드를 작성
//  - 해당 클래스의 객체를 생성한 후, start() 메소드를 호출하여 쓰레드를 실행

// 2. java.lnag.Runnable 인터페이스를 구현하는 방법

class Thread_03_A extends Thread {
	public void run() {
		for( int i = 0 ; i < 10  ; i++ ) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
			System.out.printf("Thread_03_A.i = %d\n", i);
		}
	}
}
class Thread_03_B extends Thread {
	public void run() {
		for( int i = 0 ; i < 10  ; i++ ) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
			System.out.printf("Thread_03_B.i = %d\n", i);
		}
	}
}
public class Thread_03 {
	public static void main(String[] args) {	
		// Thread 클래스의 자식 클래스를 선언한 후,
		// 해당 클래스의 객체를 생성
		Thread_03_A a = new Thread_03_A();
		Thread_03_B b = new Thread_03_B();
		// 생성된 쓰레드 객체의 start 메소드를 호출
		// - 해당 객체를 쓰레드로 변환
		//   (별도의 실행 흐름을 실행할 수 있는 객체로 변환)
		// - 해당 객체의 run 메소드를 호출하여 쓰레드를 실행
		a.start();
		b.start();
		
		for( int i = 0 ; i < 10 ; i++ ) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
			System.out.printf("main.i = %d\n", i);
		}
	}
}
















