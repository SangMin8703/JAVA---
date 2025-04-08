package thread;

// 쓰레드의 우선순위
// 각가의 쓰레드는 우선순위의 값을 가질 수 있습니다.
// 만약, 빠른 실행을 요하는 쓰레드의 경우에는 높은 우선순위를 부여하여
// 조금 더 빠른 실행을 할 수 있습니다.
class Thread_10_A extends Thread {
	public Thread_10_A(String name) {
		super(name);
	}
	public void run() {
		for( int i = 0 ; i < 10  ; i++ ) {						
			System.out.printf("%s.i = %d\n", this.getName(), i);			
		}
	}
}
public class Thread_10 {
	public static void main(String[] args) {		
		Thread_10_A a1 = new Thread_10_A("T1");
		Thread_10_A a2 = new Thread_10_A("T2");
		Thread_10_A a3 = new Thread_10_A("T3");
		Thread_10_A a4 = new Thread_10_A("T4");
		Thread_10_A a5 = new Thread_10_A("T5");
		
		// 쓰레드의 우선 순위 지정 방법
		// Thread 클래스의 setPriority 메소드를 사용하여 우선순위를 지정
		// 가장 실행권이 높은 우선순위의 값은 10
		// 가장 실행권이 낮은 우선순위의 값은 1
		// 중간의 값은 5
		// 쓰레드의 우선위를 지정하지 않은 기본값은 5로 할당
		// 우선순위의 값이 높은 쓰레드는 우선순위가 낮은 쓰레드에 비해
		// 자주 실행이 됩니다.
		// Thread.MAX_PRIORITY -> 10
		// Thread.MIN_PRIORITY -> 1
		// Thread.NORM_PRIORITY -> 5
		a1.setPriority(Thread.MAX_PRIORITY);
		a5.setPriority(Thread.MIN_PRIORITY);
		
		a1.start();
		a2.start();
		a3.start();
		a4.start();
		a5.start();
		
	}
}







