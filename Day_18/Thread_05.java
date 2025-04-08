package thread;

// 쓰레드의 이름을 지정하는 방법
// 쓰레드는 별도의 실행 흐름생성할 수 있는 방법입니다.
// 각각의 쓰레드에 이름을 지정하여 현재 실행중인 쓰레드를 확인할 수 있습니다.

// 쓰레드의 이름을 지정하기 위해서는 Thread 클래스의 String 타입을 매개변수로 하는
// 생성자를 활용합니다.

class Thread_05_A extends Thread {
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			// Thread 클래스의 static 메소드인 currentThread 메소드
			// 현재 JVM 에서 실행되고 있는 Thread 를 반환해주는 메소드
			// Thread 클래스의 getName 메소드
			// 해당 Thread 객체의 이름을 반환해 주는 메소드
			String name = Thread.currentThread().getName();
			System.out.printf("%s.i = %d\n", name, i);
		}
	}
}
class Thread_05_B extends Thread {
	public Thread_05_B(String name) {
		// 쓰레드의 이름을 지정하기 위해서
		// Thread 클래스의 String 타입을 매개변수로 하는
		// 생성자를 사용합니다.
		super(name);
	}
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
			String name = Thread.currentThread().getName();
			System.out.printf("%s.i = %d\n", name, i);
		}
	}
}
public class Thread_05 {
	public static void main(String[] args) {
		Thread_05_A a1 = new Thread_05_A();
		Thread_05_A a2 = new Thread_05_A();
		Thread_05_A a3 = new Thread_05_A();
		
		// 쓰레드의 이름을 지정하지 않으면
		// "Thread-인덱스" 의 형태로 이름이 자동할당 됩니다.
		// (인덱스는 0 부터 시작)
		//a1.start();	// Thread-0
		//a2.start(); // Thread-1
		//a3.start(); // Thread-2
		
		Thread_05_B b1 = new Thread_05_B("사용자 정의 쓰레드 - 1");
		Thread_05_B b2 = new Thread_05_B("사용자 정의 쓰레드 - 2");
		Thread_05_B b3 = new Thread_05_B("사용자 정의 쓰레드 - 3");
		
		b1.start();
		b2.start();
		b3.start();
	}
}









