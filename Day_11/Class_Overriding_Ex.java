class Super_Ex {
	public int num = 10;
	public void print() {
		System.out.println("Super_Ex.print 메소드 실행");
	}
}
class Sub_Ex extends Super_Ex {
	public int num = 20;
	public void print() {
		System.out.println("Sub_Ex.print 메소드 실행");
	}
}
public class Class_Overriding_Ex {
	public static void main(String[] args) {
		Super_Ex s = new Sub_Ex();
		
		System.out.printf("num = %d\n", s.num);
		s.print();
				
	}
}
