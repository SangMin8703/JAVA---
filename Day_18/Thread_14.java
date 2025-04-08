package thread;

// 공유자원
class Num_NotSync {
	// 멤버필드 n 의 값은 항상 0 이상이여만 합니다.  
	private int n;	
	public Num_NotSync(int n) {
		this.n = n;
	}	
	public void plus() {
		String name = Thread.currentThread().getName();		
		n++;		
		System.out.printf("%s 쓰레드가 n 변수의 값 %d 로 증가시킴\n", name, this.n);
	}
	public void minus() {
		String name = Thread.currentThread().getName();		
		n--;		
		System.out.printf("%s 쓰레드가 n 변수의 값 %d 로 감소시킴\n", name, this.n);
	}
}
// 공유자원에 접근하는 쓰레드 클래스의 생성
class Plus_NotSync extends Thread {
	private Num_NotSync num;
	public Plus_NotSync(String name, Num_NotSync num) {
		super(name);
		this.num = num;
	}
	public void run() {
		while( true ) {
			this.num.plus();
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
	}
}
class Minus_NotSync extends Thread {
	private Num_NotSync num;
	public Minus_NotSync(String name, Num_NotSync num) {
		super(name);
		this.num = num;
	}
	public void run() {
		while( true ) {
			this.num.minus();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
	}
}
public class Thread_14 {
	public static void main(String[] args) {
		// 공유자원의 객체 생성
		Num_NotSync num = new Num_NotSync(10);
		// 공유자원을 사용하는 쓰레드 객체 생성
		Plus_NotSync plus = new Plus_NotSync("plus", num);
		Minus_NotSync minus = new Minus_NotSync("minus", num);
		
		plus.start();
		minus.start();	
	}
}







