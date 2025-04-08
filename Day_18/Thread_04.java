package thread;

// Java 언어에서 Thread를 생성하는 방법
// 1. java.lnag.Thread 클래스를 상속하는 방법
// 2. java.lnag.Runnable 인터페이스를 구현하는 방법
//  - Runnable 인터페이스를 구현하는 자식클래스의 선언
//  - Runnable 인터페이스의 추상메소드인 public void run() 메소드를 오버라이딩
//  - 자식 클래스의 객체를 생성
//  - Thread 클래스의 객체를 생성하면서 생성자의 매개변수로 자식클래스의 객체를 전달
//  - Thread 클래스의 객체를 사용하여 start 메소드를 호출

// 일반적으로 Runnable 인터페이스는 자주 사용되지 않습니다.
// 하지만 다중 상속이 필요한 경우 Runnable 인터페이스를 사용하여
// 해당 클래스가 쓰레드로 동작할 수 있도록 합니다.

class Thread_04_A implements Runnable {
	public void run() {
		for( int i = 0 ; i < 10  ; i++ ) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
			System.out.printf("Thread_04_A.i = %d\n", i);
		}		
	}	
}
class Thread_04_B implements Runnable {
	public void run() {
		for( int i = 0 ; i < 10  ; i++ ) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
			System.out.printf("Thread_04_B.i = %d\n", i);
		}		
	}	
}
public class Thread_04 {
	public static void main(String[] args) {	
		// Runnable 인터페이스를 구현하는 경우
		// 쓰레드의 생성방법
		// 1. 자식클래스의 객체 생성
		Thread_04_A a = new Thread_04_A();
		Thread_04_A b = new Thread_04_A();
		// 2. Thread 클래스의 객체 생성
		//  - 생성자의 매개변수로 Runnable 인터페이스를 구현한 객체를 전달
		Thread thread_a = new Thread(a);
		Thread thread_b = new Thread(b);
		// 3. 생성된 Thread 클래스의 객체를 사용하여 start 메소드르 실행
		thread_a.start();
		thread_b.start();
		
		// Thread 클래스의 객체 생성 시, 생성자의 매개변수로
		// Runnable 인터페이스를 구현한 객체가 전달되면
		// 해당 Thread 클래스의 객체는 start 메소드가 실행될 때
		// Runnable 인터페이스를 구현한 객체의 public void run()
		// 메소드를 호출하여 쓰레드를 구동합니다.
		
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












