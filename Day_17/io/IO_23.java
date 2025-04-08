package io;
import java.io.*;
public class IO_23 {
	public static void main(String[] args) {
		String strFileName = 
				"C:\\work\\sources\\java\\Day_17\\output_object.txt";
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try {
			// 파일로부터 입력받을 수 있는 바이트 스트림 객체 생성 
			fis = new FileInputStream(strFileName);
			// 파일로부터 입력받을 수 있는 바이트 스트림 객체를 
			// Object 타입을 입력받을 수 있도록 변환
			ois = new ObjectInputStream(fis);
			
			// ObjectInputStream 클래스의 readObject 메소드
			// 스트림에서 객체를 입력받을 수 있는 메소드
			// 리턴 타입은 Object 타입이 반환됩니다.
			// Object 타입이 리턴되기 때문에 반드시 강제 형변환을 통해 객체를 사용해야 합니다.
			// 주의사항
			// 현재 예제와 같이 하나의 파일에 여러 타입의 객체가 저장되어 있는 경우
			// 반드시 출력한 순서대로 읽어야만 문제가 발생하지 않습니다.
			String msg = (String)ois.readObject();
			Integer i = (Integer)ois.readObject();
			Double d = (Double)ois.readObject();
			
			System.out.printf("msg -> %s\n", msg);
			System.out.printf("i -> %d\n", i);
			System.out.printf("d -> %.2f\n", d);
			
			ois.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}






