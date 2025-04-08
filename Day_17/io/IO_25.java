package io;
import java.io.*;

class IO_25_Model {
	public int num;
}
public class IO_25 {
	public static void main(String[] args) {
		String strFileName = 
				"C:\\work\\sources\\java\\Day_17\\output_object_custom.txt";
		
		ObjectOutputStream oos;
		
		try {
			oos = new ObjectOutputStream(
					new BufferedOutputStream(
						new FileOutputStream(strFileName)));
			
			IO_25_Model model = new IO_25_Model();
			model.num = 100;
			
			// 사용자 정의 클래스의 객체를 입출력하기 위해서는 직렬화를 구현해야만 합니다.
			// 직렬화 : 객체를 바이트 스트림에 실어서 입출력할 수 있도록 하는 구현
			// Java 의 클래스를 직렬화를 구현하도록 하려면
			// Serializable 인터페이스를 구현해야 합니다.
			
			// 아래의 writeObject 메소드는 직렬화를 구현하지 않은 객체를 출력하기 때문에
			// 예외가 발생하는 것을 확인할 수 있습니다.			
			oos.writeObject(model);
			
			oos.close();			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}







