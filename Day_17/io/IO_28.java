package io;
import java.io.*;

// 직렬화를 구현한 클래스의 객체가
// 외부로 출력될 경우 출력되는 멤버들
// 1. 일반 멤버들은 모두 출력
//   (접근지정자와는 관계없음)
// 2. final 멤버도 출력됩니다.

//직렬화를 구현한 클래스의 객체가
// 외부로 출력될 경우 출력되지 않는 멤버들
// 1. static 멤버는 외부로 출력되지 않습니다.
// 2. transient 키워드로 선언된 멤버는 출력되지 않습니다. 
//   (transient 키워드는 특정 멤버필드를 직렬화에서 제외하는 역할을 합니다.)
class IO_28_Model implements Serializable {
	// 접근지정자만 서로 다른 일반 멤버필드
	private int num1;
	int num2;
	protected int num3;
	public int num4;
	// final 멤버 필드
	public final int num5;
	// static 필드
	public static int num6;
	// transient 필드
	public transient int num7;
	
	public IO_28_Model(int num1, int num2, int num3, int num4, int num5, int num6, int num7) {	
		this.num1 = num1;
		this.num2 = num2;
		this.num3 = num3;
		this.num4 = num4;
		this.num5 = num5;
		this.num6 = num6;
		this.num7 = num7;
	}
	public void printMembers() {
		System.out.printf("num1 = %d\n", num1);
		System.out.printf("num2 = %d\n", num2);
		System.out.printf("num3 = %d\n", num3);
		System.out.printf("num4 = %d\n", num4);
		System.out.printf("num5 = %d\n", num5);
		System.out.printf("num6 = %d\n", num6);
		System.out.printf("num7 = %d\n", num7);
	}
}
public class IO_28 {
	public static void main(String[] args) {		
		String strFileName = 
			"C:\\work\\sources\\java\\Day_17\\output_object_serializable.txt";
		
		ObjectOutputStream oos;
		
		try {
			oos = new ObjectOutputStream(
					new BufferedOutputStream(
						new FileOutputStream(strFileName)));
			
			IO_28_Model model = new IO_28_Model(10, 20, 30, 40, 50, 60, 70);
			model.printMembers();			
			
			// 직렬화가 구현된 클래스의 객체는
			// 외부로 출력될 수 있습니다.
			oos.writeObject(model);
			
			oos.close();			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}












