package io;
import java.io.*;

// 직렬화를 구현하는 사용자 정의 클래스의 선언
// class 클래스명 implements java.io.Serializable
// Serializable 인터페이스는 추상메소드를 포함하고 있지 않기때문에
// 선언만하면 직렬화를 구현할 수 있습니다. 
class IO_26_Model implements Serializable {
	public int num;
}
public class IO_26 {
	public static void main(String[] args) {
		String strFileName = 
				"C:\\work\\sources\\java\\Day_17\\output_object_custom.txt";
		
		ObjectOutputStream oos;
		
		try {
			oos = new ObjectOutputStream(
					new BufferedOutputStream(
						new FileOutputStream(strFileName)));
			
			IO_26_Model model = new IO_26_Model();
			model.num = 100;			
			
			// 직렬화가 구현된 클래스의 객체는
			// 외부로 출력될 수 있습니다.
			oos.writeObject(model);
			
			oos.close();			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}







