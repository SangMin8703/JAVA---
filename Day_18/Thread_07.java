package thread;

// Thread 클래스의 sleep 메소드
// sleep 메소드는 static 메소드입니다.
// Thread 클래스의 객체 생성없이 Thread.sleep 으로 사용이 가능합니다.
// sleep 메소드는 현재 실행 중인 쓰레드를 일정시간동안 동작을 멈추게 하는 기능을 제공합니다.
// sleep 메소드는 매개변수로 밀리세컨드의 값을 전달받습니다.
// (밀리세컨 : 1 초의 경우 1000)
// sleep 메소드는 전달받은 매개변수를 사용하여 해당 시간만큼 쓰레드를 중지시킵니다.

// sleep 메소드는 쓰레드의 실행을 중지한 후 다시 되살리는 작업을 하게됩니다.
// 이런 경우 치명적인 예외가 발생될 가능성이 있기 때문에
// 반드시 InterruptedException 을 예외처리해야만 컴파일이 됩니다.
class Thread_07_A extends Thread {
	public void run() {
		for( int i = 0 ; i < 10  ; i++ ) {			
			System.out.printf("i = %d\n", i);
			try {
				// 1초 동안 현재 쓰레드의 동작을 중지합니다.
				Thread.sleep(10000);
			} catch( InterruptedException e ) {
				e.printStackTrace();
			}
		}
	}	
}
public class Thread_07 {
	public static void main(String[] args) {		
		Thread_07_A a = new Thread_07_A();
		a.start();
	}
}





