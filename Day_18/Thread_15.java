package thread;

import java.util.Random;

// 다수개의 쓰레드가 하나의 공유자원에 대해서
// 서로 다른 로직(메소드)을 실행하는 경우
// 실행 로직이 서로 상충되는 발생합니다.
// 이런 경우, 한쪽의 쓰레드를 잠시 중지시키고,
// 다른 쓰레드를 구동하여 중지된 쓰레드를 살려줄 수 있습니다.

// 공유자워에 대해서 wait 메소드를 호출하는 쓰레드는 중지상태로 진입하게 되고
// 공유자원에 대해서 notify 메소드를 호출하면 형재 공유자원에 wait 메소드를 호출한
// 쓰레드가 다시 동작하도록 할 수 있습니다.

// 공유자원
class Num_Sync {
	// 1. 멤버필드 n 의 값은 항상 0 이상이여만 합니다.  
	// 2. 멤버필드 n 의 값은 항상 10 이하여만 합니다.
	private int n;	
	public Num_Sync(int n) {
		this.n = n;
	}	
	public synchronized void plus() {
		String name = Thread.currentThread().getName();		
		
		if( n == 10 ) {
			System.out.printf("%s 쓰레드가 wait 상태로 들어감\n", name);
			try {
				wait();
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
			System.out.printf("%s 쓰레드가 wait 상태에서 돌아옴\n", name);
		}
			
		n++;
		
		if( n >= 5 )
			notify();
		
		System.out.printf("%s 쓰레드가 n 변수의 값 %d 로 증가시킴\n", name, this.n);
	}
	public synchronized void minus() {
		String name = Thread.currentThread().getName();
		
		if( n == 0 ) {
			System.out.printf("%s 쓰레드가 wait 상태로 들어감\n", name);			
			try {
				wait();
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
			System.out.printf("%s 쓰레드가 wait 상태에서 돌아옴\n", name);
		}
		
		n--;
		
		if( n <= 5 )
			notify();
		
		System.out.printf("%s 쓰레드가 n 변수의 값 %d 로 감소시킴\n", name, this.n);
	}
}
// 공유자원에 접근하는 쓰레드 클래스의 생성
class Plus_Sync extends Thread {
	private Num_Sync num;
	public Plus_Sync(String name, Num_Sync num) {
		super(name);
		this.num = num;
	}
	public void run() {
		Random random = new Random();
		while( true ) {
			this.num.plus();
			
			try {
				Thread.sleep(random.nextInt(5000));
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
	}
}
class Minus_Sync extends Thread {
	private Num_Sync num;
	public Minus_Sync(String name, Num_Sync num) {
		super(name);
		this.num = num;
	}
	public void run() {
		Random random = new Random();
		while( true ) {
			this.num.minus();
			
			try {
				Thread.sleep(random.nextInt(5000));
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
	}
}
public class Thread_15 {
	public static void main(String[] args) {
		// 공유자원의 객체 생성
		Num_Sync num = new Num_Sync(5);
		// 공유자원을 사용하는 쓰레드 객체 생성
		Plus_Sync plus = new Plus_Sync("plus", num);
		Minus_Sync minus = new Minus_Sync("minus", num);
		
		plus.start();
		minus.start();	
	}
}







