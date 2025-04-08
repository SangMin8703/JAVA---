package thread;

// Java 프로그램의 구동 과정
// 1. 상수영역이 STACK 메모리에 적재
// 2. STATIC 영역이 STACK 메모리에 적재
// 3. JVM은 STATIC 영역에 존재하는 
//    public static void main(String[] args)
//    메소드를 사용하여 쓰레드를 구동
// 4. main 메소드의 코드를 사용하여 쓰레드가 구동되고
//    main 메소드의 실행이 종료되면 쓰레드가 종료되면서 프로그램이 종료됩니다.

public class Thread_06 {
	public static void main(String[] args) {
		String name = Thread.currentThread().getName();
		System.out.printf("현재 실행중인 쓰레드의 이름은 %s 입니다.\n", name);
	}
}
