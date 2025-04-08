package thread;

class Thread_08_A extends Thread {
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
public class Thread_08 {
	public static void main(String[] args) {	
		System.out.println("프로그램 시작");
		
		Thread_08_A a = new Thread_08_A();
		a.start();
		
		// 쓰레드는 각각의 실행 흐름을 가지고 실행되게 됩니다.
		// main 쓰레드는 main 메소드의 정의된 실행코드가 종료되면
		// 다른 쓰레드의 실행 여부와 관계없이 종료됩니다.
		System.out.println("프로그램 종료");
		
	}
}















