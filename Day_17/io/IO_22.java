package io;
import java.io.*;
// Java 는 객체를 지향하는 언어입니다.
// Java 프로그램에서 객체를 사용하지 않고서는 프로그램을 작성할 수 가 없습니다.
// Java 프로그램 내부에서 저장되는 대다수의 데이터들은 객체에 포함되어 저장되는 케이스가 많습니다.

// Java 프로그램을 구현 중 저장을 위한 기능을 제공하는 경우 객체 자체를 외부에 출력하고,
// 객체 자체를 읽어오는 경우가 빈번히 발생합니다.

// 객체의 입출력을 위한 바이트 스트림 클래스
// ObjectInputStream, ObjectOutputStream
public class IO_22 {
	public static void main(String[] args) {
		String strFileName = 
				"C:\\work\\sources\\java\\Day_17\\output_object.txt";
		
		String msg = "Hello";
		Integer i = 10;
		Double d = 51.7;
		
		try {
			// 파일에 출력할 수 있는 바이트 스트림 객체
			FileOutputStream fos = new FileOutputStream(strFileName);
			// 파일에 출력할 수 있는 바이트 스트림 객체를 Object 타입을 출력할 수 있도록 변환
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			// ObjectOutputStream 클래스의 writeObject 메소드는
			// Object 타입을 외부에 출력할 수 있는 메소드입니다.
			// Object 타입을 매개변수로 사용하기 때문에 타입에 상관없이 출력할 수 있습니다.
			oos.writeObject(msg);
			oos.writeObject(i);
			oos.writeObject(d);
			
			oos.close();			
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}














