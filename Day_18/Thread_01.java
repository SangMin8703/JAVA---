package thread;

// 프로그램 : 컴퓨터를 제어할 수 있는 실행 코드의 집합
// 프로세스 : 프로그램의 코드를 메모리에 로딩한 상태에서
//         CPU를 사용(선점)해 실행 중인 상태
// 멀티태스킹 : 운영체제에서 다수개의 프로세스를 동시에 실행하는 개념
//          (CPU의 유휴시간을 감소시키지위한 방법으로 개발)
// 쓰레드(Thread) : 하나의 프로세스 내부에서 main 메소드의
//                흐름과 별도로 새로운 실행 흐름을 생성하는 방법

// 멀티태스킹과 쓰레드의 차이
// 멀티태스킹은 다수개의 프로세스들을 동시에 실행하기 위한 방법(기준은 다수개의 프로그램)
// 쓰레드는 하나의 프로세스 내부에서 다수개의 실행흐름을 생성하는 방법(병렬처리를 위한 방법)

// Java 언어에서 Thread를 생성하는 방법
// 1. java.lnag.Thread 클래스를 상속하는 방법
// 2. java.lnag.Runnable 인터페이스를 구현하는 방법

class Thread_01_A {
	public void run() {
		for( int i = 0 ; i < 10  ; i++ ) {
			System.out.printf("Thread_01_A.i = %d\n", i);
		}
	}
}
class Thread_01_B {
	public void run() {
		for( int i = 0 ; i < 10  ; i++ ) {
			System.out.printf("Thread_01_B.i = %d\n", i);
		}
	}
}
public class Thread_01 {
	public static void main(String[] args) {		
		// 쓰레드를 사용하지 않는 단일 흐름을 갖는 프로그램
		// main 메소드에 작성 된 실행 코드의 흐름을 따라서 실행됨
		// (단일의 실행 흐름을 갖음)
		Thread_01_A a = new Thread_01_A();
		Thread_01_B b = new Thread_01_B();
		a.run();
		b.run();
		
		for( int i = 0 ; i < 10  ; i++ ) {
			System.out.printf("main.i = %d\n", i);
		}
	}
}
















