package thread;

class Thread_09_A extends Thread {
	public void run() {
		for( int i = 0 ; i < 10  ; i++ ) {			
			System.out.printf("i = %d\n", i);
			try {				
				Thread.sleep(500);
			} catch( InterruptedException e ) {
				e.printStackTrace();
			}
		}
	}	
}
public class Thread_09 {
	public static void main(String[] args) {	
		System.out.println("프로그램 시작");
		
		Thread_09_A a = new Thread_09_A();
		a.start();
		
		// Thread 클래스의 join 메소드
		// 쓰레드 객체의 레퍼런스.join();
		// EX) a.join();
		// join 메소드를 실행하는 쓰레드는 해당 레퍼런스의 쓰레드가 
		// 실행을 종료할때까지 중지 상태로 만듭니다.
		// 해당 레퍼런스의 쓰레드가 실행을 종료하면 
		// 다시 동작을 시작하도록 합니다.
		
		// join 메소드도 sleep 메소드와 마찬가지로 
		// InterruptedException 예외를 처리해야만 합니다.
		
		try {
			// main 쓰레드를 a 레퍼런스의 쓰레드가 실행을 종료할 때 까지 중지시킵니다.
			// a 레퍼런스의 쓰레드가 실행을 종료하면 main 쓰레드를 다시 구동합니다.
			a.join();
		} catch( InterruptedException e ) {
			e.printStackTrace();
		}
		
		System.out.println("프로그램 종료");
		
	}
}















