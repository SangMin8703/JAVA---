package io;
import java.io.*;
// 문자 출력 스트림
// OutputStreamWriter 클래스를 사용하여 바이트 스트림을 문자 스트림으로 변환할 수 있습니다.

public class IO_17 {
	public static void main(String[] args) {
		String strFileName = 
				"C:\\work\\sources\\java\\Day_17\\output_char.txt";
		
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		
		try {
			// 1 byte 단위로 파일에 출력하는 스트림 객체 생성
			fos = new FileOutputStream(strFileName);
			// 1 byte 단위로 파일에 출력하는 스트림 객체를 문자 스트림으로 변환
			osw = new OutputStreamWriter(fos);
			
			// 바이트 스트림과 마찬가지고 문자의 코드값을 사용하여 출력할 수 있습니다.
			osw.write(48);
			osw.write(65);
			osw.write(97);
			// 문자형 스트림이기 때문에, String 타입을 출력할 수 있습니다.
			osw.write("Hello World");
			
			osw.close();
			
		} catch( IOException e ) {
			e.printStackTrace();
		}

	}
}










