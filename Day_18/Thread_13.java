package thread;

// 동기화
// 하나의 공유자원을 다수개의 쓰레드가 동시에 사용하는 경우 
// 발생하는 문제를 해결하기 위한 방법
// 하나의 공유자원 특정 쓰레드가 접근하면
// 다른 쓰레드들은 해당 쓰레드가 실행을 마치고 빠져나올때까지 대기할 수 있도록 합니다.

// 공유자원 클래스
// 다수개의 쓰레드가 하나의 RestRoom 클래스의 객체를 사용합니다.
class RestRoom_Sync {
	
	// use 메소드는 다수개의 쓰레드가 동시에 접근하는 메소드입니다.
	// 이런경우 다수개의 쓰레드가 동시에 해당 메소드를 실행할 수 없도록
	// 동기화 처리를 해야만 합니다.
	// 동기화는 synchronized 키워드를 사용하여 처리할 수 있습니다.
	// synchronized 키워드가 적용된 메소드, 코드 블럭은
	// 하나의 쓰레드만이 실행되는 것을 보장합니다.
	// (다른 쓰레드는 실행 중인 쓰레드가 빠져나오기 전까지 진입할 수 없습니다.)
	public synchronized void use() {		
		String name = Thread.currentThread().getName();
		System.out.printf("%s 님이 사용 중 입니다.\n", name);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		
		System.out.printf("%s 님이 사용을 마치고 나갑니다.\n", name);
	}
}
class Person_Sync extends Thread {
	private RestRoom_Sync restRoom;
	public Person_Sync(String name, RestRoom_Sync restRoom) {
		super(name);
		this.restRoom = restRoom;
	}
	public void run() {
		this.restRoom.use();
	}
}
public class Thread_13 {
	public static void main(String[] args) {		
		RestRoom_Sync restRoom = new RestRoom_Sync();
		Person_Sync p1 = new Person_Sync("A", restRoom);
		Person_Sync p2 = new Person_Sync("B", restRoom);
		Person_Sync p3 = new Person_Sync("C", restRoom);
		
		p1.start();
		p2.start();
		p3.start();
	}
}










