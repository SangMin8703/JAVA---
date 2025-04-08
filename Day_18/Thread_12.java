package thread;

// 동기화
// 하나의 공유자원을 다수개의 쓰레드가 동시에 사용하는 경우 
// 발생하는 문제를 해결하기 위한 방법
// 하나의 공유자원 특정 쓰레드가 접근하면
// 다른 쓰레드들은 해당 쓰레드가 실행을 마치고 빠져나올때까지 대기할 수 있도록 합니다.

// 공유자원 클래스
// 다수개의 쓰레드가 하나의 RestRoom 클래스의 객체를 사용합니다.
class RestRoom_NotSync {
	public void use() {
		
		// use 메소드는 동기화를 처리하지 않았기 때문에
		// 특정한 상황에서 다수개 쓰레드가 동시에 실행되는 것을
		// 제한할 수 없습니다.
		
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
class Person_NotSync extends Thread {
	private RestRoom_NotSync restRoom;
	public Person_NotSync(String name, RestRoom_NotSync restRoom) {
		super(name);
		this.restRoom = restRoom;
	}
	public void run() {
		this.restRoom.use();
	}
}
public class Thread_12 {
	public static void main(String[] args) {		
		RestRoom_NotSync restRoom = new RestRoom_NotSync();
		Person_NotSync p1 = new Person_NotSync("A", restRoom);
		Person_NotSync p2 = new Person_NotSync("B", restRoom);
		Person_NotSync p3 = new Person_NotSync("C", restRoom);
		
		p1.start();
		p2.start();
		p3.start();
	}
}










