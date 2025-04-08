package io;
import java.io.*;
public class IO_14 {
	public static void main(String[] args) {
		String strFileName = 
				"C:\\work\\sources\\java\\Day_17\\src\\io\\IO_10.java";
		
		// IO_10.java 파일의 내용을 화면에 출력하세요.
		int input;
		FileInputStream fis = null;
		InputStreamReader isr;
		
		try {
			// 파일의 내용을 1 byte 단위로 입력받는 스트림 객체 생성
			fis = new FileInputStream(strFileName);
			// 파일의 내용을 1 byte 단위로 입력받는 스트림 객체를 사용하여
			// 2 byte 단위로 입력받을 수 있도록 변환
			isr = new InputStreamReader(fis);
			
			while( (input = isr.read()) != -1 )
				System.out.printf("%c", input);
			
			isr.close();			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}







